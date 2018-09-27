package com.safeway.j4u.emju.offers.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum QualificationUnitSubType {
	QUANTITY("QUANTITY"), 
	POUND("POUND"), 
	AMOUNT("AMOUNT");
	private final String type;
}
