package com.koreai.HRbot.HR.Bot.Backend.entity;

import lombok.Data;

@Data
public class StudentLoginStatus {
	public static int currentStudet = 1000;
	Student student;
	boolean loggedIn;

	public StudentLoginStatus() {
	}

}
