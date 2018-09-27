package com.safeway.j4u.emju.offers.model.offersetup;

import java.time.ZonedDateTime;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.safeway.j4u.emju.offers.model.UsageLimitType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlRootElement(name="Offer", namespace="http://www.safeway.com/app/emju/offersetup/domain" )
@XmlAccessorType(XmlAccessType.NONE)
public class Offer {
	@XmlElement(name="OfferId")
	private Long offerId;
	@XmlElement(name="CustomerFriendlyProgramId")
	private String customerFriendlyProgramId;
	@XmlElement(name="UsageLimitTypeCode")
	private UsageLimitType usageLimitTypeCode;
	@XmlElement(name="PriceMethodCode")
	private String priceMethodCode;
	@XmlElement(name="OfferEffectiveStartDate")
	private ZonedDateTime offerEffectiveStartDate;
	@XmlElement(name="OfferEffectiveEndDate")
	private ZonedDateTime offerEffectiveEndDate;
	@XmlElement(name="DisplayEffectiveStartDate")
	private ZonedDateTime displayEffectiveStartDate;
	@XmlElement(name="DisplayEffectiveEndDate")
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
	private ZonedDateTime lastUpdatedTimestamp;
	@XmlElement(name="OfferStatusTypeId")
	private String offerStatusTypeId;
	@XmlElement(name="LastUpdateUserId")
	private String lastUpdateUserId;
	@XmlElement(name="SourceOfferId")
	private String serviceProviderOfferId;
	@XmlElement(name="PostalCodes")
	private List<PostalCode> postalCds;
	@XmlElement(name="OfferVerbiage")
	private OfferVerbiage offerVerbiage;
	@XmlElement(name="CustomerFriendlyCategory")
	private CustomerFriendlyCategory customerFriendlyCategory;
	@XmlElement(name="OfferCustomerFriendlyCategories")
	private List<OfferCustomerFriendlyCategory> offerCustomerFriendlyCategories;
	@XmlElement(name="OfferBanners")
	private List<OfferBanner> offerBanners;
}
