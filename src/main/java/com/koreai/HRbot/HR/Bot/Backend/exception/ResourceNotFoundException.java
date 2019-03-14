package com.koreai.HRbot.HR.Bot.Backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NO_CONTENT)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5756184433218355734L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	

}
