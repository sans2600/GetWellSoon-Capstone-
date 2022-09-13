package com.gws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.gws.model.Patient;

@Repository
@EnableJpaRepositories
public interface PatientRepo extends JpaRepository<Patient, Integer>
{

	public Patient findByPhoneOrId(int patientId);



}
