package com.safeway.j4u.emju.offers.model;

import java.util.List;

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
public class Offers {
	private List<Offer> Offers;
}