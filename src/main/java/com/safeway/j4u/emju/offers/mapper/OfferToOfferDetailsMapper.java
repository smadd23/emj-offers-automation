package com.safeway.j4u.emju.offers.mapper;

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.Objects;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.safeway.j4u.emju.offers.entity.OfferDetails;
import com.safeway.j4u.emju.offers.model.Offer;


@Mapper(componentModel = "spring")
public interface OfferToOfferDetailsMapper {
	@Mappings({ @Mapping(target = "offerId", source = "offer.info.id.offerId"),
			@Mapping(target = "externalOfferId", source = "offer.info.id.externalOfferId"),
			@Mapping(target = "aggregatorOfferId", source = "offer.info.id.aggregatorOfferId"),
			@Mapping(target = "offerProviderName", source = "offer.info.offerProviderName"),
			@Mapping(target = "categories", expression = "java(java.util.Objects.isNull(offer.getInfo()) ? null : com.safeway.j4u.emju.offers.mapper.OfferToOfferDetailsMapper.transformMapsToSolrFriendlyMaps(offer.getInfo().getCategories(), \"categories\"))"),
			@Mapping(target = "categoriesSet", expression = "java(java.util.Objects.isNull(offer.getInfo()) ? null : new HashSet<String>(offer.getInfo().getCategories().values()))"),
			@Mapping(target = "primaryCategory", source = "offer.info.primaryCategory"),
			@Mapping(target = "primaryCategorySet", expression = "java(java.util.Objects.isNull(offer.getInfo().getPrimaryCategory()) ? null : new HashSet<String>(offer.getInfo().getPrimaryCategory().values()))"),
			@Mapping(target = "events", expression = "java(java.util.Objects.isNull(offer.getInfo()) ? null : com.safeway.j4u.emju.offers.mapper.OfferToOfferDetailsMapper.transformMapsToSolrFriendlyMaps(offer.getInfo().getEvents(), \"events\"))"),
			@Mapping(target = "eventsSet", expression = "java(java.util.Objects.isNull(offer.getInfo().getEvents()) ? null : new HashSet<String>(offer.getInfo().getEvents().values()))"),
			@Mapping(target = "offerProgramCode", expression = "java( offer.getInfo().getOfferProgramCode().name())"),
			@Mapping(target = "offerSubProgram", source = "offer.info.offerSubProgram"),
			@Mapping(target = "offerStatus", expression = "java( offer.getInfo().getOfferStatus() !=null ? offer.getInfo().getOfferStatus().name(): com.safeway.j4u.emju.offers.model.StatusType.P.name() )"),
			@Mapping(target = "priceTitle", source = "offer.info.description.priceTitle"),
			@Mapping(target = "priceValue", source = "offer.info.description.priceValue"),
			@Mapping(target = "savingsValueText", source = "offer.info.description.savingsValueText"),
			@Mapping(target = "titleDescription", source = "offer.info.description.titleDescription"),
			@Mapping(target = "titleDescriptionSet", expression = "java(java.util.Objects.isNull(offer.getInfo().getDescription()) || java.util.Objects.isNull(offer.getInfo().getDescription().getTitleDescription()) ? null : new HashSet<String>(offer.getInfo().getDescription().getTitleDescription().values()))"),
			@Mapping(target = "productDescription", source = "offer.info.description.productDescription"),
			@Mapping(target = "productDescriptionSet", expression = "java(java.util.Objects.isNull(offer.getInfo().getDescription()) || java.util.Objects.isNull(offer.getInfo().getDescription().getProductDescription()) ? null : new HashSet<String>(offer.getInfo().getDescription().getProductDescription().values()))"),
			@Mapping(target = "disclaimerText", source = "offer.info.description.disclaimerText"),
			@Mapping(target = "receiptDescriptions", source = "offer.info.description.receiptDescriptions"),
			@Mapping(target = "productImageId", source = "offer.info.productImageId"),
			@Mapping(target = "priceCode", expression = "java((offer.getInfo().getOfferProgramCode() == com.safeway.j4u.emju.offers.model.ProgramCodeType.PD) ? (offer.getInfo().getId().getExternalOfferId() != null ? offer.getInfo().getId().getExternalOfferId().substring(2,4) : null) : null)"),
			@Mapping(target = "isEmployeeOffer", expression = "java("
					+ "(offer.getInfo().getId().getExternalOfferId() != null && \"E\".equalsIgnoreCase("
					+ "offer.getInfo().getId().getExternalOfferId().substring(4,5))) ? true : false)"),
			@Mapping(target = "isDefaultAllocationOffer", source = "offer.info.isDefaultAllocationOffer"),
			@Mapping(target = "offerProgramType", expression = "java((offer.getInfo().getOfferProgramCode() == com.safeway.j4u.emju.offers.model.ProgramCodeType.PD) ? (offer.getInfo().getId().getExternalOfferId() != null ? offer.getInfo().getId().getExternalOfferId().substring(4,5) : null) : null)"),
			@Mapping(target = "shouldReportRedemptions", source = "offer.info.shouldReportRedemptions"),
			@Mapping(target = "promoClassId", source = "offer.info.promoClassId"),
			@Mapping(target = "createdTs", source = "offer.info.auditInfo.createdTs"),
			@Mapping(target = "createdApplicationId", source = "offer.info.auditInfo.createdApplicationId"),
			@Mapping(target = "createdUserId", source = "offer.info.auditInfo.createdUserId"),
			@Mapping(target = "lastUpdatedApplicationId", source = "offer.info.auditInfo.lastUpdatedApplicationId"),
			@Mapping(target = "lastUpdatedUserId", source = "offer.info.auditInfo.lastUpdatedUserId"),
			@Mapping(target = "lastUpdatedTs", source = "offer.info.auditInfo.lastUpdatedTs"),
			@Mapping(target = "displayEffectiveStartDate", source = "offer.rules.startDate.displayEffectiveStartDate"),
			@Mapping(target = "offerEffectiveStartDate", source = "offer.rules.startDate.offerEffectiveStartDate"),
			@Mapping(target = "offerTestEffectiveStartDate", source = "offer.rules.startDate.offerTestEffectiveStartDate"),
			@Mapping(target = "displayEffectiveEndDate", source = "offer.rules.endDate.displayEffectiveEndDate"),
			@Mapping(target = "offerEffectiveEndDate", source = "offer.rules.endDate.offerEffectiveEndDate"),
			@Mapping(target = "offerTestEffectiveEndDate", source = "offer.rules.endDate.offerTestEffectiveEndDate"),
			@Mapping(target = "divisions", expression = "java((java.util.Objects.isNull(offer.getRules()) || java.util.Objects.isNull(offer.getRules().getApplicableTo())) ? null : com.safeway.j4u.emju.offers.mapper.OfferToOfferDetailsMapper.transformMapsToSolrFriendlyMaps(offer.getRules().getApplicableTo().getDivisions(), \"divisions\"))"),
			@Mapping(target = "divisionsSet", expression = "java((java.util.Objects.isNull(offer.getRules()) || java.util.Objects.isNull(offer.getRules().getApplicableTo())  || java.util.Objects.isNull(offer.getRules().getApplicableTo().getDivisions())) ? null : new HashSet<String>(offer.getRules().getApplicableTo().getDivisions().values()))"),
			@Mapping(target = "storeGroups", source = "offer.rules.applicableTo.storeGroups"),
			@Mapping(target = "storeIds", source = "offer.rules.applicableTo.storeIds"),
			@Mapping(target = "postalCodes", source = "offer.rules.applicableTo.postalCodes"),
			@Mapping(target = "upcs", source = "offer.rules.applicableTo.upcs"),
			@Mapping(target = "terminals", source = "offer.rules.applicableTo.terminals"),
			@Mapping(target = "qualificationUnitType", expression = "java( (java.util.Objects.isNull(offer.getRules().getQualification().getQualificationUnitType()) ? null : offer.getRules().getQualification().getQualificationUnitType().name() ))"),
			@Mapping(target = "qualificationUnitSubType", expression = "java( (java.util.Objects.isNull(offer.getRules().getQualification().getQualificationUnitSubType()) ? null : offer.getRules().getQualification().getQualificationUnitSubType().name()) )"),
			@Mapping(target = "minProdPurchaseUnits", source = "offer.rules.qualification.minProdPurchaseUnits"),
			@Mapping(target = "maxProdPurchaseUnits", source = "offer.rules.qualification.maxProdPurchaseUnits"),
			@Mapping(target = "isBuyXGetYOffer", source = "offer.rules.qualification.isBuyXGetYOffer"),
			@Mapping(target = "benefitValueType", expression = "java( (java.util.Objects.isNull(offer.getRules().getBenefit().getBenefitValueType() ) ? null : offer.getRules().getBenefit().getBenefitValueType().name()) )"),
			@Mapping(target = "usageLimitTypePerUser", expression = "java(offer.getRules().getUsageLimits().getUsageLimitTypePerUser()!=null ?offer.getRules().getUsageLimits().getUsageLimitTypePerUser().getType(): null )"),
			@Mapping(target = "usageLimitPerUser", source = "offer.rules.usageLimits.usageLimitPerUser"),
			@Mapping(target = "banners", source = "offer.rules.applicableTo.banners"),
			@Mapping(target = "channels", source = "offer.rules.applicableTo.channels"),
			@Mapping(target = "minOrderTotalAmount", source = "offer.rules.qualification.minOrderTotalAmount"),
			@Mapping(target = "minRewardPoints", source = "offer.rules.qualification.minRewardPoints"),
			@Mapping(target = "minGetProdPurchaseUnits", source = "offer.rules.qualification.minGetProdPurchaseUnits"),
			@Mapping(target = "isBenefitValueApplicableToBuyItems", source = "offer.rules.benefit.isBenefitValueApplicableToBuyItems"),
			@Mapping(target = "isBenefitValueApplicableToGetItems", source = "offer.rules.benefit.isBenefitValueApplicableToGetItems"),
			@Mapping(target = "isBenefitValueRestrictedToMultiplesOfMinUnits", source = "offer.rules.benefit.isBenefitValueRestrictedToMultiplesOfMinUnits"),
			@Mapping(target = "offerprice", source = "offer.rules.benefit.benefitValue"),
			@Mapping(target = "departments", source = "offer.rules.applicableTo.departments"),
			@Mapping(target = "usageLimitTypePerOffer", expression = "java(offer.getRules().getUsageLimits().getUsageLimitTypePerOffer()!=null ?offer.getRules().getUsageLimits().getUsageLimitTypePerOffer().getType(): null )"),
			@Mapping(target = "usageLimitPerOffer", source = "offer.rules.usageLimits.usageLimitPerOffer") })
	OfferDetails from(Offer offer);

	static Map<String, String> transformMapsToSolrFriendlyMaps(Map<String, String> elements, String columnName) {
		return Objects.nonNull(elements)
				? elements.entrySet().stream().collect(toMap(x -> columnName + x.getKey(), Map.Entry::getValue))
				: null;
	}
}
