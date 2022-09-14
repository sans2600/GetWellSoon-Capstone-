package com.gws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gws.model.AppointmentData;
import com.gws.service.AppointmentService;

@RestController
public class AppointmentController {
	@Autowired
	private AppointmentService appService;
	
	
	@PostMapping("/booking/{patientId}/{docId}")
	public AppointmentData bookAppointment(@PathVariable int patientId,@PathVariable int docId) {
		return appService.addAppointment(patientId, docId);
	}
	
	@GetMapping("/appointments")
	public List<AppointmentData> allAppointments(){
		return appService.getAllAppointment();
	}
	//Pending get
	
	
}
