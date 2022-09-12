package com.gws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
@Table(name="doctorlist")
public class DoctorList 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="docId")
	private int docId;
	
	@Column(name="docName")
	private String docName;
	
	@Column(name="docAddress")
	private String docAddress;
	
	@Column(name="docTiming")
	private String docTiming;
	
	@Column(name="docDepartment")
	private String docDepartment;

	@Column(name="docFees")
	private float docFees;
	
	@Column(name="docQualification")
	private String docQualification;
	
	@Column(name="docExperience")
	private int docExperience;
	
	@Column(name="docMail")
	private String docMail;

}
