package com.koreai.HRbot.HR.Bot.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koreai.HRbot.HR.Bot.Backend.entity.Employee;
import com.koreai.HRbot.HR.Bot.Backend.repository.EmployeeRepository;
import com.koreai.HRbot.HR.Bot.Backend.service.EmployeeService;

@CrossOrigin(origins = {"*"},  methods= {RequestMethod.GET, RequestMethod.POST},maxAge = 3600)
@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeRepository empRep;

	@GetMapping("{employeeId}")
	ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {

		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee(employeeId));
	}

	@GetMapping("all")
	ResponseEntity<List<Employee>> getEmployee() {
		
		

		return ResponseEntity.status(HttpStatus.OK).body(empRep.findAll());
	}
}
