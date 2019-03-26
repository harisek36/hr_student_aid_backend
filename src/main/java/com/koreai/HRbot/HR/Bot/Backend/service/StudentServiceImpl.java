package com.koreai.HRbot.HR.Bot.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreai.HRbot.HR.Bot.Backend.entity.Student;
import com.koreai.HRbot.HR.Bot.Backend.exception.StudentNotFound;
import com.koreai.HRbot.HR.Bot.Backend.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student getstudent(int studentId) {
		return studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentNotFound("Student not found with ID: " + studentId));
	}

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updatestudent(Student updatedStudent, int studentId) {
		return studentRepository.findById(studentId).map(student -> {
			student.setFirstName(updatedStudent.getFirstName());
			student.setLastName(updatedStudent.getLastName());
			student.setSsn(updatedStudent.getSsn());
			student.setResidency(updatedStudent.getResidency());
			student.setEducationLevel(updatedStudent.getEducationLevel());
			return studentRepository.save(student);
		}).orElseThrow(() -> new StudentNotFound("Student not found with ID: " + updatedStudent.getId()));
	}

	@Override
	public List<Student> saveAllStudent(List<Student> studentList) {
		return studentRepository.saveAll(studentList);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

}
