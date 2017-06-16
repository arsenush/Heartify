package com.heartify.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "nurse")
public class Nurse extends AbstractPersonal {}
