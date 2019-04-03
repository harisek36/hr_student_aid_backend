package com.koreai.HRbot.HR.Bot.Backend.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.koreai.HRbot.HR.Bot.Backend.entity.Admission;
import com.koreai.HRbot.HR.Bot.Backend.entity.EducationLevel;
import com.koreai.HRbot.HR.Bot.Backend.entity.EducationMajor;
import com.koreai.HRbot.HR.Bot.Backend.entity.Employee;
import com.koreai.HRbot.HR.Bot.Backend.entity.Residency;
import com.koreai.HRbot.HR.Bot.Backend.entity.ResidencyStatus;
import com.koreai.HRbot.HR.Bot.Backend.entity.Student;
import com.koreai.HRbot.HR.Bot.Backend.service.AdmissionService;
import com.koreai.HRbot.HR.Bot.Backend.service.EmployeeService;
import com.koreai.HRbot.HR.Bot.Backend.service.ReimbursementService;
import com.koreai.HRbot.HR.Bot.Backend.service.StudentService;

@CrossOrigin(origins = { "*" }, methods = { RequestMethod.GET, RequestMethod.POST }, maxAge = 3600)
@RestController
public class InitController {

	private static int MANAGER_COUNT = 5;
	private static int EMPLOYEE_UNDER_MANAGER_COUNT = 15;
	private static int STUDENT_COUNT = 5;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ReimbursementService reimbursementService;

	@Autowired
	StudentService studentService;
	
	@Autowired AdmissionService admissionService;

	Faker faker;
	
	@GetMapping
	String appStart() {
		return "Student Aid Backend Service";
	}
	

	@PostConstruct
	void employeeTestCreationInit() throws IllegalArgumentException, IllegalAccessException {
		faker = new Faker();
//		Random rand = new Random();

//		List<String> employeeJobDescribtionList = Arrays.asList("Software Developer", "Operations Analyst",
//				"Graphic Designer", "Hardware Engineer", "Web Designer");
//		List<Employee> managerList = new ArrayList<Employee>();
//
//		// HR
//		Employee HR1 = new Employee(faker.name().firstName(), faker.name().lastName(), "HR", null);
//		employeeService.createEmployee(HR1);
//
//		// Manager
//
//		for (int i = 1; i <= MANAGER_COUNT; i++) {
//			Employee employee = new Employee(faker.name().firstName(), faker.name().lastName(), "Manager", HR1);
//			managerList.add(employeeService.createEmployee(employee));
//		}
//
//		// Employee
//
//		for (int i = 1; i <= EMPLOYEE_UNDER_MANAGER_COUNT; i++) {
//			Employee employee = new Employee(faker.name().firstName(), faker.name().lastName(),
//					employeeJobDescribtionList.get(rand.nextInt(employeeJobDescribtionList.size())),
//					managerList.get(rand.nextInt(managerList.size())));
//			managerList.add(employeeService.createEmployee(employee));
//		}

		// student
		
		String fName = "";
		String lName = "";
		String email =  "";
		Student student;
//
//		Student student = new Student("Dana", "Casper", "dana.casper@gmail.com", faker.phoneNumber().cellPhone());
//		student.setCompleted(studentService.validateStudentObject(student));
//		Student studentCreated =  studentService.createStudent(student);
//		
//
//		Admission admission = new Admission(EducationLevel.randomEducationLevel(), ResidencyStatus.randomResidencyStatus(), EducationMajor.randomEducationMajor(),studentCreated.getId());
//		admission.setStarted(admissionService.isProcessStarted(admission));
//		admission.setCompleted(admissionService.isProcessCompleted(admission));
//		admissionService.saveAdmission(admission);
		
		for (int i = 1; i <= STUDENT_COUNT; i++) {
			fName = faker.name().firstName();
			lName = faker.name().lastName();
			email = fName.toLowerCase() + "." + lName.toLowerCase() + "@gmail.com";
			student = new Student(fName, lName, email, faker.phoneNumber().cellPhone());
			student.setCompleted(studentService.validateStudentObject(student));
			Student studentCreated =  studentService.createStudent(student);
			

			Admission admission = new Admission(EducationLevel.randomEducationLevel(), ResidencyStatus.randomResidencyStatus(), EducationMajor.randomEducationMajor(),studentCreated.getId());
			admission.setStarted(admissionService.isProcessStarted(admission));
			admission.setCompleted(admissionService.isProcessCompleted(admission));
			admissionService.saveAdmission(admission);
		}
		
		
//		student = new Student("Ram", null, "ram.kumar@gmail.com", faker.phoneNumber().cellPhone());
//		student.setCompleted(studentService.validateStudentObject(student));
//		studentCreated =  studentService.createStudent(student);
//		
//
//		admission = new Admission(EducationLevel.randomEducationLevel(), ResidencyStatus.randomResidencyStatus(), null,studentCreated.getId());
//		admission.setStarted(admissionService.isProcessStarted(admission));
//		admission.setCompleted(admissionService.isProcessCompleted(admission));
//		admissionService.saveAdmission(admission);
//	
//		fName = faker.name().firstName();
//		lName = faker.name().lastName();
//		email =  fName.toLowerCase() + "." + lName.toLowerCase() + "@gmail.com";
//		
//		student = new Student(fName, lName, email, faker.phoneNumber().cellPhone());
//		student.setCompleted(studentService.validateStudentObject(student));
//		studentCreated =  studentService.createStudent(student);
//		
//
//		admission = new Admission(EducationLevel.randomEducationLevel(), ResidencyStatus.randomResidencyStatus(), EducationMajor.randomEducationMajor(),studentCreated.getId());
//		admission.setStarted(admissionService.isProcessStarted(admission));
//		admission.setCompleted(admissionService.isProcessCompleted(admission));
//		admissionService.saveAdmission(admission);
//	
//		fName = faker.name().firstName();
//		lName = faker.name().lastName();
//		email =  fName.toLowerCase() + "." + lName.toLowerCase() + "@gmail.com";
//		
//		student = new Student(fName, lName, email, faker.phoneNumber().cellPhone());
//		student.setCompleted(studentService.validateStudentObject(student));
//		studentCreated =  studentService.createStudent(student);
//		
//
//		admission = new Admission(EducationLevel.randomEducationLevel(), ResidencyStatus.randomResidencyStatus(), EducationMajor.randomEducationMajor(),studentCreated.getId());
//		admission.setStarted(admissionService.isProcessStarted(admission));
//		admission.setCompleted(admissionService.isProcessCompleted(admission));
//		admissionService.saveAdmission(admission);
//	
//		fName = faker.name().firstName();
//		lName = faker.name().lastName();
//		email =  fName.toLowerCase() + "." + lName.toLowerCase() + "@gmail.com";
//		
//		student = new Student(fName, lName, email, faker.phoneNumber().cellPhone());
//		student.setCompleted(studentService.validateStudentObject(student));
//		studentCreated =  studentService.createStudent(student);
//		
//
//		admission = new Admission(EducationLevel.randomEducationLevel(), ResidencyStatus.randomResidencyStatus(), EducationMajor.randomEducationMajor(),studentCreated.getId());
//		admission.setStarted(admissionService.isProcessStarted(admission));
//		admission.setCompleted(admissionService.isProcessCompleted(admission));
//		admissionService.saveAdmission(admission);
//	
//	
//		
//		
//		fName = faker.name().firstName();
//		lName = faker.name().lastName();
//		email =  fName.toLowerCase() + "." + lName.toLowerCase() + "@gmail.com";
//		
//		student = new Student(fName, lName, email, faker.phoneNumber().cellPhone());
//		student.setCompleted(studentService.validateStudentObject(student));
//		studentCreated =  studentService.createStudent(student);
//		
//
//		admission = new Admission(EducationLevel.randomEducationLevel(), ResidencyStatus.randomResidencyStatus(), EducationMajor.randomEducationMajor(),studentCreated.getId());
//		admission.setStarted(admissionService.isProcessStarted(admission));
//		admission.setCompleted(admissionService.isProcessCompleted(admission));
//		admissionService.saveAdmission(admission);
	}

	String randomSSN() {

		long timeSeed = System.nanoTime();
		double randSeed = Math.random() * 1000;
		long midSeed = (long) (timeSeed * randSeed);

		String s = midSeed + "";

		return s.substring(0, 9);
	}

}
