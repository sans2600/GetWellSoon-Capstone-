package com.gws.controller;

import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gws.model.AppointmentData;
import com.gws.model.DoctorList;
import com.gws.model.Patient;
import com.gws.service.AppointmentService;
import com.gws.service.GWSService;

@RestController
public class PatientController 
{
	@Autowired
	GWSService gwsservice;
	
	@Autowired
	private AppointmentService appService;
	
//	@GetMapping("/patient")
//	public List<Patient> getPatient()
//	{
//		return gwsservice.getAllPatient();
//		
//	}
	//
	@GetMapping("/patient/{id}")
	public Patient getPatient(@PathVariable("id") int patientId)
	{
		return gwsservice.getPatientById(patientId);
	}
   
	@PutMapping("/patient/{id}")
	public Patient updatePatient(@PathVariable("id") int patientId, @RequestBody Patient patient)
	{
		Patient p = gwsservice.getPatientById(patientId);
		//Patient p1=p.get();
		p.setPatientName(patient.getPatientName());
		p.setPatientAge(patient.getPatientAge());
		p.setPatientAddress(patient.getPatientAddress());
		p.setPatientPhone(patient.getPatientPhone());
		return gwsservice.updatePatient(p);
	}
	
	//adding patient details
	@PostMapping("/patient_register")
	public Patient addPatientById(@Valid@RequestBody Patient patient)
	{
		return gwsservice.addPatient(patient);
	}
	
	@GetMapping("/doctorlist")
	public List<DoctorList> getDoctorlist()
	{
		return gwsservice.getAllDoctor();
	}
   

	@PostMapping("/booking/{patientId}/{docId}/{appointDate}")
	public AppointmentData bookAppointment(@PathVariable int patientId,@PathVariable int docId, @PathVariable String appointDate) {
		return appService.addAppointment(patientId, docId, appointDate);


	}
	
	
//	@GetMapping("/doctor")
//	{
//		public List<DoctorList> getDoc
//	}

	

}
//
