package com.koreai.HRbot.HR.Bot.Backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koreai.HRbot.HR.Bot.Backend.entity.Student;
import com.koreai.HRbot.HR.Bot.Backend.entity.StudentLoginStatus;

@CrossOrigin(origins = { "*" }, methods = { RequestMethod.GET, RequestMethod.POST }, maxAge = 3600)
@RestController
@RequestMapping("currentStudent")
public class CurrentStudent {

	StudentLoginStatus currentStudentStatus = new StudentLoginStatus();

	@GetMapping
	StudentLoginStatus getCurrentStudent() {

		return currentStudentStatus;
	}
	
	@GetMapping("reset")
	boolean initCurrentStudnt() {
		
		StudentLoginStatus.currentStudet = 0;
		return true;
	}

	@PostMapping("login")
	StudentLoginStatus signInStudent(@RequestBody Student student) {

		if (student != null && currentStudentStatus.getStudent() == null) {

			this.currentStudentStatus.setStudent(student);
			this.currentStudentStatus.setLoggedIn(true);
		} else if (currentStudentStatus.getStudent() != null) {
			return this.currentStudentStatus;
		}

		return this.currentStudentStatus;
	}

	@GetMapping("logout")
	StudentLoginStatus logOutStudent() {

		this.currentStudentStatus.setLoggedIn(false);
		this.currentStudentStatus.setStudent(null);
		return this.currentStudentStatus;
	}

}
