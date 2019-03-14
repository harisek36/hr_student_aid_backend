package com.koreai.HRbot.HR.Bot.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreai.HRbot.HR.Bot.Backend.entity.Employee;
import com.koreai.HRbot.HR.Bot.Backend.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("{employeeId}")
	ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {

		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee(employeeId));
	}

}
