package com.safeway.j4u.emju.offers.model;

import java.util.Map;
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
public class Description {
	private String priceTitle;
	private String priceValue;
	private String savingsValueText;
	private Map<String, String> titleDescription;
	private Map<String, String> productDescription;
	private String disclaimerText;
	private String receiptDescriptions;
}
