package com.safeway.j4u.emju.offers.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum ProgramCodeType {
	SC("SC", "02"), MF("MF", "09"), PD("PD", null);

	private final String type;

	public String getType() {
		return type;
	}

	public String getCode() {
		return code;
	}

	private final String code;

}
