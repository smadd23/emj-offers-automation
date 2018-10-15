package com.safeway.j4u.emju.offers.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum UsageLimitType {
	UNLIMITED("UNLIMITED", "U"), LIMITED("LIMITED", "L"), ONCE_PER_OFFER("ONCE_PER_OFFER", "O");

	private final String type;

	public String getType() {
		return type;
	}

	public String getCode() {
		return code;
	}

	private final String code;

}
