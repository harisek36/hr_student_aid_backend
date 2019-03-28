package com.koreai.HRbot.HR.Bot.Backend.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreai.HRbot.HR.Bot.Backend.entity.Admission;
import com.koreai.HRbot.HR.Bot.Backend.entity.Student;
import com.koreai.HRbot.HR.Bot.Backend.exception.AdmissionNotfound;
import com.koreai.HRbot.HR.Bot.Backend.exception.StudentNotFound;
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
		Admission admission = admissionRepository.findByStudent(student.getId());
		
		if( admission == null) {
			throw new AdmissionNotfound("admission not found with Student ID" + id);
		}
		return admission;
	}

	@Override
	public Admission saveAdmission(Admission admission) {

		Student student = studentService.getstudent(admission.getStudent());

		if (student == null) {
			throw new StudentNotFound("Cannot create admission without student information");
		}
		
		Admission oldadmission = admissionRepository.findByStudent(student.getId());
		
		if(oldadmission != null) {
			admissionRepository.delete(oldadmission);
		}

		return admissionRepository.save(admission);
	}

	@Override
	public Admission getAdmissionById(int admissionId) {

		return admissionRepository.findById(admissionId)
				.orElseThrow(() -> new AdmissionNotfound("Unable to find admission with ID: " + admissionId));
	}

	@Override
	public boolean isProcessStarted(Admission admission) {
		if (admission == null) {
			return false;
		}
		if (admission.getMajor() != null || admission.getGradLevel() != null || admission.getState() != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isProcessCompleted(Admission admission) {
		if (admission == null) {
			return false;
		}
		if (admission.getMajor() == null || admission.getGradLevel() == null || admission.getState() == null) {
			return false;
		}
		if (admission.getMajor().trim().equals("") || admission.getGradLevel().trim().equals("")
				|| admission.getState().trim().equals("")) {
			return false;
		}
		return true;
	}

	@Override
	public void setRemainderString(Admission admission) {
		
		List<String> remainderList = new ArrayList<>();

		String remainder = "";
		if (admission != null) {
			remainder = "Application deadline for " + admission.getMajor() + "major " + admission.getGradLevel()
					+ " student is " + LocalDate.now().plusDays(30).toString();
			remainderList.add(remainder);
			remainder = "Number of LOR's (Letter of Recomendations) required: 3";
			remainderList.add(remainder);
		}
		
	}

}
