package com.koreai.HRbot.HR.Bot.Backend.controller;

import java.net.URI;
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
import com.koreai.HRbot.HR.Bot.Backend.entity.Reimbursement;
import com.koreai.HRbot.HR.Bot.Backend.service.AdmissionService;

@CrossOrigin(origins = {"*"},  methods= {RequestMethod.GET, RequestMethod.POST},maxAge = 3600)
@RestController
@RequestMapping("admission")
public class AdmissionController {
	
	@Autowired AdmissionService admissionService;
	
	@GetMapping("{admissionId}")
	ResponseEntity<Admission> getReimbursementWithId(@PathVariable int admissionId) {
		
		return ResponseEntity.status(HttpStatus.OK).body(admissionService.getAdmissionById(admissionId));
	}

	@GetMapping("student/{studentId}")
	ResponseEntity<Admission> getAllReimbursementWithEmployeeId(@PathVariable int studentId) {
		
		return ResponseEntity.status(HttpStatus.OK).body(admissionService.getAdmissionRecordByStudentId(studentId));
	}

	@PostMapping
	ResponseEntity<Admission> createReimbursement(@RequestBody Admission admission) {
		
		Admission newAdmission = admissionService.saveAdmission(admission);
		
		newAdmission.setStarted(admissionService.isProcessStarted(newAdmission));
		newAdmission.setCompleted(admissionService.isProcessCompleted(newAdmission));
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newAdmission.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(newAdmission);
	}

	 

}
