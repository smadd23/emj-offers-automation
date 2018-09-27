package com.safeway.j4u.emju.offers.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum QualificationUnitType {
	PRODUCT("PRODUCT"), 
	ORDER_TOTAL("ORDER_TOTAL");

	private final String type;
}
