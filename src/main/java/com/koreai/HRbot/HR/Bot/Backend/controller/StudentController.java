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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.koreai.HRbot.HR.Bot.Backend.entity.Student;
import com.koreai.HRbot.HR.Bot.Backend.entity.StudentLoginStatus;
import com.koreai.HRbot.HR.Bot.Backend.service.StudentService;

@CrossOrigin(origins = { "*" }, methods = { RequestMethod.GET, RequestMethod.POST }, maxAge = 3600)
@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("{studentId}")
	ResponseEntity<Student> getStudentWithId(@PathVariable int studentId) throws IllegalArgumentException, IllegalAccessException {
		Student student = studentService.getstudent(studentId);
		student.setCompleted(studentService.validateStudentObject(student));
		
		if(student != null) {
			StudentLoginStatus.currentStudet = studentId;
		}

		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	
	@GetMapping
	ResponseEntity<List<Student>> getAllStudent() {

		return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
	}
	

	@PostMapping
	ResponseEntity<Student> createStudent(@RequestBody Student newStudent) throws IllegalArgumentException, IllegalAccessException {
		
		newStudent.setCompleted(studentService.validateStudentObject(newStudent));
		
		Student savedStudent = studentService.createStudent(newStudent);
		
		if(savedStudent != null) {
			StudentLoginStatus.currentStudet = savedStudent.getId();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getId()).toUri();

		return ResponseEntity.created(location).body(savedStudent);
	}
	
	@PutMapping("{studentId}")
	ResponseEntity<Student> updateStudent(@RequestBody Student updatedStudent, @PathVariable int studentId) {
		studentService.updatestudent(updatedStudent, studentId);
		return ResponseEntity.noContent().build();
	}

}
