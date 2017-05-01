package com.heartify.model;

import com.heartify.model.pk.LocationPK;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "location")
public class Location {
	@EmbeddedId
	private LocationPK locationPK;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "patient_id", unique = true)
	private Patient patient;
}
