package com.safeway.j4u.emju.offers.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.safeway.j4u.emju.offers.entity.OfferDetails;
import com.safeway.j4u.emju.offers.model.offersetup.OfferBanner;
import com.safeway.j4u.emju.offers.model.offersetup.OfferCustomerFriendlyCategory;
import com.safeway.j4u.emju.offers.model.offersetup.PromotionalEvent;
import com.safeway.j4u.emju.offers.util.OffersConstants;

@Mapper(componentModel = "spring")

public interface OfferDetailsToJ4UOfferMapper {
	@Mappings({ @Mapping(target = "offerId", source = "offerId"),
			@Mapping(target = "customerFriendlyProgramId", source = "offerProgramCode"),
			@Mapping(target = "usageLimitTypeCode", expression = "java( offerDetails.getUsageLimitTypePerUser()!=null ? com.safeway.j4u.emju.offers.model.UsageLimitType.valueOf(offerDetails.getUsageLimitTypePerUser()).getCode() : null)"),
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
			@Mapping(target = "offerProgramTypeCode", expression = "java(com.safeway.j4u.emju.offers.model.ProgramCodeType.valueOf(offerDetails.getOfferProgramCode()).getCode())"),
			@Mapping(target = "shoppingListCFCategoryId", expression = "java( offerDetails.getPrimaryCategory() != null ? offerDetails.getPrimaryCategory().keySet().iterator().next() : null  )"),
			@Mapping(target = "offerStatusTypeId", source = "offerStatus"),
			@Mapping(target = "lastUpdateUserId", source = "lastUpdatedUserId"),
			@Mapping(target = "serviceProviderOfferId", source = "aggregatorOfferId"),
			@Mapping(target = "postalCds", expression = "java(com.safeway.j4u.emju.offers.mapper.OfferDetailsToJ4UOfferMapper.transformStoresOrPostalCodes(offerDetails.getStoreIds(), offerDetails.getPostalCodes()))"),
			@Mapping(target = "offerVerbiage.titleLine1Description", expression = "java(offerDetails.getTitleDescription() != null ? offerDetails.getTitleDescription().get(\"titleDsc1\") : null)"),
			@Mapping(target = "offerVerbiage.titleLine2Description", expression = "java(offerDetails.getTitleDescription() != null ? offerDetails.getTitleDescription().get(\"titleDsc2\") : null)"),
			@Mapping(target = "offerVerbiage.productLine1Description", expression = "java(offerDetails.getProductDescription() != null ? offerDetails.getProductDescription().get(\"prodDsc1\") : null)"),
			@Mapping(target = "offerVerbiage.savingsValueText", source = "savingsValueText"),
			@Mapping(target = "offerVerbiage.priceValue1Text", source = "priceValue"),
			@Mapping(target = "offerVerbiage.priceTitle1Text", source = "priceTitle"),
			@Mapping(target = "offerVerbiage.disclaimerText", source = "disclaimerText"),
			@Mapping(target = "customerFriendlyCategory.shoppingListCFCategoryId", expression = "java( offerDetails.getPrimaryCategory() != null ? offerDetails.getPrimaryCategory().keySet().iterator().next() : null  )"),
			@Mapping(target = "customerFriendlyCategory.shoppingListCFCategoryName", expression = "java( offerDetails.getPrimaryCategory() != null ? offerDetails.getPrimaryCategory().values().iterator().next() : null )"),
			@Mapping(target = "offerCustomerFriendlyCategories", source = "categories", qualifiedByName = "transformCategoriesToCustomerFriendlyCategories"),
			@Mapping(target = "offerBanners", source = "banners", qualifiedByName = "transformBannersToOfferBanners"),
			@Mapping(target = "promotionalEvents", source = "events", qualifiedByName = "transformEventsToPromotionalEvents") })
	com.safeway.j4u.emju.offers.model.offersetup.Offer toJ4UOffer(OfferDetails offerDetails);

	@Named("transformCategoriesToCustomerFriendlyCategories")
	default List<OfferCustomerFriendlyCategory> transformCategoriesToCustomerFriendlyCategories(
			Map<String, String> categories) {
		if (Optional.fromNullable(categories).isPresent()) {
			List<OfferCustomerFriendlyCategory> offerCustomerFriendlyCategories = Lists.newArrayList();
			categories.entrySet().stream().forEach(category -> {
				OfferCustomerFriendlyCategory offerCustomerFriendlyCategory = OfferCustomerFriendlyCategory.builder()
						.customerFriendlyCategoryId(category.getKey().replaceFirst("categories", ""))
						.customerFriendlyCategoryName(category.getValue()).build();
				offerCustomerFriendlyCategories.add(offerCustomerFriendlyCategory);
			});
			return offerCustomerFriendlyCategories;
		} else {
			return Collections.emptyList();
		}
	}

	@Named("transformBannersToOfferBanners")
	default List<OfferBanner> transformBannersToOfferBanners(Map<String, String> banners) {
		if (Optional.fromNullable(banners).isPresent()) {
			List<OfferBanner> offerBanners = Lists.newArrayList();
			banners.entrySet().stream().forEach(banner -> {
				OfferBanner offerBanner = OfferBanner.builder().bannerCode(banner.getKey())
						.vendorBannerCode(banner.getValue()).build();
				offerBanners.add(offerBanner);
			});
			return offerBanners;
		} else {
			return Collections.emptyList();
		}
	}

	@Named("transformEventsToPromotionalEvents")
	default List<PromotionalEvent> transformEventsToPromotionalEvents(Map<String, String> events) {
		if (Optional.fromNullable(events).isPresent()) {
			List<PromotionalEvent> promotionalEvents = Lists.newArrayList();
			events.entrySet().stream().forEach(event -> {
				PromotionalEvent promotionalEvent = PromotionalEvent.builder()
						.promotionalEventId(event.getKey().substring(OffersConstants.COLUMN_EVENTS.length(),
								event.getKey().length()))
						.promotionalEventDescription(event.getValue()).eventHiddenIndicator("0").build();
				promotionalEvents.add(promotionalEvent);
			});
			return promotionalEvents;
		} else {
			return Collections.emptyList();
		}
	}

	static List<String> transformStoresOrPostalCodes(Set<String> fromStoreIds, Set<Integer> fromPostalCodes) {
		List<String> postalCodes = Lists.newArrayList();
		if (Optional.fromNullable(fromStoreIds).isPresent()) {
			fromStoreIds.stream().forEach(storeId -> {
				postalCodes.add(storeId);
			});
		}
		return postalCodes;
	}
}
