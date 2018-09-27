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
public class Id {

	private Long offerId;
	private String externalOfferId;
	private String aggregatorOfferId;
}
