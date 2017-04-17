package com.heartfy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class AbstractPersonal {
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
	@Column
	private String login;
	@Column
	private String password;
	@Column
	private String avatar;
	@Column
	private Boolean isWorking;
}
