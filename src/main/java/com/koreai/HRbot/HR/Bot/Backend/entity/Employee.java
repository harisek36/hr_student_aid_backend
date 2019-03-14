package com.koreai.HRbot.HR.Bot.Backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String designation;

	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Employee manager;

	public Employee() {
	}

	public Employee(String firstName, String lastName, String designation, Employee manager) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.manager = manager;
	}
	
	

}
