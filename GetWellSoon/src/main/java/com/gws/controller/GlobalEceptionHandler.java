package com.gws.controller;

import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gws.exception.DuplicatePatientDetailslException;
import com.gws.exception.PatientNotFoundException;
import com.gws.model.ErrorModel;
@RestControllerAdvice

public class GlobalEceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(DuplicatePatientDetailslException.class)
	public ResponseEntity<ErrorModel> handleDuplocateEmployeeDetailsFoundException(DuplicatePatientDetailslException ex, WebRequest req)
	{
		ErrorModel model = new ErrorModel(new Date(), ex.getMessage(),HttpStatus.CONFLICT.value(),req.getDescription(false));
		
		
		
		return new ResponseEntity<ErrorModel>(model,HttpStatus.CONFLICT);
		
	}
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<ErrorModel> handleDuplocateEmployeeNotFoundException(PatientNotFoundException ex, WebRequest req)
	{
		ErrorModel model = new ErrorModel(new Date(), ex.getMessage(),HttpStatus.NOT_FOUND.value(),req.getDescription(false));
		
		
		
		return new ResponseEntity<ErrorModel>(model,HttpStatus.NOT_FOUND);
		
	}

}
