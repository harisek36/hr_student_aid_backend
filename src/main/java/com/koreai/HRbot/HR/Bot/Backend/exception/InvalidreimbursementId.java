package com.koreai.HRbot.HR.Bot.Backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class InvalidreimbursementId extends RuntimeException {

	private static final long serialVersionUID = 1799063943715765296L;

	public InvalidreimbursementId(String message) {
		super(message);
	}

}
