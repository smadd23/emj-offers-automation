package com.safeway.j4u.emju.offers.model;

import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Builder
@ToString
public class Offer {
	@Valid
	private Info info;
	@Valid
	private Rules rules;
}