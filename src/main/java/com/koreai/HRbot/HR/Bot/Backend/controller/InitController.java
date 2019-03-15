package com.koreai.HRbot.HR.Bot.Backend.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.koreai.HRbot.HR.Bot.Backend.entity.Employee;
import com.koreai.HRbot.HR.Bot.Backend.service.EmployeeService;
import com.koreai.HRbot.HR.Bot.Backend.service.ReimbursementService;

@RestController
public class InitController {

	private static int MANAGER_COUNT = 5;
	private static int EMPLOYEE_UNDER_MANAGER_COUNT = 15;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ReimbursementService reimbursementService;

	Faker faker;

	@PostConstruct
	void employeeTestCreationInit() {
		faker = new Faker();
		Random rand = new Random();

		List<String> employeeJobDescribtionList = Arrays.asList("Software Developer", "Operations Analyst",
				"Graphic Designer", "Hardware Engineer", "Web Designer");
		List<Employee> managerList = new ArrayList<Employee>();

		// HR
		Employee HR1 = new Employee(faker.name().firstName(), faker.name().lastName(), "HR", null);
		employeeService.createEmployee(HR1);

		// Manager

		for (int i = 1; i <= MANAGER_COUNT; i++) {
			Employee employee = new Employee(faker.name().firstName(), faker.name().lastName(), "Manager", HR1);
			managerList.add(employeeService.createEmployee(employee));
		}

		// Employee

		for (int i = 1; i <= EMPLOYEE_UNDER_MANAGER_COUNT; i++) {
			Employee employee = new Employee(faker.name().firstName(), faker.name().lastName(),
					employeeJobDescribtionList.get(rand.nextInt(employeeJobDescribtionList.size())),
					managerList.get(rand.nextInt(managerList.size())));
			managerList.add(employeeService.createEmployee(employee));
		}

		// Reimbursement

		// Reimbursement reimbursement1 = new Reimbursement("Meal", LocalDate.now(),
		// employee1.getId(), employee1.getId(), "PENDING", "Cient meeting at Location",
		// "");
		// reimbursementService.saveReimbursement(reimbursement1);
	}

}
