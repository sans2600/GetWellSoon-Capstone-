package com.gws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gws.model.DoctorList;
import com.gws.model.Patient;
import com.gws.repository.DoctorRepo;
import com.gws.repository.PatientRepo;

@Service
public class GWSService 
{
	@Autowired
	DoctorRepo doctorrepo;
	
	@Autowired
	PatientRepo patientrepo;
	
	public List<Patient> getAllPatient() 
	{
		return patientrepo.findAll();
	}
	
	public Optional<Patient> getPatientById(int patientId)
	{
		return patientrepo.findById(patientId);
	}
	
	public List<DoctorList> getAllDoctor() 
	{
		return doctorrepo.findAll();
	}
	
	public Patient bookAppointment(Patient patient) 
	{
		return patientrepo.save(patient);
	}
	
	public Patient updatePatient(Patient patient)
	{
		return patientrepo.save(patient);
	}
	

}
