package com.koreai.HRbot.HR.Bot.Backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Student {
	
	public static int idInit = 1000;

	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;

	private boolean completed = false;
	    
	public Student() {
		this.id = idInit + 1;
		idInit = idInit + 1;
	}

	public Student(String firstName, String lastName, String email, String phoneNumber) {
		this.id = idInit + 1;
		idInit = idInit + 1;
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
