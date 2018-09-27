package com.safeway.j4u.emju.offers.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum UsageLimitType {
	UNLIMITED("UNLIMITED"), 
	LIMITED("LIMITED"), 
	ONCE_PER_OFFER("ONCE_PER_OFFER");
	
	private final String type;
}
