package com.safeway.j4u.emju.offers.mapper;

public enum OfferSearchCriteriaKeyMapper {
	
	offerId("offer_id", false),
	externalOfferId("external_offer_id", false),
	offerProgramCd("offer_program_cd", false),
	offerProgramType("offer_program_type", false),
	offerStatus("offer_status", false),
	priceCd("price_code", false),
	startDt("offer_effective_start_dt", false),
	endDt("offer_effective_end_dt", false),
	storeId("store_ids", false),
	postalCd("postal_codes", false),
	banner("banners", true),
	desc("product_desc", true),
	region("divisions", true),
	household("household_id", false);
	
	private OfferSearchCriteriaKeyMapper(String column, boolean isMap) {
			this.column = column;
			this.isMap = isMap;
	}

	private String column;
	
	private boolean isMap;
	

	public String getColumn(String value) {
		return isMap ? column + value : column;
	}
	
	public String getDynamicColumnValue(String value) {
		return isMap ? "*" : value;
	}
}
