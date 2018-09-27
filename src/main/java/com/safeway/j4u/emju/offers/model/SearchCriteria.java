package com.safeway.j4u.emju.offers.model;

import lombok.Data;

@Data
public class SearchCriteria {
	
	// Search by OfferId
	private Long offerId;
	
	// Search by external offer id
	private String externalOfferId;
	
	//Search by storeId 
	private String storeId;
	
	// Search by householdid
	private Long householdId;
	
	// Search by zip
	private String postalCode;
	
	//Search by offer status
	private String offerStatus;
	
	// Search by offer type
	private String offerType;
	
	// Search by price code
	private String priceCode;

}
