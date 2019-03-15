package com.koreai.HRbot.HR.Bot.Backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class InvalidReimbursementRequest extends RuntimeException {

	private static final long serialVersionUID = -7368579999580349284L;

	public InvalidReimbursementRequest(String message) {
		super(message);
	}

}
