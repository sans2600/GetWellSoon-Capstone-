package com.gws.controller;

import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gws.exception.AppointmentNotFoundException;
import com.gws.exception.DoctorNotFoundException;
import com.gws.exception.DuplicateDoctortDetailslException;
import com.gws.exception.DuplicatePatientDetailslException;
import com.gws.exception.PatientNotFoundException;
import com.gws.model.ErrorModel;
@RestControllerAdvice

public class GlobalEceptionHandler extends ResponseEntityExceptionHandler {
	
	//patient
	@ExceptionHandler(DuplicatePatientDetailslException.class)
	public ResponseEntity<ErrorModel> handleDuplicatePatientDetailsFoundException(DuplicatePatientDetailslException ex, WebRequest req)
	{
		ErrorModel model = new ErrorModel(new Date(), ex.getMessage(),HttpStatus.CONFLICT.value(),req.getDescription(false));
		
		
		
		return new ResponseEntity<ErrorModel>(model,HttpStatus.CONFLICT);
		
	}
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<ErrorModel> handleDuplicatePatientDetailsFoundException(PatientNotFoundException ex, WebRequest req)
	{
		ErrorModel model = new ErrorModel(new Date(), ex.getMessage(),HttpStatus.NOT_FOUND.value(),req.getDescription(false));
		return new ResponseEntity<ErrorModel>(model,HttpStatus.NOT_FOUND);
		
	}
	
	//doctor
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<ErrorModel> handleDuplicateDoctorNotFoundException(DoctorNotFoundException ex, WebRequest req)
	{
		ErrorModel model = new ErrorModel(new Date(), ex.getMessage(),HttpStatus.NOT_FOUND.value(),req.getDescription(false));
		
		return new ResponseEntity<ErrorModel>(model,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(DuplicateDoctortDetailslException.class)
	public ResponseEntity<ErrorModel> handleDuplicateDoctorDetailsFoundException(DuplicateDoctortDetailslException ex, WebRequest req)
	{
		ErrorModel model = new ErrorModel(new Date(), ex.getMessage(),HttpStatus.CONFLICT.value(),req.getDescription(false));
		
		return new ResponseEntity<ErrorModel>(model,HttpStatus.CONFLICT);
		
	}

	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<ErrorModel> handleDuplicateAppointmentDetailsFoundException(AppointmentNotFoundException ex, WebRequest req)
	{
		ErrorModel model = new ErrorModel(new Date(), ex.getMessage(),HttpStatus.NOT_FOUND.value(),req.getDescription(false));
		return new ResponseEntity<ErrorModel>(model,HttpStatus.NOT_FOUND);
		
	}
	

}
//
