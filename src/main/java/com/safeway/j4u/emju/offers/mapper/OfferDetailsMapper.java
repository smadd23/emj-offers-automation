package com.safeway.j4u.emju.offers.mapper;

import static java.util.stream.Collectors.toMap;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.safeway.j4u.emju.offers.entity.OfferDetails;
import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.model.offersetup.OfferCustomerFriendlyCategory;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")

public interface OfferDetailsMapper {
	@Mappings({ @Mapping(target = "offerId", source = "offer.info.id.offerId"),
			@Mapping(target = "externalOfferId", source = "offer.info.id.externalOfferId"),
			@Mapping(target = "aggregatorOfferId", source = "offer.info.id.aggregatorOfferId"),
			@Mapping(target = "offerProviderName", source = "offer.info.offerProviderName"),
			@Mapping(target = "categories", expression = "java(java.util.Objects.isNull(offer.getInfo()) ? null : com.safeway.j4u.emju.offers.mapper.OfferDetailsMapper.transformMapsToSolrFriendlyMaps(offer.getInfo().getCategories(), \"categories\"))"),
			@Mapping(target = "categoriesSet", expression = "java(java.util.Objects.isNull(offer.getInfo()) ? null : new HashSet<String>(offer.getInfo().getCategories().values()))"),
			@Mapping(target = "primaryCategory", source = "offer.info.primaryCategory"),
			@Mapping(target = "primaryCategorySet", expression = "java(java.util.Objects.isNull(offer.getInfo().getPrimaryCategory()) ? null : new HashSet<String>(offer.getInfo().getPrimaryCategory().values()))"),
			@Mapping(target = "events", expression = "java(java.util.Objects.isNull(offer.getInfo()) ? null : com.safeway.j4u.emju.offers.mapper.OfferDetailsMapper.transformMapsToSolrFriendlyMaps(offer.getInfo().getEvents(), \"events\"))"),
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
			@Mapping(target = "priceCode", expression = "java(offer.getInfo().getId().getExternalOfferId() != null ? offer.getInfo().getId().getExternalOfferId().substring(2,4) : null)"),
			@Mapping(target = "isEmployeeOffer", expression = "java("
					+ "(offer.getInfo().getId().getExternalOfferId() != null && \"E\".equalsIgnoreCase("
					+ "offer.getInfo().getId().getExternalOfferId().substring(4,5))) ? true : false)"),
			@Mapping(target = "isDefaultAllocationOffer", source = "offer.info.isDefaultAllocationOffer"),
			@Mapping(target = "offerProgramType", expression = "java(offer.getInfo().getId().getExternalOfferId() != null ? offer.getInfo().getId().getExternalOfferId().substring(4,5) : null)"),
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
			@Mapping(target = "divisions", expression = "java((java.util.Objects.isNull(offer.getRules()) || java.util.Objects.isNull(offer.getRules().getApplicableTo())) ? null : com.safeway.j4u.emju.offers.mapper.OfferDetailsMapper.transformMapsToSolrFriendlyMaps(offer.getRules().getApplicableTo().getDivisions(), \"divisions\"))"),
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
			@Mapping(target = "usageLimitTypePerUser", expression = "java(offer.getRules().getUsageLimits().getUsageLimitTypePerUser().name() )"),
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
			@Mapping(target = "usageLimitTypePerOffer", expression = "java(offer.getRules().getUsageLimits().getUsageLimitTypePerOffer()!=null ?offer.getRules().getUsageLimits().getUsageLimitTypePerOffer().name(): null )"),
			@Mapping(target = "usageLimitPerOffer", source = "offer.rules.usageLimits.usageLimitPerOffer") })
	OfferDetails from(Offer offer);

	static Map<String, String> transformMapsToSolrFriendlyMaps(Map<String, String> elements, String columnName) {
		return Objects.nonNull(elements)
				? elements.entrySet().stream().collect(toMap(x -> columnName + x.getKey(), Map.Entry::getValue))
				: null;
	}

	@Mappings({ @Mapping(target = "info.id.offerId", source = "offerId"),
			@Mapping(target = "info.offerProviderName", source = "offerProviderName"),
			@Mapping(target = "info.id.externalOfferId", source = "externalOfferId"),
			@Mapping(target = "info.id.aggregatorOfferId", source = "aggregatorOfferId"),
			@Mapping(target = "info.categories", expression = "java(com.safeway.j4u.emju.offers.mapper.OfferDetailsMapper.transformSolrFriendlyMapsToMaps(offerDetails.getCategories(), \"categories\"))"),
			@Mapping(target = "info.primaryCategory", source = "primaryCategory"),
			@Mapping(target = "info.events", expression = "java(com.safeway.j4u.emju.offers.mapper.OfferDetailsMapper.transformSolrFriendlyMapsToMaps(offerDetails.getEvents(), \"events\"))"),
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
			@Mapping(target = "rules.applicableTo.divisions", expression = "java(com.safeway.j4u.emju.offers.mapper.OfferDetailsMapper.transformSolrFriendlyMapsToMaps(offerDetails.getDivisions(), \"divisions\"))"),
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

	@Mappings({ @Mapping(target = "offerId", source = "offerId"),
			@Mapping(target = "customerFriendlyProgramId", source = "offerProgramCode"),
			@Mapping(target = "usageLimitTypeCode", expression = "java( offerDetails.getUsageLimitTypePerUser()!=null ? UsageLimitType.valueOf(offerDetails.getUsageLimitTypePerUser()) : null)"), // to
																																			// check
			@Mapping(target = "priceMethodCode", source = "priceCode"),
			@Mapping(target = "offerEffectiveStartDate", source = "offerEffectiveStartDate"),
			@Mapping(target = "offerEffectiveEndDate", source = "offerEffectiveEndDate"),
			@Mapping(target = "displayEffectiveStartDate", source = "displayEffectiveStartDate"),
			@Mapping(target = "displayEffectiveEndDate", source = "displayEffectiveEndDate"),
			@Mapping(target = "serviceProviderName", source = "offerProviderName"), // to check
			@Mapping(target = "externalOfferId", source = "externalOfferId"),
			@Mapping(target = "offerPrice", source = "offerprice"),
			@Mapping(target = "productImageId", source = "productImageId"),
			@Mapping(target = "lastUpdatedTimestamp", source = "lastUpdatedTs"),
			@Mapping(target = "offerStatusTypeId", source = "offerStatus"),
			@Mapping(target = "lastUpdateUserId", source = "lastUpdatedUserId"),
			@Mapping(target = "serviceProviderOfferId", source = "aggregatorOfferId"),
      @Mapping(target="postalCds", expression = "java(com.safeway.j4u.emju.offers.mapper.OfferDetailsMapper.transformStoresOrPostalCodes(offerDetails.getStoreIds(), offerDetails.getPostalCodes()))"),
      @Mapping(target = "offerVerbiage.titleLine1Description", expression = "java(offerDetails.getTitleDescription() != null ? offerDetails.getTitleDescription().get(\"titleDsc1\") : null)"),
      @Mapping(target = "offerVerbiage.titleLine2Description", expression = "java(offerDetails.getTitleDescription() != null ? offerDetails.getTitleDescription().get(\"titleDsc2\") : null)"),
      @Mapping(target = "offerVerbiage.productLine1Description", expression = "java(offerDetails.getProductDescription() != null ? offerDetails.getProductDescription().get(\"prodDsc1\") : null)"),
      @Mapping(target = "offerVerbiage.savingsValueText", source = "savingsValueText"),
      @Mapping(target = "offerVerbiage.priceValue1Text", source = "priceValue"),
      @Mapping(target = "offerVerbiage.priceTitle1Text", source = "priceTitle"),
      @Mapping(target = "offerVerbiage.disclaimerText", source = "disclaimerText"),
      @Mapping(target = "customerFriendlyCategory.shoppingListCFCategoryId", expression = "java( offerDetails.getPrimaryCategory() != null ? offerDetails.getPrimaryCategory().keySet().iterator().next() : null  )"),
      @Mapping(target = "customerFriendlyCategory.shoppingListCFCategoryName", expression = "java( offerDetails.getPrimaryCategory() != null ? offerDetails.getPrimaryCategory().values().iterator().next() : null )"),
      @Mapping(target = "offerCustomerFriendlyCategories", source = "categories", qualifiedByName = "transformCategoriesToCustomerFriendlyCategories") })
  com.safeway.j4u.emju.offers.model.offersetup.Offer toJ4UOffer(OfferDetails offerDetails);

  @Named("transformCategoriesToCustomerFriendlyCategories")
  default List<OfferCustomerFriendlyCategory> transformCategoriesToCustomerFriendlyCategories(
      Map<String, String> categories) {
    if (Optional.fromNullable(categories).isPresent()) {
      List<OfferCustomerFriendlyCategory> offerCustomerFriendlyCategories = Lists.newArrayList();
      categories.entrySet().stream().forEach(category -> {
        OfferCustomerFriendlyCategory offerCustomerFriendlyCategory = OfferCustomerFriendlyCategory.builder()
            .customerFriendlyCategoryId(category.getKey().replaceFirst("categories","")).customerFriendlyCategoryName(category.getValue())
            .build();
        offerCustomerFriendlyCategories.add(offerCustomerFriendlyCategory);
      });
      return offerCustomerFriendlyCategories;
    } else {
      return Collections.emptyList();
    }
  }

  static List<String> transformStoresOrPostalCodes(Set<String> fromStoreIds, Set<Integer> fromPostalCodes) {
    List<String> postalCodes = Lists.newArrayList();
    // TODO: Clarification on store id
    if (Optional.fromNullable(fromStoreIds).isPresent()) {
      fromStoreIds.stream().forEach(storeId -> {
        postalCodes.add(storeId);
      });
    }
//    if (Optional.fromNullable(fromPostalCodes).isPresent()) {
//      fromPostalCodes.stream().forEach(postalCode -> {
//        postalCodes.add(PostalCode.builder().postalCode(String.valueOf(postalCode)).build());
//      });
//    }
    return postalCodes;
  }
}
