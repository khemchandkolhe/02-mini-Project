package com.ashokit.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.UserAccountEntity;

public interface UserAccountsRepository extends JpaRepository<UserAccountEntity, Serializable>{

	public  UserAccountEntity findByEmail(String email);
	
	public UserAccountEntity findByEmailAndPassword(String email,String pwd);
}
