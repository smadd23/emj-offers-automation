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
@EqualsAndHashCode
@Builder
@Data
@ToString
public class UsageLimits {

	@ApiModelProperty(example = "UNLIMITED|LIMITED|ONCE_PER_OFFER")
	private UsageLimitType usageLimitTypePerUser;

	@ApiModelProperty(example = "UNLIMITED|LIMITED|ONCE_PER_OFFER")
	private UsageLimitType usageLimitTypePerOffer;

	@ApiModelProperty(example = "1")
	private Long usageLimitPerUser;

	@ApiModelProperty(example = "99999")
	private Long usageLimitPerOffer;
}
