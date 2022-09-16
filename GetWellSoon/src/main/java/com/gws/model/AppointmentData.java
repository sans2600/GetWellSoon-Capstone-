package com.gws.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
@Table(name="AppointmentData")
public class AppointmentData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointId;
	private int docId;
	private int patientId;
	private String patientName;
	private String docName;

	@DateTimeFormat()
	private String appointDate;

	private float docFees;
}
//
//