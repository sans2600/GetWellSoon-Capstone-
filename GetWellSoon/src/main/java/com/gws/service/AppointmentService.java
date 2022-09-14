package com.gws.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.gws.exception.AppointmentNotFoundException;
import com.gws.exception.PatientNotFoundException;
import com.gws.model.AppointmentData;
import com.gws.model.DoctorList;
import com.gws.model.Patient;
import com.gws.repository.AppointmentRepo;
import com.gws.repository.DoctorRepo;
import com.gws.repository.PatientRepo;
@Service
public class AppointmentService 
{
	@Autowired
	private AppointmentRepo appoint;
	
	@Autowired
	private DoctorRepo doctorrepo;
	
	@Autowired
	private PatientRepo patientrepo;
	
	//get All Appointment
	public List<AppointmentData> getAllAppointment(){
		return appoint.findAll();
	}
	//save appointment
	public AppointmentData addAppointment(int patientId,int docId, String appointDate) {

		Optional<Patient> patient = patientrepo.findById(patientId);	
		Optional<DoctorList> doctor= doctorrepo.findById(docId);
		
		if(patient.isPresent() && doctor.isPresent())
		{
			Patient p=patient.get();
			DoctorList d=doctor.get();
			AppointmentData updatedAppointmentData=new AppointmentData();
			updatedAppointmentData.setDocId(docId);
			updatedAppointmentData.setDocFees(d.getDocFees());
			updatedAppointmentData.setDocName(d.getDocName());
			updatedAppointmentData.setPatientId(p.getPatientId());
			updatedAppointmentData.setPatientName(p.getPatientName());
			updatedAppointmentData.setAppointDate(appointDate);
			return appoint.save(updatedAppointmentData);
		}
		else if(patient.isPresent())
		{
			throw new PatientNotFoundException("Doctor id is invalid");//Error
		}
		else if(doctor.isPresent()) {//Doctor valid
			throw new PatientNotFoundException("Patient id is invalid");
		}
		else {
			throw new PatientNotFoundException("Patient id and Doctor id is invalid");
		} 
	
	}

		//trying with List Instead of Optional
	public List<AppointmentData> getAppointmentDataById(int docId)
	{
		List<AppointmentData> appointmentdata = appoint.findAllByDocId(docId);
		
		return appointmentdata;
		
	}


//Doctor Update AppointmentData{Cancel Appointment}
//public deleteAppointment() {
//	appoint.
//}


}
