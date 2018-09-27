package com.safeway.j4u.emju.offers.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Builder
public class Benefit {
	private BenefitValueType benefitValueType;
	private Double benefitValue;
	private Boolean isBenefitValueApplicableToBuyItems;
	private Boolean isBenefitValueApplicableToGetItems;
	private Boolean isBenefitValueRestrictedToMultiplesOfMinUnits;
}
