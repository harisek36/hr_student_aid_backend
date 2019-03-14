package com.koreai.HRbot.HR.Bot.Backend.service;

import java.util.List;

import com.koreai.HRbot.HR.Bot.Backend.entity.Reimbursement;

public interface ReimbursementService {

	List<Reimbursement> getAllReimbursementByEmpId(int id);
	Reimbursement getReimbursementById(int id);
	Reimbursement saveReimbursement(Reimbursement reimbursement1);
}
