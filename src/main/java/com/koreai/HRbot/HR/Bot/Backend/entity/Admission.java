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

	@Transient
	private List<String> remainderText = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private Student student;

	public Admission() {
	}

	public Admission(String gradLevel, String state, String major, Student student) {
		super();
		this.gradLevel = gradLevel;
		this.state = state;
		this.major = major;
		this.student = student;
	}

	public void setRemainderWithDefaultValues() {

	
		remainderText.add("Application deadline for " + this.getMajor() + "major " + this.getGradLevel()
		+ " student is " + LocalDate.now().plusDays(30).toString());
	
		remainderText.add("Number of LOR's (Letter of Recomendations) required: 3");

	}

}
