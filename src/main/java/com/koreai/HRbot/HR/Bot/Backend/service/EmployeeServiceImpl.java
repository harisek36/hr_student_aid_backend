package com.koreai.HRbot.HR.Bot.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreai.HRbot.HR.Bot.Backend.entity.Employee;
import com.koreai.HRbot.HR.Bot.Backend.exception.EmployeeNotfoundException;
import com.koreai.HRbot.HR.Bot.Backend.exception.ResourceNotFoundException;
import com.koreai.HRbot.HR.Bot.Backend.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee getEmployee(int employeeId) {
		return employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotfoundException("Employee with ID: " + employeeId + " does not exist"));
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> saveAllEmployee(List<Employee> employeeList) {
		if(employeeList.isEmpty())
			throw new ResourceNotFoundException("Employee list cannot be EMPTY");
		return employeeRepository.saveAll(employeeList);
	}
	

}
