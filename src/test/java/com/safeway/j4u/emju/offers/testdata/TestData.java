package com.safeway.j4u.emju.offers.testdata;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.safeway.j4u.emju.offers.model.ApplicableTo;
import com.safeway.j4u.emju.offers.model.AuditInfo;
import com.safeway.j4u.emju.offers.model.Benefit;
import com.safeway.j4u.emju.offers.model.BenefitValueType;
import com.safeway.j4u.emju.offers.model.Description;
import com.safeway.j4u.emju.offers.model.EndDate;
import com.safeway.j4u.emju.offers.model.Id;
import com.safeway.j4u.emju.offers.model.Info;
import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.model.Offers;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TestData {
	
	public static void main(String[] args) {
		//test
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		mapper.findAndRegisterModules();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
		
		try {
			// Convert object to JSON string and pretty print
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(createOffer()));
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Offers createOffer() {
		
		Offers offers = new Offers();
		List<Offer> offerList = new ArrayList<Offer>();
		
		Offer offer = new Offer();
		Info info = new Info();
		
		Id id = new Id();
		//J4U Generated OfferId, wont be send by OMS.
		id.setOfferId(1234L);
		//AggregatorOfferId applicable only for MF.
		id.setAggregatorOfferId("Quotient_ID");
		id.setExternalOfferId("2520W3218_001119");
		info.setId(id);
		
		info.setOfferProviderName("NextGenStoreCpns");
		
		//Categories not available at OMSDuringPromoteToEOC.
		info.setCategories(new HashMap<String, String>() {{ put("17", "Personal Care & Health");}});
		//PrimaryCategory not available at OMSDuringPromoteToEOC.
		info.setPrimaryCategory(new HashMap<String, String>() {{ put("17", "Personal Care & Health"); }});
		//Events not available at OMSDuringPromoteToEOC.
		info.setEvents(new HashMap<String, String>() {{ put("125", "Weekly Ad Coupons"); }});
		
		info.setOfferProgramCode(ProgramCodeType.SC);
		info.setOfferSubProgram("02");
		
		//Attributes wont be send by OMS. Default would be preview status Hence setting as null.
		info.setOfferStatus(StatusType.A);
		
		Description description = new Description();
		//PriceTitle applies only for PD, Hence setting as null.
		description.setPriceTitle(null);
		//PriceValue applies only for PD, Hence setting as null.
		description.setPriceTitle("some title");
		description.setPriceValue("0.5");
		description.setSavingsValueText("$11.99 EACH");
		description.setTitleDescription(new HashMap<String, String>() {{ put("titleDsc1", "Store coupon 00"); }});
		description.setProductDescription(new HashMap<String, String>() {{ put("prodDsc1", "Always 15 to 66-ct., Depends 10 to 58-ct. or Poise 27 to 66-ct. Limit 4.");}});
		description.setDisclaimerText("some text");
		description.setReceiptDescriptions("Lactaid ECOM100500");
		info.setDescription(description);
		
		info.setProductImageId("999999.gif");
		
		//PriceCode to be calculated by Offer preview service based on External Offer ID. Wont be send by OMS.
		info.setPriceCode("25");
		//ProgramType to be calculated by Offer preview service based on External Offer ID. Wont be send by OMS.
		info.setOfferProgramType("W");
		
		info.setIsEmployeeOffer(Boolean.FALSE);
		info.setIsDefaultAllocationOffer(Boolean.FALSE);
		info.setShouldReportRedemptions(true);
		info.setPromoClassId("89");
		
		AuditInfo auditInfo = new AuditInfo();
		//Below all attributes wont be send by OMS. These would be set by Offer creation services, Hence setting as null.
		auditInfo.setCreatedTs(ZonedDateTime.parse("2018-08-17T00:00:45.000-07:00"));
		auditInfo.setCreatedApplicationId("EMOM");
		auditInfo.setCreatedUserId("kkaru00");
		auditInfo.setLastUpdatedApplicationId("EMOM");
		auditInfo.setLastUpdatedUserId("kkaru00");
		auditInfo.setLastUpdatedTs(ZonedDateTime.parse("2018-08-17T00:00:45.000-07:00"));
		info.setAuditInfo(auditInfo);
		offer.setInfo(info);
		
		Rules rules = new Rules();
		StartDate startDate = new StartDate();
		startDate.setDisplayEffectiveStartDate(ZonedDateTime.parse("2018-08-08T00:00:45.235-07:00"));
		startDate.setOfferEffectiveStartDate(ZonedDateTime.parse("2018-08-20T00:00:45.235-07:00"));
		startDate.setOfferTestEffectiveStartDate(ZonedDateTime.parse("2018-08-20T00:00:45.235-07:00"));
		rules.setStartDate(startDate);
		
		EndDate endDate = new EndDate();
		endDate.setDisplayEffectiveEndDate(ZonedDateTime.parse("2018-08-28T00:00:45.235-07:00"));
		endDate.setOfferEffectiveEndDate(ZonedDateTime.parse("2018-08-30T00:00:45.235-07:00"));
		endDate.setOfferTestEffectiveEndDate(ZonedDateTime.parse("2018-08-20T00:00:45.235-07:00"));
		rules.setEndDate(endDate);

		ApplicableTo applicableTo = new ApplicableTo();
		//Banner applies for MF offers.
		applicableTo.setBanners(new HashMap<String, String>() {{ put("S", "Safeway"); put("V", "Vons"); }});
		applicableTo.setDivisions(new HashMap<String, String>() {{ put("24", "NORCAL"); }});
		applicableTo.setStoreGroups(new HashSet<String>() {{add("7642");}});
		applicableTo.setChannels(new HashSet<String>() {{add("Channel1");add("Channel2");}});
		applicableTo.setTerminals(new HashSet<String>() {{add("11401");add("11411");add("11407");add("15");add("11406");}});
		applicableTo.setStoreIds(new HashSet<String>() {{add("908"); add("909"); add("4178"); add("1583"); add("2669"); add("111"); add("1215"); add("1455"); add("1576"); add("1574"); add("1211"); add("1210"); add("910"); add("911"); add("4601"); add("1218"); add("917"); add("918"); add("919"); add("2683"); add("1110"); add("1592"); add("3095"); add("2315"); add("3403"); add("1224"); add("1465"); add("1109"); add("2318"); add("1108"); add("928"); add("929"); add("2452"); add("2451"); add("1483"); add("4628"); add("2449"); add("256"); add("1476"); add("1234"); add("2684"); add("1232"); add("932"); add("933"); add("1917"); add("936"); add("4626"); add("1119"); add("939"); add("1490"); add("262"); add("1127"); add("2457"); add("2456"); add("1125"); add("2455"); add("2697"); add("1245"); add("2454"); add("2453"); add("700"); add("1929"); add("705"); add("706"); add("273"); add("2900"); add("1932"); add("1931"); add("1138"); add("1259"); add("1258"); add("950"); add("1257"); add("951"); add("2908"); add("954"); add("955"); add("713"); add("956"); add("2242"); add("962"); add("1266"); add("964"); add("1265"); add("1709"); add("965"); add("967"); add("968"); add("1826"); add("969"); add("1825"); add("1824"); add("1954"); add("1711"); add("1953"); add("970"); add("971"); add("972"); add("975"); add("976"); add("978"); add("979"); add("739"); add("1714"); add("3111"); add("2263"); add("1293"); add("1723"); add("1722"); add("982"); add("2258"); add("983"); add("1289"); add("742"); add("984"); add("985"); add("2255"); add("747"); add("989"); add("1968"); add("2815"); add("2814"); add("1846"); add("2934"); add("1724"); add("190"); add("3122"); add("3121"); add("3241"); add("2150"); add("2701"); add("2941"); add("993"); add("3116"); add("2269"); add("2940"); add("994"); add("995"); add("997"); add("998"); add("999"); add("2708"); add("2828"); add("638"); add("759"); add("2707"); add("1618"); add("2948"); add("639"); add("1617"); add("2287"); add("1990"); add("1197"); add("2286"); add("3011"); add("1196"); add("3132"); add("1195"); add("3010"); add("3251"); add("1192"); add("1866"); add("1502"); add("2712"); add("3008"); add("761"); add("640"); add("3127"); add("763"); add("3125"); add("3124"); add("767"); add("768"); add("2719"); add("2718"); add("1507"); add("1505"); add("1746"); add("2295"); add("1756"); add("4905"); add("2843"); add("1754"); add("2600"); add("2842"); add("653"); add("2841"); add("1631"); add("774"); add("654"); add("2840"); add("777"); add("2607"); add("1517"); add("2606"); add("1879"); add("2605"); add("1757"); add("2188"); add("1891"); add("1890"); add("3031"); add("2856"); add("783"); add("300"); add("785"); add("1883"); add("302"); add("786"); add("1640"); add("3026"); add("1761"); add("788"); add("304"); add("667"); add("668"); add("305"); add("308"); add("309"); add("1769"); add("1648"); add("1647"); add("1526"); add("2870"); add("790"); add("3281"); add("1899"); add("793"); add("2621"); add("1895"); add("676"); add("2620"); add("797"); add("1531"); add("1530"); add("1651"); add("799"); add("316"); add("1537"); add("1547"); add("2878"); add("1541"); add("1661"); add("1561"); add("1682"); add("1560"); add("691"); add("694"); add("2646"); add("2887"); add("695"); add("1434"); add("697"); add("1794"); add("2409"); add("1439"); add("4160"); add("1206"); add("1205"); add("2778"); add("1204"); add("2656"); add("2654"); add("1562");}});
		//Postal codes applicable only for TR. Hence setting as null.
		applicableTo.setPostalCodes(new HashSet<String>() {{add("94568");add("94588");}});
		//Future use, no Departments available in OMS now.
		applicableTo.setDepartments(new HashSet<String>() {{add("Dept1");add("Dept2");}});
		applicableTo.setUpcs(new HashSet<Long>() {{add(1234567890L);add(1234567890L);}});
		rules.setApplicableTo(applicableTo);
		
		Qualification qualification = new Qualification();
		qualification.setQualificationUnitType(QualificationUnitType.PRODUCT);
		qualification.setQualificationUnitSubType(QualificationUnitSubType.QUANTITY);
		qualification.setMinProdPurchaseUnits(1);
		qualification.setMaxProdPurchaseUnits(1);
		qualification.setMinOrderTotalAmount(11.99);
		qualification.setMinRewardPoints(1);
		qualification.setMinGetProdPurchaseUnits(1);
		qualification.setIsBuyXGetYOffer(Boolean.FALSE);
		rules.setQualification(qualification);
		
		Benefit benefit = new Benefit();
		benefit.setBenefitValueType(BenefitValueType.FIXED_PRICE);
		benefit.setBenefitValue(11.99);
		benefit.setIsBenefitValueApplicableToBuyItems(false);
		benefit.setIsBenefitValueApplicableToGetItems(false);
		benefit.setIsBenefitValueRestrictedToMultiplesOfMinUnits(false);
		rules.setBenefit(benefit);

		UsageLimits usageLimits = new  UsageLimits();
		usageLimits.setUsageLimitTypePerUser(UsageLimitType.ONCE_PER_OFFER);
		usageLimits.setUsageLimitTypePerOffer(UsageLimitType.UNLIMITED);
		usageLimits.setUsageLimitPerUser(1l);
		usageLimits.setUsageLimitPerOffer(999999l);
		rules.setUsageLimits(usageLimits);
		 
		offer.setRules(rules);
		offerList.add(offer);
		offers.setOffers(offerList);
		
		return offers;
	}

}
