package com.koreai.HRbot.HR.Bot.Backend.entity;

import lombok.Data;

@Data
public class StudentLoginStatus {
	Student student;
	boolean loggedIn;

	public StudentLoginStatus() {
	}

}
