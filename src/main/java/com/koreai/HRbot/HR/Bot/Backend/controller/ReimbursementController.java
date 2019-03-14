package com.koreai.HRbot.HR.Bot.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreai.HRbot.HR.Bot.Backend.entity.Employee;
import com.koreai.HRbot.HR.Bot.Backend.service.ReimbursementService;

@RestController
@RequestMapping("reimbursement")
public class ReimbursementController {

	@Autowired
	ReimbursementService reimbursementService;

	@GetMapping("{employeeId}")
	ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {

		Employee employee = new Employee();
		Employee manager = new Employee();

		employee.setFirstName("John");
		employee.setLastName("Rothwell");
		employee.setDesignation("Manager");
		employee.setManager(manager);

		reimbursementService.createEmployee(employee);

		return ResponseEntity.status(HttpStatus.OK).body(reimbursementService.getEmployee(employeeId));
	}
	


}
