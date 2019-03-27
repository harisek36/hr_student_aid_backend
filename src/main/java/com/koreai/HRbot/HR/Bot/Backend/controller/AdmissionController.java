package com.koreai.HRbot.HR.Bot.Backend.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.koreai.HRbot.HR.Bot.Backend.entity.Admission;
import com.koreai.HRbot.HR.Bot.Backend.entity.Student;
import com.koreai.HRbot.HR.Bot.Backend.entity.StudentRemainder;
import com.koreai.HRbot.HR.Bot.Backend.service.AdmissionService;
import com.koreai.HRbot.HR.Bot.Backend.service.StudentService;

@CrossOrigin(origins = {"*"},  methods= {RequestMethod.GET, RequestMethod.POST},maxAge = 3600)
@RestController
@RequestMapping("admission")
public class AdmissionController {
	
	@Autowired AdmissionService admissionService;
	
	@Autowired StudentService studentService;
	
	@GetMapping("{admissionId}")
	ResponseEntity<Admission> getAdmissionWithId(@PathVariable int admissionId) {
		
		return ResponseEntity.status(HttpStatus.OK).body(admissionService.getAdmissionById(admissionId));
	}

	@GetMapping("student/{studentId}")
	ResponseEntity<Admission> getAlladmissionWithStudentId(@PathVariable int studentId) {
		
		return ResponseEntity.status(HttpStatus.OK).body(admissionService.getAdmissionRecordByStudentId(studentId));
	}

	@PostMapping
	ResponseEntity<Admission> createadmission(@RequestBody Admission admission) {
		
		studentService.getstudent(admission.getStudent());

		
		Admission newAdmission = admissionService.saveAdmission(admission);
		
		newAdmission.setStarted(admissionService.isProcessStarted(newAdmission));
		newAdmission.setCompleted(admissionService.isProcessCompleted(newAdmission));
		
		Admission finalAdmission = admissionService.saveAdmission(newAdmission);

				
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newAdmission.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(finalAdmission);
	}
	
	@GetMapping("{admissionId}/remainder")
	StudentRemainder getAdmissionRemainder(@PathVariable int admissionId) {
		
		StudentRemainder studentRemainder = new StudentRemainder();
		
		List<String> remainderText = new ArrayList<>();
		Admission admission = admissionService.getAdmissionById(admissionId);
		
		if(admission != null && admission.getMajor() != null && admission.getGradLevel() != null) {
			
			remainderText.add("Application deadline for " + admission.getMajor() + "major " + admission.getGradLevel()
			+ " student is " + LocalDate.now().plusDays(30).toString());
			
			remainderText.add("Number of LOR's (Letter of Recomendations) required: 3");
			
			remainderText.add("LOR deadline for " + admission.getMajor() + "major student is " + LocalDate.now().plusDays(40).toString());
		}
		
		studentRemainder.setRemainderList(remainderText);
		
		return studentRemainder;
	}
	
	@GetMapping("student/{studentId}/remainder")
	StudentRemainder getAdmissionRemainderByStudentId(@PathVariable int studentId) {
		
		StudentRemainder studentRemainder = new StudentRemainder();
		
		List<String> remainderText = new ArrayList<>();
		Admission admission = admissionService.getAdmissionRecordByStudentId(studentId);
		
		if(admission != null && admission.getMajor() != null && admission.getGradLevel() != null) {
			
			remainderText.add("Application deadline for " + admission.getMajor() + "major " + admission.getGradLevel()
			+ " student is " + LocalDate.now().plusDays(30).toString());
			
			remainderText.add("Number of LOR's (Letter of Recomendations) required: 3");
			
			remainderText.add("LOR deadline for " + admission.getMajor() + "major student is " + LocalDate.now().plusDays(40).toString());
		}
		
		studentRemainder.setRemainderList(remainderText);
		
		return studentRemainder;
	}

}
