package com.koreai.HRbot.HR.Bot.Backend.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.koreai.HRbot.HR.Bot.Backend.entity.Employee;
import com.koreai.HRbot.HR.Bot.Backend.entity.Reimbursement;
import com.koreai.HRbot.HR.Bot.Backend.service.EmployeeService;
import com.koreai.HRbot.HR.Bot.Backend.service.ReimbursementService;


@RestController
public class InitController {
	
	@Autowired EmployeeService employeeService;
	
	@Autowired ReimbursementService reimbursementService;
	
	Faker faker;
	
	@PostConstruct
	void employeeTestCreationInit() {
		faker = new Faker();
		
		//HR		
		Employee HR1 = new Employee(faker.name().firstName(), faker.name().lastName(), "HR", null);
		employeeService.createEmployee(HR1);
		
		//Manager
		Employee manager1 = new Employee(faker.name().firstName(), faker.name().lastName(), "Manager", HR1);
		Employee manager2 = new Employee(faker.name().firstName(), faker.name().lastName(), "Manager", HR1);
		Employee manager3 = new Employee(faker.name().firstName(), faker.name().lastName(), "Manager", HR1);
		Employee manager4 = new Employee(faker.name().firstName(), faker.name().lastName(), "Manager", HR1);
		Employee manager5 = new Employee(faker.name().firstName(), faker.name().lastName(), "Manager", HR1);
		
		List<Employee> managerList = Arrays.asList(manager1, manager2, manager3, manager4, manager5);
		
		Collections.shuffle(managerList);

		employeeService.saveAllEmployee(managerList);
		
		//Employee
		
		Employee employee1 = new Employee(faker.name().firstName(), faker.name().lastName(), "Software Developer", manager1);
		Employee employee2 = new Employee(faker.name().firstName(), faker.name().lastName(), "Software Develope", manager1);

		Employee employee3 = new Employee(faker.name().firstName(), faker.name().lastName(), "Operations Analyst", manager2);
		Employee employee4 = new Employee(faker.name().firstName(), faker.name().lastName(), "Operations Analyst", manager2);

		Employee employee5 = new Employee(faker.name().firstName(), faker.name().lastName(), "Graphic Designer", manager3);
		Employee employee6 = new Employee(faker.name().firstName(), faker.name().lastName(), "Graphic Designer", manager3);

		Employee employee7 = new Employee(faker.name().firstName(), faker.name().lastName(), "Hardware Engineer", manager4);
		Employee employee8 = new Employee(faker.name().firstName(), faker.name().lastName(), "Hardware Engineer", manager4);

		Employee employee9 = new Employee(faker.name().firstName(), faker.name().lastName(), "Web Designer", manager5);
		Employee employee10 = new Employee(faker.name().firstName(), faker.name().lastName(), "Web Designer", manager5);

		List<Employee> employeeList = Arrays.asList(employee1, employee2, employee3, employee4, employee5, employee6, employee7, employee8, employee9, employee10);
		
		Collections.shuffle(employeeList);

		employeeService.saveAllEmployee(employeeList);
		
		
		//Reimbursement
		
		Reimbursement reimbursement1 = new Reimbursement("Meal", LocalDate.now(), employee1, employee1.getId(), "PENDING", "Cient meeting at Location", "");
		reimbursementService.saveReimbursement(reimbursement1);
	}

}

