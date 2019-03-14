package com.koreai.HRbot.HR.Bot.Backend.controller;

import com.koreai.HRbot.HR.Bot.Backend.entity.Employee;

public interface ReimbursementService {
	Employee getEmployee(int employeeId);

	Employee createEmployee(Employee employee);
}
