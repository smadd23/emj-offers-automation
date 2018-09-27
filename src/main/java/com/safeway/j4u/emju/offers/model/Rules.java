package com.safeway.j4u.emju.offers.model;

import static com.safeway.j4u.emju.offers.util.OffersConstants.ISO_OFFSET_DATE_TIME;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO_OFFSET_DATE_TIME)
	private StartDate startDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO_OFFSET_DATE_TIME)
	private EndDate endDate;
	private ApplicableTo applicableTo;
	private Qualification qualification;
	private Benefit benefit;
	private UsageLimits usageLimits; 
}
