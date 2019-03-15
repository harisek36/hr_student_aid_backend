package com.koreai.HRbot.HR.Bot.Backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreai.HRbot.HR.Bot.Backend.entity.Employee;
import com.koreai.HRbot.HR.Bot.Backend.entity.Reimbursement;
import com.koreai.HRbot.HR.Bot.Backend.exception.InvalidReimbursementRequest;
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
		validateReimbursementRequest(reimbursement);
		return reimbursementRepository.save(reimbursement);			
				
	}

	private void validateReimbursementRequest(Reimbursement reimbursement) {
		if(reimbursement == null) {
			throw new InvalidReimbursementRequest("Input Reinbursement cannot be NULL");
		}
		
		Optional<Employee> submitter = Optional.ofNullable(employeeService.getEmployee(reimbursement.getSubmitterId()));
		Optional<Employee> receiver  = Optional.ofNullable(employeeService.getEmployee(reimbursement.getReceiverId()));
		
		if(submitter.isPresent() && receiver.isPresent()) {
			if(submitter.get().getDesignation().equals(receiver.get().getDesignation())) {
				throw new InvalidReimbursementRequest("An Emplopyee Cannot submit reimbursement for another employee who carries same designation.");
			}
		}
		
		
		
		
	}

}
