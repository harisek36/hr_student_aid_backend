package com.koreai.HRbot.HR.Bot.Backend.service;

import java.util.List;

import com.koreai.HRbot.HR.Bot.Backend.entity.Student;

public interface StudentService {
	Student getstudent(int studentId);
	
	List<Student> getAllStudents();

	Student createStudent(Student student);
	
	Student updatestudent(Student student, int studentId); 

	List<Student> saveAllStudent(List<Student> studentList);
}
