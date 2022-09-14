package com.gws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.gws.model.DoctorList;


@Repository
public interface DoctorRepo extends JpaRepository<DoctorList, Integer>{
	
	public DoctorList findByDocIdOrDocMail(int docId, String docMail);
	

}
//