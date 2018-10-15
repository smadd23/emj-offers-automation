package com.safeway.j4u.emju.offers.model;

import javax.validation.Valid;
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
public class Rules {
	@Valid
	private StartDate startDate;
	@Valid
	private EndDate endDate;
	@Valid
	private ApplicableTo applicableTo;
	private Qualification qualification;
	private Benefit benefit;
	private UsageLimits usageLimits; 
}
