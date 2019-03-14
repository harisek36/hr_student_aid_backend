package com.koreai.HRbot.HR.Bot.Backend.service;

import com.koreai.HRbot.HR.Bot.Backend.entity.Employee;

public interface ReimbursementService {
	Employee getEmployee(int employeeId);

	Employee createEmployee(Employee employee);
}
