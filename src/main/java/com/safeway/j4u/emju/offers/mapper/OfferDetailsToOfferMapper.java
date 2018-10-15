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

public interface OfferDetailsToOfferMapper {
	@Mappings({ @Mapping(target = "info.id.offerId", source = "offerId"),
			@Mapping(target = "info.offerProviderName", source = "offerProviderName"),
			@Mapping(target = "info.id.externalOfferId", source = "externalOfferId"),
			@Mapping(target = "info.id.aggregatorOfferId", source = "aggregatorOfferId"),
			@Mapping(target = "info.categories", expression = "java(com.safeway.j4u.emju.offers.mapper.OfferDetailsToOfferMapper.transformSolrFriendlyMapsToMaps(offerDetails.getCategories(), \"categories\"))"),
			@Mapping(target = "info.primaryCategory", source = "primaryCategory"),
			@Mapping(target = "info.events", expression = "java(com.safeway.j4u.emju.offers.mapper.OfferDetailsToOfferMapper.transformSolrFriendlyMapsToMaps(offerDetails.getEvents(), \"events\"))"),
			@Mapping(target = "info.offerStatus", source = "offerStatus"),
			@Mapping(target = "info.priceCode", source = "priceCode"),
			@Mapping(target = "info.offerProgramType", source = "offerProgramType"),
			@Mapping(target = "info.offerProgramCode", source = "offerProgramCode"),
			@Mapping(target = "info.offerSubProgram", source = "offerSubProgram"),
			@Mapping(target = "info.description.priceTitle", source = "priceTitle"),
			@Mapping(target = "info.description.priceValue", source = "priceValue"),
			@Mapping(target = "info.description.savingsValueText", source = "savingsValueText"),
			@Mapping(target = "info.description.titleDescription", source = "titleDescription"),
			@Mapping(target = "info.description.productDescription", source = "productDescription"),
			@Mapping(target = "info.description.disclaimerText", source = "disclaimerText"),
			@Mapping(target = "info.description.receiptDescriptions", source = "receiptDescriptions"),
			@Mapping(target = "info.productImageId", source = "productImageId"),
			@Mapping(target = "info.isEmployeeOffer", source = "isEmployeeOffer"),
			@Mapping(target = "info.isDefaultAllocationOffer", source = "isDefaultAllocationOffer"),
			@Mapping(target = "info.shouldReportRedemptions", source = "shouldReportRedemptions"),
			@Mapping(target = "info.promoClassId", source = "promoClassId"),
			@Mapping(target = "info.auditInfo.createdTs", source = "createdTs"),
			@Mapping(target = "info.auditInfo.createdApplicationId", source = "createdApplicationId"),
			@Mapping(target = "info.auditInfo.createdUserId", source = "createdUserId"),
			@Mapping(target = "info.auditInfo.lastUpdatedApplicationId", source = "lastUpdatedApplicationId"),
			@Mapping(target = "info.auditInfo.lastUpdatedUserId", source = "lastUpdatedUserId"),
			@Mapping(target = "info.auditInfo.lastUpdatedTs", source = "lastUpdatedTs"),
			@Mapping(target = "rules.startDate.displayEffectiveStartDate", source = "displayEffectiveStartDate"),
			@Mapping(target = "rules.startDate.offerEffectiveStartDate", source = "offerEffectiveStartDate"),
			@Mapping(target = "rules.startDate.offerTestEffectiveStartDate", source = "offerTestEffectiveStartDate"),
			@Mapping(target = "rules.endDate.displayEffectiveEndDate", source = "displayEffectiveEndDate"),
			@Mapping(target = "rules.endDate.offerEffectiveEndDate", source = "offerEffectiveEndDate"),
			@Mapping(target = "rules.endDate.offerTestEffectiveEndDate", source = "offerTestEffectiveEndDate"),
			@Mapping(target = "rules.applicableTo.divisions", expression = "java(com.safeway.j4u.emju.offers.mapper.OfferDetailsToOfferMapper.transformSolrFriendlyMapsToMaps(offerDetails.getDivisions(), \"divisions\"))"),
			@Mapping(target = "rules.applicableTo.storeGroups", source = "storeGroups"),
			@Mapping(target = "rules.applicableTo.storeIds", source = "storeIds"),
			@Mapping(target = "rules.applicableTo.postalCodes", source = "postalCodes"),
			@Mapping(target = "rules.applicableTo.upcs", source = "upcs"),
			@Mapping(target = "rules.applicableTo.terminals", source = "terminals"),
			@Mapping(target = "rules.qualification.qualificationUnitType", source = "qualificationUnitType"),
			@Mapping(target = "rules.qualification.qualificationUnitSubType", source = "qualificationUnitSubType"),
			@Mapping(target = "rules.qualification.minProdPurchaseUnits", source = "minProdPurchaseUnits"),
			@Mapping(target = "rules.qualification.maxProdPurchaseUnits", source = "maxProdPurchaseUnits"),
			@Mapping(target = "rules.qualification.isBuyXGetYOffer", source = "isBuyXGetYOffer"),
			@Mapping(target = "rules.benefit.benefitValueType", source = "benefitValueType"),
			@Mapping(target = "rules.usageLimits.usageLimitTypePerUser", source = "usageLimitTypePerUser"),
			@Mapping(target = "rules.usageLimits.usageLimitPerUser", source = "usageLimitPerUser"),
			@Mapping(target = "rules.applicableTo.banners", source = "banners"),
			@Mapping(target = "rules.applicableTo.channels", source = "channels"),
			@Mapping(target = "rules.qualification.minOrderTotalAmount", source = "minOrderTotalAmount"),
			@Mapping(target = "rules.qualification.minRewardPoints", source = "minRewardPoints"),
			@Mapping(target = "rules.qualification.minGetProdPurchaseUnits", source = "minGetProdPurchaseUnits"),
			@Mapping(target = "rules.benefit.isBenefitValueApplicableToBuyItems", source = "isBenefitValueApplicableToBuyItems"),
			@Mapping(target = "rules.benefit.isBenefitValueApplicableToGetItems", source = "isBenefitValueApplicableToGetItems"),
			@Mapping(target = "rules.benefit.isBenefitValueRestrictedToMultiplesOfMinUnits", source = "isBenefitValueRestrictedToMultiplesOfMinUnits"),
			@Mapping(target = "rules.benefit.benefitValue", source = "offerprice"),
			@Mapping(target = "rules.applicableTo.departments", source = "departments"),
			@Mapping(target = "rules.usageLimits.usageLimitTypePerOffer", source = "usageLimitTypePerOffer"),
			@Mapping(target = "rules.usageLimits.usageLimitPerOffer", source = "usageLimitPerOffer") })
	Offer toOffer(OfferDetails offerDetails);

	static Map<String, String> transformSolrFriendlyMapsToMaps(Map<String, String> elements, String columnName) {
		return Objects.nonNull(elements)
				? elements.entrySet().stream()
						.collect(toMap(x -> x.getKey().replaceFirst(columnName, ""), Map.Entry::getValue))
				: null;
	}
}
