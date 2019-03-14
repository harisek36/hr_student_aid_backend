package com.koreai.HRbot.HR.Bot.Backend.service;

import java.util.List;

import com.koreai.HRbot.HR.Bot.Backend.entity.Employee;

public interface EmployeeService {
	Employee getEmployee(int employeeId);

	Employee createEmployee(Employee employee);
	
	List<Employee> saveAllEmployee(List<Employee> employeeList);
}
