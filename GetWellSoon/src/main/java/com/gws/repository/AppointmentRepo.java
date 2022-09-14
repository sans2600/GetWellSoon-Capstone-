package com.gws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.model.AppointmentData;


public interface AppointmentRepo extends JpaRepository<AppointmentData, Integer>{

}
