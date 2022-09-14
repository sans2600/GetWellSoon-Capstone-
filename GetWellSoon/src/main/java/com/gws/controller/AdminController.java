package com.gws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gws.model.AppointmentData;
import com.gws.model.DoctorList;
import com.gws.model.Patient;
import com.gws.service.AppointmentService;
import com.gws.service.GWSService;

@RestController
public class AdminController {
	@Autowired
	private AppointmentService appService;
	
	@Autowired
	GWSService gwsservice;
	
	@GetMapping("/admin/patient")
	public List<Patient> getPatient()
	{
		return gwsservice.getAllPatient();
		
	}
	
	@GetMapping("/admin/doctors")
	public List<DoctorList> getDoctor()
	{
		return gwsservice.getAllDoctor();
	}
	
	@GetMapping("/appointments")
	public List<AppointmentData> allAppointments(){
		return appService.getAllAppointment();
	}
	//Pending get
	
	
}
