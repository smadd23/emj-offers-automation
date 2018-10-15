package com.safeway.j4u.emju.offers.model;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(example = "PRODUCT|ORDER_TOTAL")
	private QualificationUnitType qualificationUnitType;

	@ApiModelProperty(example = "QUANTITY|POUND|AMOUNTY")
	private QualificationUnitSubType qualificationUnitSubType;

	@ApiModelProperty(example = "1")
	private Integer minProdPurchaseUnits;

	@ApiModelProperty(example = "1")
	private Integer maxProdPurchaseUnits;

	@ApiModelProperty(example = "11.99")
	private Double minOrderTotalAmount;

	@ApiModelProperty(example = "1")
	private Integer minRewardPoints;

	@ApiModelProperty(example = "1")
	private Integer minGetProdPurchaseUnits;

	@ApiModelProperty(example = "true")
	private Boolean isBuyXGetYOffer;
}
