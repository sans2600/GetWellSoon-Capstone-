package com.gws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gws.model.Patient;

@Repository
@EnableJpaRepositories
public interface PatientRepo extends JpaRepository<Patient, Integer>
{
	@Query
	public Patient findByPhoneOrId(@Param(value = "patientId") int patientId, @Param(value = "patientPhone") String patientPhone);
	
	
}
