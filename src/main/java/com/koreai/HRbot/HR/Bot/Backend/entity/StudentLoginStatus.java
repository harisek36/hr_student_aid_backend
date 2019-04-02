package com.koreai.HRbot.HR.Bot.Backend.entity;

import lombok.Data;

@Data
public class StudentLoginStatus {
	public static int currentStudet = 1001;
	Student student;
	boolean loggedIn;

	public StudentLoginStatus() {
	}

}
