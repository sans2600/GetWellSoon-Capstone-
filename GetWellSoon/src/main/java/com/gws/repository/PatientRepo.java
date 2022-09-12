package com.gws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gws.model.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer>
{

}
