package com.gws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gws.model.DoctorList;
import com.gws.model.Patient;
import com.gws.service.DoctorService;
import com.gws.service.GWSService;

@RestController
public class DoctorController {
	
	@Autowired
	DoctorService doctorservice;
	
	@Autowired
	GWSService gwsservice;
	

	@GetMapping("/doctor/{id}")
	public DoctorList getDoctorById(@PathVariable("id") int docId)
	{
		return doctorservice.getDoctorById(docId);
	}
	
	
	//adding patient details
		@PostMapping("/doctor_register")
		public DoctorList addDoctorById(@RequestBody DoctorList doctorlist)
		{
			return doctorservice.addDoctor(doctorlist);
		}
	

		@PutMapping("/doctor/{id}")
		public DoctorList updateDoctor(@PathVariable("id") int docId, @RequestBody DoctorList doctorList)
		{
			DoctorList d = doctorservice.getDoctorById(docId);
			//Patient p1=p.get();
			d.setDocName(doctorList.getDocName());
			d.setDocAddress(doctorList.getDocAddress());
			d.setDocTiming(doctorList.getDocTiming());
			d.setDocDepartment(doctorList.getDocDepartment());
			d.setDocFees(doctorList.getDocFees());
			d.setDocQualification(doctorList.getDocQualification());
			d.setDocExperience(doctorList.getDocExperience());
			d.setDocMail(doctorList.getDocMail());
			
			
			return doctorservice.updateDoctor(d);
		}
		
	
	

}
