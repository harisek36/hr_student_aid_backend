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
	private String email;
	private String phoneNumber;

	private boolean completed = false;
	
	// @OneToOne(mappedBy = "student")
	// private Admission admission;
    
	public Student() {
	}

	public Student(String firstName, String lastName, String email, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

//	public Student(String firstName, String lastName, String ssn, String educationLevel, String residency) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.ssn = ssn;
//		this.educationLevel = educationLevel;
//		this.residency = residency;
//		
//	}
	
	

}
