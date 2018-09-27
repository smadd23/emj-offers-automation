package com.safeway.j4u.emju.offers.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Builder
@ToString
public class Qualification {
	private QualificationUnitType qualificationUnitType;
	private QualificationUnitSubType qualificationUnitSubType;
	private Integer minProdPurchaseUnits;
	private Integer maxProdPurchaseUnits;
	private Double minOrderTotalAmount;
	private Integer minRewardPoints;
	private Integer minGetProdPurchaseUnits;
	private Boolean isBuyXGetYOffer;
}
