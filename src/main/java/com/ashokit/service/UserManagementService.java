package com.ashokit.service;

import java.util.Map;   

import com.ashokit.model.UserAccount;

public interface UserManagementService {

	public Map<Integer, String> getAllCountryList();

	public Map<Integer, String> getStatesByCountryId(Integer countryId);

	public Map<Integer, String> getCitiesByStateId(Integer stateId);
	
	public boolean isEmailUnique(String email);

	public boolean saveUserAcc(UserAccount userAcc);
	
	//login page operation
	
	public String loginCheck(String email,String pwd);
	
	//unlocked account operations
	
	public boolean isTempPwdvalid(String email,String tempPwd);
	
	public boolean unlockedAccount(String email,String newPwd);
	
	//forgot password operations
	public String forgotPassword(String email);
}


