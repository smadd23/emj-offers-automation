package com.safeway.j4u.emju.offers.model.offersetup;

import java.time.ZonedDateTime;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.migesok.jaxb.adapter.javatime.ZonedDateTimeXmlAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlRootElement(name="Offer")
@XmlAccessorType(XmlAccessType.NONE)
public class Offer {
	@XmlElement(name="OfferId")
	private Long offerId;
	@XmlElement(name="CustomerFriendlyProgramId")
	private String customerFriendlyProgramId;
	@XmlElement(name="UsageLimitTypeCode")
	private String usageLimitTypeCode;
	@XmlElement(name="PriceMethodCode")
	private String priceMethodCode;
	@XmlElement(name="OfferEffectiveStartDate")
	@XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
	private ZonedDateTime offerEffectiveStartDate;
	@XmlElement(name="OfferEffectiveEndDate")
	@XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
	private ZonedDateTime offerEffectiveEndDate;
	@XmlElement(name="DisplayEffectiveStartDate")
	@XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
	private ZonedDateTime displayEffectiveStartDate;
	@XmlElement(name="DisplayEffectiveEndDate")
	@XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
	private ZonedDateTime displayEffectiveEndDate;
	@XmlElement(name="ServiceProviderName")
	private String serviceProviderName;
	@XmlElement(name="ExternalOfferId")
	private String externalOfferId;
	@XmlElement(name="OfferPrice")
	private Double offerPrice;
	@XmlElement(name="ProductImageId")
	private String productImageId;
	@XmlElement(name="LastUpdatedTimestamp")
	@XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
	private ZonedDateTime lastUpdatedTimestamp;
	@XmlElement(name="OfferProgramTypeCode")
	private String offerProgramTypeCode;
	@XmlElement(name="ShoppingListCFCategoryId")
	private String shoppingListCFCategoryId;
	@XmlElement(name="OfferStatusTypeId")
	private String offerStatusTypeId;
	@XmlElement(name="LastUpdateUserId")
	private String lastUpdateUserId;
	@XmlElement(name="SourceOfferId")
	private String serviceProviderOfferId;
	@XmlElementWrapper(name="PostalCodes")
	@XmlElement(name="PostalCode")
	private List<String> postalCds;
	@XmlElement(name="OfferVerbiage")
	private OfferVerbiage offerVerbiage;
	@XmlElement(name="CustomerFriendlyCategory")
	private CustomerFriendlyCategory customerFriendlyCategory;
	@XmlElementWrapper(name="OfferCustomerFriendlyCategories")
	@XmlElement(name="OfferCustomerFriendlyCategory")
	private List<OfferCustomerFriendlyCategory> offerCustomerFriendlyCategories;
	@XmlElementWrapper(name="OfferBanners")
	@XmlElement(name="OfferBanner")
	private List<OfferBanner> offerBanners;
	@XmlElementWrapper(name="PromotionalEvents")
	@XmlElement(name="PromotionalEvent")
	private List<PromotionalEvent> promotionalEvents;
}
