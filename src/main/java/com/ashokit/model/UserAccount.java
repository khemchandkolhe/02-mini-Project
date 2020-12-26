package com.ashokit.model;

import java.util.Date;

import lombok.Data;

@Data
public class UserAccount {

	private Integer userId;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private Long phoneNumber;

	private Date dateOfBirth;

	private String gender;

	private Integer stateId;

	private Integer cityId;

	private Integer countryid;

	private String accStatus;

}
