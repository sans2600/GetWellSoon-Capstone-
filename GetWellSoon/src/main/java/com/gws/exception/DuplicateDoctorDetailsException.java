package com.gws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateDoctorDetailsException extends RuntimeException{
	public DuplicateDoctorDetailsException(String message) {
		super(message);
		
	}
}
