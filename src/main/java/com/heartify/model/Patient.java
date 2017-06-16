package com.heartify.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String surname;
	@Column
	private String phone;
	@Column
	private String address;
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	@Column
	private String diagnosis;
	@Column
	private Date admissionDate;
	@Column
	private Date dischargeDate;
	@Column
	private String login;
	@Column
	private String password;
	@Column
	private String avatar;

	@OneToOne(mappedBy = "patient")
	private Location location;
}
