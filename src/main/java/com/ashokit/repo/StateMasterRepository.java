package com.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.StateMasterEntity;

public interface StateMasterRepository extends JpaRepository<StateMasterEntity, Integer> {

	
	public List<StateMasterEntity> findAllByCountryId(Integer countryId);
}
