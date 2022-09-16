package com.gws.service;

import java.util.List;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gws.exception.DuplicatePatientDetailslException;
import com.gws.exception.PatientNotFoundException;
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
	
	//duplicate details
		public Patient addPatient(Patient patient)
		{
			Patient p = patientrepo.findByPatientIdOrPatientPhone(patient.getPatientId(), patient.getPatientPhone());
		
		if(p!=null)
		{
			throw new DuplicatePatientDetailslException("Phone No. or Patient Id already exists");
		}
		else
		{
			return patientrepo.save(patient);
		}

			
		}
	
	//show patient list
	public List<Patient> getAllPatient() 
	{
		return patientrepo.findAll();
	}
	
	//patient not found
	public Patient getPatientById(int patientId)
	{

		Optional<Patient> patient = patientrepo.findById(patientId);
		
		
		if(patient.isPresent())
		{
			return patient.get();
		}
		else
		{
			throw new PatientNotFoundException("Patient Details Not Found");
		}
		
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
//
