package com.safeway.j4u.emju.offers.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum ProgramCodeType {
    SC("SC"), 
    MF("MF"), 
    PD("PD");

    private final String type;

}
