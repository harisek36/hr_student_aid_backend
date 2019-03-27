package com.koreai.HRbot.HR.Bot.Backend.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Data;

@Data
@Entity
public class Admission {
	@Id
	@GeneratedValue
	private int id;
	private String gradLevel;
	private String state;
	private String major;
	private boolean completed = false;
	private boolean started = false;

	private int student;

	public Admission() {
	}

	public Admission(String gradLevel, String state, String major, int studentId) {
		super();
		this.gradLevel = gradLevel;
		this.state = state;
		this.major = major;
		this.student = studentId;
	}


}
