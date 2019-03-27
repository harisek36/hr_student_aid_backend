package com.koreai.HRbot.HR.Bot.Backend.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class StudentRemainder {
	private List<String> remainderList = new ArrayList<>();

	public StudentRemainder() {
		super();
	}
	
	
}
