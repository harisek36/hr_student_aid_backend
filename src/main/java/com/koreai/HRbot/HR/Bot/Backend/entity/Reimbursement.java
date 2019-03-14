package com.koreai.HRbot.HR.Bot.Backend.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Reimbursement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String type;
	LocalDate receiptDate;
	
	@ManyToOne
	@JoinColumn(name = "submitter_id")
	Employee submitter;
	int receiverId;
	String status;
	String submitterComment;
	String approverComment;
	
	public Reimbursement() {
	}

	public Reimbursement(String type, LocalDate receiptDate, Employee submitter, int receiverId, String status,
			String submitterComment, String approverComment) {
		this.type = type;
		this.receiptDate = receiptDate;
		this.submitter = submitter;
		this.receiverId = receiverId;
		this.status = status;
		this.submitterComment = submitterComment;
		this.approverComment = approverComment;
	}

}
