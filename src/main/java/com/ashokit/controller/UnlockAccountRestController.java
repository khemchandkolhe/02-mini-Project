package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.model.UnlockAccount;
import com.ashokit.service.UserManagementService;

@RestController
public class UnlockAccountRestController {

	@Autowired
	private UserManagementService userMgmtService;

	@GetMapping(value = "/unlockAcc/{email}")
	public String displayUnlockAccForm(@PathVariable("email") String email, Model model) {

		return "unlockForm";
	}

	@PostMapping(value = "/unlockUserAcc", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> unlockUserAcc(@RequestBody("unlockAcc") UnlockAccount acc, Model model) {

		return new ResponseEntity<>("", HttpStatus.OK);
	}
}
