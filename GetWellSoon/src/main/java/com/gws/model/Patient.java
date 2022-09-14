package com.gws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
@Entity
@Table(name="patient")
public class Patient 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	
	@Column(name="patientName")
	private String patientName;
	
	@Column(name="patientAge")
	private int patientAge;
	
	@Column(name="patientPhone")
	private String patientPhone;
	
	@Column(name="patientAddress")
	private String patientAddress;

}

//