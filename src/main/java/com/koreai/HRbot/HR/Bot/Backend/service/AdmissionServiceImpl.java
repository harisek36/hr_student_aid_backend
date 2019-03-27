package com.koreai.HRbot.HR.Bot.Backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreai.HRbot.HR.Bot.Backend.entity.Admission;
import com.koreai.HRbot.HR.Bot.Backend.entity.Student;
import com.koreai.HRbot.HR.Bot.Backend.exception.AdmissionNotfound;
import com.koreai.HRbot.HR.Bot.Backend.repository.AdmissionRepository;

@Service
public class AdmissionServiceImpl implements AdmissionService {

	@Autowired
	AdmissionRepository admissionRepository;

	@Autowired
	StudentService studentService;

	@Override
	public Admission getAdmissionRecordByStudentId(int id) {
		Student student = studentService.getstudent(id);
		return admissionRepository.findByStudent(student);
	}

	@Override
	public Admission saveAdmission(Admission admission) {

		return admissionRepository.save(admission);
	}

	@Override
	public Admission getAdmissionById(int admissionId) {

		return admissionRepository.findById(admissionId)
				.orElseThrow(() -> new AdmissionNotfound("Unable to find admission with ID: " + admissionId));
	}

	@Override
	public boolean isProcessStarted(Admission admission) {
		if(admission == null) {
			return false;
		}
		if(admission.getMajor() != null || admission.getGradLevel() != null || admission.getState() != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isProcessCompleted(Admission admission) {
		if(admission == null) {
			return false;
		}
		if(admission.getMajor() == null || admission.getGradLevel() == null || admission.getState() == null) {
			return false;
		}
		if(admission.getMajor().trim().equals("") || admission.getGradLevel().trim().equals("") || admission.getState().trim().equals("")) {
			return false;
		}
		return true;
	}

}
