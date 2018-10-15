package com.safeway.j4u.emju.offers.model;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(example = "AMOUNT_OFF|PERCENT_OFF|FIXED_PRICE|REWARDS_POINTS|POINTS")
	private BenefitValueType benefitValueType;

	@ApiModelProperty(example = "11.99")
	private Double benefitValue;

	@ApiModelProperty(example = "false")
	private Boolean isBenefitValueApplicableToBuyItems;

	@ApiModelProperty(example = "false")
	private Boolean isBenefitValueApplicableToGetItems;

	@ApiModelProperty(example = "false")
	private Boolean isBenefitValueRestrictedToMultiplesOfMinUnits;
}
