package com.koreai.HRbot.HR.Bot.Backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreai.HRbot.HR.Bot.Backend.entity.Employee;
import com.koreai.HRbot.HR.Bot.Backend.entity.Reimbursement;
import com.koreai.HRbot.HR.Bot.Backend.exception.InvalidreimbursementId;
import com.koreai.HRbot.HR.Bot.Backend.repository.ReimbursementRepository;

@Service
public class ReimbursementServiceImpl implements ReimbursementService {

	@Autowired
	ReimbursementRepository reimbursementRepository;

	@Autowired
	EmployeeService employeeService;

	@Override
	public List<Reimbursement> getAllReimbursementByEmpId(int id) {

		Employee employee = employeeService.getEmployee(id);
		return reimbursementRepository.findAll().stream().filter(reimb -> reimb.getReceiverId() == employee.getId())
				.collect(Collectors.toList());
	}

	@Override
	public Reimbursement getReimbursementById(int id) {

		return reimbursementRepository.findById(id)
				.orElseThrow(() -> new InvalidreimbursementId("Reimbursement not found with ID :" + id));
	}

	@Override
	public Reimbursement saveReimbursement(Reimbursement reimbursement) {
		return reimbursementRepository.save(reimbursement);
	}

}
