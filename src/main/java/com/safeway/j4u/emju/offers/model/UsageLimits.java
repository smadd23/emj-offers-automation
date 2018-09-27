package com.safeway.j4u.emju.offers.model;

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

	private UsageLimitType usageLimitTypePerUser;
	private UsageLimitType usageLimitTypePerOffer;
	private Long usageLimitPerUser;
	private Long usageLimitPerOffer;
}
