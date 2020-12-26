package com.ashokit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.model.UnlockAccount;
import com.ashokit.model.UserAccount;
import com.ashokit.service.UserManagementService;

@RestController
public class UserManagementRestController {

	@Autowired
	private UserManagementService service;

	@GetMapping("/loadForm")
	public String loadForm(Model model) {

		return null;

	}

	@PostMapping(value = "/userAccReg", consumes = "application/json"
			,produces="application/json")
	public ResponseEntity<String> handleSubmitBtn(@RequestBody UserAccount userAcc) {

		return new ResponseEntity<>("", HttpStatus.OK);
	}

	@GetMapping(value="/getStates/{cid}")
	public ResponseEntity<Map<Integer, String>> getStatesByCountryId(@PathVariable("cid") Integer countryId) {

		return new ResponseEntity<Map<Integer, String>>(HttpStatus.OK);
	}

	@GetMapping(value="/getCities/{sid}")
	public ResponseEntity<Map<Integer, String>> getCitiesByStateId(@PathVariable("sid") Integer stateId) {

		return new ResponseEntity<Map<Integer, String>>(HttpStatus.OK);

	}

}
