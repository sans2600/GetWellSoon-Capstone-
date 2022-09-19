package com.gws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gws.exception.DoctorNotFoundException;
import com.gws.exception.DuplicateDoctortDetailslException;
import com.gws.exception.DuplicatePatientDetailslException;
import com.gws.exception.PatientNotFoundException;
import com.gws.model.DoctorList;
import com.gws.model.Patient;
import com.gws.repository.DoctorRepo;
import com.gws.repository.PatientRepo;

@Service
public class DoctorService {
	
	@Autowired
	DoctorRepo doctorrepo;
	
	@Autowired
	PatientRepo patientrepo;
	
	
	
	// check duplicate doctor details
		public DoctorList addDoctor(DoctorList doctorlist)
		{
			DoctorList d = doctorrepo.findByDocIdOrDocMail(doctorlist.getDocId(), doctorlist.getDocMail());
		
		if(d!=null)
		{
			throw new DuplicateDoctortDetailslException("Doctor Id or Doctor Mail already exists");
		}
		else
		{
			return doctorrepo.save(doctorlist);
			
		}
//
			
		}
	
	//doctor not found
		public DoctorList getDoctorById(int docId)
		{

			Optional<DoctorList> doctor = doctorrepo.findById(docId);
			
			
			if(doctor.isPresent())
			{
				return doctor.get();
			}
			else
			{
				throw new DoctorNotFoundException("Doctor Details Not Found");
			}
			
		}
		
		public DoctorList updateDoctor(DoctorList doctorList)
		{
			return doctorrepo.save(doctorList);
		}
		
		public void deleteDoctorById(int docId)
		{
			Optional<DoctorList> doctor = doctorrepo.findById(docId);
			
			if(doctor.isPresent())
			{
				doctorrepo.deleteById(docId);
			}
			else
			{
				throw new DoctorNotFoundException("Doctor Details Not Found");
			}
			
		}
	
	

}
//