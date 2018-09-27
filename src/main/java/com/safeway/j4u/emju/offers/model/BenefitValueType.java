package com.safeway.j4u.emju.offers.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum BenefitValueType {
	AMOUNT_OFF("AMOUNT_OFF"),	
	PERCENT_OFF("PERCENT_OFF"), 
	FIXED_PRICE("FIXED_PRICE"), 
	REWARDS_POINTS("REWARDS_POINTS"), 
	POINTS("POINTS");
	
	private final String type;

}
