package com.safeway.j4u.emju.offers.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StatusType {
	A("A"), D("D"), E("E"), L("L"), O("O"), P("P");
	private final String type;

	@Override
	public String toString() {
		return type;
	}
}
