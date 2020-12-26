package com.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "USER_ACCOUNTS")
public class UserAccountEntity {
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "USER_EMAIL", unique = true)
	private String email;

	@Column(name = "USER_PWD")
	private String password;

	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;

	@Column(name = "DOB")
	private LocalDate dateOfBirth;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "STATE_ID")
	private Integer state;

	@Column(name = "CITY_ID")
	private Integer city;

	@Column(name = "COUNTRY_ID")
	private Integer country;

	@Column(name = "ACC_STATUS")
	private String accStatus;

}
