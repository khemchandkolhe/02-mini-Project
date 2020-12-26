package com.ashokit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.CityMasterEntity;
import com.ashokit.entity.CountryMasterEntity;
import com.ashokit.entity.StateMasterEntity;
import com.ashokit.entity.UserAccountEntity;
import com.ashokit.model.UserAccount;
import com.ashokit.repo.CityMasterRepository;
import com.ashokit.repo.CountryMasterRepository;
import com.ashokit.repo.StateMasterRepository;
import com.ashokit.repo.UserAccountsRepository;

@Service
public class UserManagementServiceImpl implements UserManagementService {
	@Autowired
	private CountryMasterRepository countryRepo;
	@Autowired
	private CityMasterRepository cityRepo;
	@Autowired
	private StateMasterRepository stateRepo;
	@Autowired
	private UserAccountsRepository userRepo;

	@Override
	public Map<Integer, String> getAllCountryList() {

		Map<Integer, String> map = new HashMap<>();
		List<CountryMasterEntity> countriesList = countryRepo.findAll();
		countriesList.forEach(countryEntity -> {
			map.put(countryEntity.getCountryId(), countryEntity.getCountryName());
		});
		return map;

	}

	@Override
	public Map<Integer, String> getStatesByCountryId(Integer countryId) {
		Map<Integer, String> map = new HashMap<>();
		List<StateMasterEntity> listStates = stateRepo.findAllByCountryId(countryId);
		listStates.forEach(stateEntity -> {
			map.put(stateEntity.getStateId(), stateEntity.getStateName());
		});
		return map;
	}

	@Override
	public Map<Integer, String> getCitiesByStateId(Integer stateId) {
		Map<Integer, String> map = new HashMap<>();
		List<CityMasterEntity> citiesList = cityRepo.findAllByStateId(stateId);
		citiesList.forEach(cityEntity -> {
			map.put(cityEntity.getCityId(), cityEntity.getCityName());
		});
		return map;
	}

	@Override
	public boolean isEmailUnique(String email) {
		UserAccountEntity userAccEntity = userRepo.findByEmail(email);
		return userAccEntity.getUserId() == null;

	}

	@Override
	public boolean saveUserAcc(UserAccount userAcc) {

		UserAccountEntity userAccEntity = new UserAccountEntity();
		userAcc.setPassword(passwordGenerator());
		userAcc.setAccStatus("LOCKED");
		BeanUtils.copyProperties(userAcc, userAccEntity);
		UserAccountEntity userAcount = userRepo.save(userAccEntity);

		return userAcount.getUserId() != null;
	}

	private static String passwordGenerator() {
		char[] password = new char[7];
		String values = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		Random random = new Random();
		for (int i = 0; i < password.length; i++) {

			password[i] = values.charAt(random.nextInt(values.length()));
		}
		System.out.println(password.toString());

		return password.toString();
	}

	@Override
	public String loginCheck(String email, String pwd) {

		UserAccountEntity userAccount = userRepo.findByEmailAndPassword(email, pwd);
		if (userAccount != null) {
			if (userAccount.getAccStatus().equals("LOCKED")) {
				return "ACCOUNT_LOCKED";
			} else {
				return "LOGIN_SUCCESS";
			}

		}
		return "INVALID_CREDENTIALS";
	}

	@Override
	public boolean isTempPwdvalid(String email, String tempPwd) {

		UserAccountEntity userDetails = userRepo.findByEmailAndPassword(email, tempPwd);
		return userDetails.getUserId() != null;
	}

	@Override
	public boolean unlockedAccount(String email, String newPwd) {

		UserAccountEntity userDetail = userRepo.findByEmail(email);
		userDetail.setPassword(newPwd);
		userDetail.setAccStatus("UNLOCKED");
		try {
			userRepo.save(userDetail);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public String forgotPassword(String email) {

		UserAccountEntity userRecord = userRepo.findByEmail(email);
		if (userRecord != null) {
			return userRecord.getPassword();
		}
		return null;
	}

}
