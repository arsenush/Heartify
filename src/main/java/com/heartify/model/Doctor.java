package com.heartify.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "doctor")
public class Doctor extends AbstractPersonal {
	@Column
	private String specialization;
}
