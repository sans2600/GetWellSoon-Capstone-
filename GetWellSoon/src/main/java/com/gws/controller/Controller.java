package com.gws.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gws.model.DoctorList;
import com.gws.model.Patient;
import com.gws.service.GWSService;

@RestController
public class Controller 
{
	@Autowired
	GWSService gwsservice;
	
	@GetMapping("/patient")
	public List<Patient> getPatient()
	{
		return gwsservice.getAllPatient();
		
	}
	
	@GetMapping("/patient/{id}")
	public Optional<Patient> getPatient(@PathVariable("id") int patientId)
	{
		return gwsservice.getPatientById(patientId);
	}
   
	@PutMapping("/patient/{id}")
	public Patient updatePatient(@PathVariable("id") int patientId, @RequestBody Patient patient)
	{
		Optional<Patient> p = gwsservice.getPatientById(patientId);
		Patient p1=p.get();
		p1.setPatientName(patient.getPatientName());
		p1.setPatientAge(patient.getPatientAge());
		p1.setPatientAddress(patient.getPatientAddress());
		p1.setPatientPhone(patient.getPatientPhone());
		return gwsservice.updatePatient(p1);
	}
	
	@GetMapping("/doctors")
	public List<DoctorList> getDoctor()
	{
		return gwsservice.getAllDoctor();
	}
   
	
	@PostMapping("/booking")
	public Patient bookAppointment(@RequestBody Patient patient  ) {
		return gwsservice.bookAppointment(patient);
	}
	
//	@GetMapping("/doctor")
//	{
//		public List<DoctorList> getDoc
//	}

	

}
