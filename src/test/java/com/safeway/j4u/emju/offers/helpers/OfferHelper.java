package com.safeway.j4u.emju.offers.helpers;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.base.Optional;
import com.safeway.j4u.emju.offers.entity.OfferDetails;
import com.safeway.j4u.emju.offers.model.ApplicableTo;
import com.safeway.j4u.emju.offers.model.Benefit;
import com.safeway.j4u.emju.offers.model.BenefitValueType;
import com.safeway.j4u.emju.offers.model.Description;
import com.safeway.j4u.emju.offers.model.EndDate;
import com.safeway.j4u.emju.offers.model.Id;
import com.safeway.j4u.emju.offers.model.Info;
import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.model.ProgramCodeType;
import com.safeway.j4u.emju.offers.model.Qualification;
import com.safeway.j4u.emju.offers.model.QualificationUnitSubType;
import com.safeway.j4u.emju.offers.model.QualificationUnitType;
import com.safeway.j4u.emju.offers.model.Rules;
import com.safeway.j4u.emju.offers.model.StartDate;
import com.safeway.j4u.emju.offers.model.StatusType;
import com.safeway.j4u.emju.offers.model.UsageLimitType;
import com.safeway.j4u.emju.offers.model.UsageLimits;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class OfferHelper {

	public static void main(String[] args) {

		// test
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		mapper.findAndRegisterModules();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);

		try {
			System.out.println(mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(createSCOfferSendByOMSDuringPromoteToPreview("2510N0817H05_820001", null, StatusType.A)));
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Offer createSCOfferSendByOMSDuringPromoteToEOC(String externalOfferId, Long offerId) {
		return createSCOfferSendByOMSDuringPromoteToEOC(externalOfferId, offerId, ProgramCodeType.SC, StatusType.A,
				"2018-08-01T00:00:01.235-07:00", "2018-12-31T00:00:01.235-07:00", "TE", new HashSet<String>() {
					{
						add("94568");
						add("94025");
					}
				}, new HashSet<String>() {
					{
						add("100100");
						add("200200");
						add("300300");
					}
				});
	}

	public static Offer createSCOfferSendByOMSDuringPromoteToEOC(String externalOfferId, Long offerId,
			ProgramCodeType offerType, StatusType statusType, String startDt, String endDt, String priceCode,
			Set<String> postalCodes, Set<String> storeIds) {
		Offer offer = new Offer();
		Info info = new Info();
		Id id = new Id();
		id.setExternalOfferId(externalOfferId);
		info.setId(id);
		if (Optional.fromNullable(offerId).isPresent()) {
			id.setOfferId(offerId);
		}
		info.setOfferProviderName("NextGenStoreCpns");
		info.setOfferProgramCode(offerType);
		Description description = new Description();
		description.setPriceTitle(null);
		description.setPriceValue(null);
		description.setDisclaimerText(null);
		description.setReceiptDescriptions("Lactaid ECOM100500");
		info.setDescription(description);
		info.setIsDefaultAllocationOffer(Boolean.FALSE);
		info.setOfferStatus(statusType);
		info.setShouldReportRedemptions(true);
		info.setPromoClassId("89");
		info.setPriceCode(priceCode);
		info.setCategories(new HashMap<String, String>() {
			{
				put("8", "Dairy, Eggs & Cheese");
			}
		});
		info.setPrimaryCategory(new HashMap<String, String>() {
			{
				put("8", "Dairy, Eggs & Cheese");
			}
		});
		info.setEvents(new HashMap<String, String>() {
			{
				put("125", "Weekly Ad Coupons");
			}
		});
		offer.setInfo(info);
		Rules rules = new Rules();
		StartDate startDate = new StartDate();
		startDate.setDisplayEffectiveStartDate(ZonedDateTime.parse("2018-08-01T00:00:01.235-07:00"));
		startDate.setOfferEffectiveStartDate(ZonedDateTime.parse(startDt));
		startDate.setOfferTestEffectiveStartDate(ZonedDateTime.parse("2018-08-01T00:00:01.235-07:00"));
		rules.setStartDate(startDate);
		EndDate endDate = new EndDate();
		endDate.setDisplayEffectiveEndDate(ZonedDateTime.parse("2018-12-31T00:00:01.235-07:00"));
		endDate.setOfferEffectiveEndDate(ZonedDateTime.parse(endDt));
		endDate.setOfferTestEffectiveEndDate(ZonedDateTime.parse("2018-12-31T00:00:01.235-07:00"));
		rules.setEndDate(endDate);
		ApplicableTo applicableTo = new ApplicableTo();
		applicableTo.setStoreGroups(new HashSet<String>() {
			{
				add("7642");
			}
		});
		applicableTo.setStoreIds(storeIds);
		applicableTo.setChannels(null);
		applicableTo.setTerminals(new HashSet<String>() {
			{
				add("11401");
			}
		});
		applicableTo.setDivisions(new HashMap<String, String>() {
			{
				put("24", "NORCAL");
			}
		});
		applicableTo.setStoreGroups(new HashSet<String>() {
			{
				add("7642");
			}
		});
		applicableTo.setPostalCodes(postalCodes);
		applicableTo.setDepartments(null);
		rules.setApplicableTo(applicableTo);
		Qualification qualification = new Qualification();
		qualification.setQualificationUnitType(QualificationUnitType.PRODUCT);
		qualification.setQualificationUnitSubType(QualificationUnitSubType.QUANTITY);
		qualification.setMinProdPurchaseUnits(1);
		qualification.setMaxProdPurchaseUnits(1);
		qualification.setMinOrderTotalAmount(3.65);
		qualification.setMinRewardPoints(null);
		qualification.setMinGetProdPurchaseUnits(null);
		qualification.setIsBuyXGetYOffer(Boolean.FALSE);
		rules.setQualification(qualification);
		Benefit benefit = new Benefit();
		benefit.setBenefitValueType(BenefitValueType.FIXED_PRICE);
		benefit.setBenefitValue(3.65);
		benefit.setIsBenefitValueApplicableToBuyItems(null);
		benefit.setIsBenefitValueApplicableToGetItems(null);
		benefit.setIsBenefitValueRestrictedToMultiplesOfMinUnits(null);
		rules.setBenefit(benefit);
		UsageLimits usageLimits = new  UsageLimits();
		usageLimits.setUsageLimitTypePerUser(UsageLimitType.ONCE_PER_OFFER);
		usageLimits.setUsageLimitPerUser(1l);
		rules.setUsageLimits(usageLimits);
		offer.setRules(rules);
		return offer;
	}

	public static Offer createSCOfferSendByOMSDuringPromoteToPreview(String externalOfferId, Long offerId, StatusType statusType) {
		Offer offer = new Offer();
		Info info = new Info();
		Id id = new Id();
		id.setExternalOfferId(externalOfferId);
		if (Optional.fromNullable(offerId).isPresent()) {
			id.setOfferId(offerId);
		}
		info.setId(id);
		info.setOfferProviderName("NextGenStoreCpns");
		// info.setOfferStatus(StatusType.PREVIEW);
		info.setCategories(new HashMap<String, String>() {
			{
				put("8", "Dairy, Eggs & Cheese");
			}
			{
				put("9", "Test 1");
			}
		});
		info.setPrimaryCategory(new HashMap<String, String>() {
			{
				put("8", "Dairy, Eggs & Cheese");
			}
			{
				put("9", "Test 1");
			}
		});
		info.setEvents(new HashMap<String, String>() {
			{
				put("125", "Weekly Ad Coupons");
			}
		});
		info.setOfferProgramCode(ProgramCodeType.SC);
		info.setOfferSubProgram("02");
		Description description = new Description();
		description.setPriceTitle(null);
		description.setPriceValue(null);
		description.setSavingsValueText("$3.65 EACH");
		description.setTitleDescription(new HashMap<String, String>() {
			{
				put("titleDsc1", "Lactaid");
			}
		});
		description.setProductDescription(new HashMap<String, String>() {
			{
				put("prodDsc1", "Lactose Free Milk Half gallon");
			}
		});
		description.setDisclaimerText(null);
		description.setReceiptDescriptions("Lactaid ECOM100500");
		info.setDescription(description);
		info.setProductImageId("999999.gif");
		info.setIsDefaultAllocationOffer(Boolean.FALSE);
		info.setShouldReportRedemptions(true);
		info.setPromoClassId("89");
		info.setOfferStatus(statusType);
		offer.setInfo(info);
		Rules rules = new Rules();
		StartDate startDate = new StartDate();
		startDate.setDisplayEffectiveStartDate(ZonedDateTime.parse("2018-08-01T00:00:01.235-07:00"));
		startDate.setOfferEffectiveStartDate(ZonedDateTime.parse("2018-08-01T00:00:01.235-07:00"));
		startDate.setOfferTestEffectiveStartDate(ZonedDateTime.parse("2018-08-01T00:00:01.235-07:00"));
		rules.setStartDate(startDate);
		EndDate endDate = new EndDate();
		endDate.setDisplayEffectiveEndDate(ZonedDateTime.parse("2018-12-31T00:00:01.235-07:00"));
		endDate.setOfferEffectiveEndDate(ZonedDateTime.parse("2018-12-31T00:00:01.235-07:00"));
		endDate.setOfferTestEffectiveEndDate(ZonedDateTime.parse("2018-12-31T00:00:01.235-07:00"));
		rules.setEndDate(endDate);
		ApplicableTo applicableTo = new ApplicableTo();
		applicableTo.setDivisions(new HashMap<String, String>() {
			{
				put("24", "NORCAL");
			}
		});
		applicableTo.setStoreGroups(new HashSet<String>() {
			{
				add("7642");
			}
		});
		applicableTo.setChannels(null);
		applicableTo.setTerminals(new HashSet<String>() {
			{
				add("11401");
			}
		});
		applicableTo.setStoreIds(new HashSet<String>() {
			{
				add("1462");
				add("1461");
				add("2792");
			}
		});
		applicableTo.setPostalCodes(null);
		applicableTo.setDepartments(null);
		rules.setApplicableTo(applicableTo);
		Qualification qualification = new Qualification();
		qualification.setQualificationUnitType(QualificationUnitType.PRODUCT);
		qualification.setQualificationUnitSubType(QualificationUnitSubType.QUANTITY);
		qualification.setMinProdPurchaseUnits(1);
		qualification.setMaxProdPurchaseUnits(1);
		qualification.setMinOrderTotalAmount(3.65);
		qualification.setMinRewardPoints(null);
		qualification.setMinGetProdPurchaseUnits(null);
		qualification.setIsBuyXGetYOffer(Boolean.FALSE);
		rules.setQualification(qualification);
		Benefit benefit = new Benefit();
		benefit.setBenefitValueType(BenefitValueType.FIXED_PRICE);
		benefit.setBenefitValue(3.65);
		benefit.setIsBenefitValueApplicableToBuyItems(null);
		benefit.setIsBenefitValueApplicableToGetItems(null);
		benefit.setIsBenefitValueRestrictedToMultiplesOfMinUnits(null);
		rules.setBenefit(benefit);
		UsageLimits usageLimits = new  UsageLimits();
		usageLimits.setUsageLimitTypePerUser(UsageLimitType.ONCE_PER_OFFER);
		usageLimits.setUsageLimitPerUser(1l);
		rules.setUsageLimits(usageLimits);
		offer.setRules(rules);
		return offer;
	}
	
	public static OfferDetails createOfferDetails(String externalOfferId, Long offerId,
			ProgramCodeType offerType, StatusType statusType, String startDt, String endDt, String priceCode,
			Set<Integer> postalCodes, Set<String> storeIds)
	{
		OfferDetails offerDetails = new OfferDetails();
		offerDetails.setOfferId(offerId);
		offerDetails.setExternalOfferId(externalOfferId);
		
		offerDetails.setCategories(new HashMap<String, String>() {{ put("1", "Personal Care & Health"); put("2", "Garbge-bell soup");}});
		offerDetails.setPrimaryCategory(new HashMap<String, String>() {{ put("1", "Frozen");}});
		
		offerDetails.setOfferProgramCode(offerType.name());
		offerDetails.setOfferStatus(statusType.toString());
		offerDetails.setPriceCode(priceCode);
		
		offerDetails.setOfferEffectiveStartDate(ZonedDateTime.parse(startDt));
		offerDetails.setOfferEffectiveEndDate(ZonedDateTime.parse(endDt));
		
		offerDetails.setStoreIds(storeIds);
		offerDetails.setPostalCodes(postalCodes);

		return offerDetails;
	}
}
