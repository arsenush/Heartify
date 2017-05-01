package com.heartify.model;

import com.heartify.model.enumeration.PrescriptionType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "prescription")
public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;
	@Column
	@Enumerated(value = EnumType.ORDINAL)
	private PrescriptionType type;
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	@Column
	private String description;
	@Column
	private Integer frequency;
	@Column
	private Date startDate;
	@Column
	private Date finalDate;
	@Column
	private Date appointedDate;
	@Column
	private Boolean isActive;

	// Only for a nurses
	// Nurse, who is currently performing a treatment
	@ManyToOne
	@JoinColumn(name = "nurse_id")
	private Nurse currentNurse;
}
