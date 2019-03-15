package com.koreai.HRbot.HR.Bot.Backend.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Reimbursement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String type;
	LocalDate receiptDate;

	int submitterId;
	int receiverId;

	String status;
	String submitterComment;
	String approverComment;

	public Reimbursement() {
	}

	public Reimbursement(String type, LocalDate receiptDate, int submitter, int receiverId, String status,
			String submitterComment, String approverComment) {
		this.type = type;
		this.receiptDate = receiptDate;
		this.submitterId = submitter;
		this.receiverId = receiverId;
		this.status = status;
		this.submitterComment = submitterComment;
		this.approverComment = approverComment;
	}

}
