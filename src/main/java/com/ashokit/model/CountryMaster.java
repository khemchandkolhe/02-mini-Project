package com.ashokit.model;

import lombok.Data;

public class CountryMaster {

	@Data
	public class StateMaster {

		private Integer stateId;

		private String stateName;

		private Integer countryId;

	}

}
