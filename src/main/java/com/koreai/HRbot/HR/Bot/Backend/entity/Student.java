package com.koreai.HRbot.HR.Bot.Backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String ssn;
	private String educationLevel;
	private String residency;
	private boolean completed;

	public Student() {
	}

	public Student(String firstName, String lastName, String ssn, String educationLevel, String residency) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.educationLevel = educationLevel;
		this.residency = residency;
	}

}
