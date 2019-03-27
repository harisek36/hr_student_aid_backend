package com.koreai.HRbot.HR.Bot.Backend.service;

import java.util.List;

import com.koreai.HRbot.HR.Bot.Backend.entity.Admission;

public interface AdmissionService {

	Admission getAdmissionRecordByStudentId(int id);

	Admission saveAdmission(Admission admission);

	Admission getAdmissionById(int admissionId);
	
	boolean isProcessStarted(Admission admission);
	
	boolean isProcessCompleted(Admission admission);
	
	void setRemainderString(Admission admission); 
}
