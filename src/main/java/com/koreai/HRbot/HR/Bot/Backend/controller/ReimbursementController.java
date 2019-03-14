package com.koreai.HRbot.HR.Bot.Backend.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.koreai.HRbot.HR.Bot.Backend.entity.Reimbursement;
import com.koreai.HRbot.HR.Bot.Backend.service.ReimbursementService;

@RestController
@RequestMapping("reimbursement")
public class ReimbursementController {

	@Autowired
	ReimbursementService reimbursementService;

	@GetMapping("{reimbursementId}")
	ResponseEntity<Reimbursement> getReimbursementWithId(@PathVariable int reimbursementId) {
		return ResponseEntity.status(HttpStatus.OK).body(reimbursementService.getReimbursementById(reimbursementId));
	}

	@GetMapping("employee/{employeeId}")
	ResponseEntity<List<Reimbursement>> getAllReimbursementWithEmployeeId(@PathVariable int employeeId) {
		return ResponseEntity.status(HttpStatus.OK).body(reimbursementService.getAllReimbursementByEmpId(employeeId));
	}

	@PostMapping
	ResponseEntity<Object> createReimbursement(@RequestBody Reimbursement reimbursementRequest) {
		Reimbursement reimbursement = reimbursementService.saveReimbursement(reimbursementRequest);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(reimbursement.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
	}

}
