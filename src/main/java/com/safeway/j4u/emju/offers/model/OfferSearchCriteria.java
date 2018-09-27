package com.safeway.j4u.emju.offers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferSearchCriteria {
    private String key;
    private String operation;
    private Object value;
}
