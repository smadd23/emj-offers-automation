package com.safeway.j4u.emju.offers.entity;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Builder(toBuilder=true)
@Table("offer_details")
public class OfferDetails {

	@PrimaryKey("offer_id")
	private Long offerId;
	@Column("external_offer_id")
	private String externalOfferId;
	@Column("aggregator_offer_id")
	private String aggregatorOfferId;
	@Column("offer_provider_nm")
	private String offerProviderName;
	@Column("categories")
	private Map<String, String> categories;
	@Column("categories_set")
	private Set<String> categoriesSet;
	@Column("primary_category")
	private Map<String, String> primaryCategory;
	@Column("primary_category_set")
	private Set<String> primaryCategorySet;
	@Column("events")
	private Map<String, String> events;
	@Column("events_set")
	private Set<String> eventsSet;
	@Column("offer_program_cd")
	private String offerProgramCode;
	@Column("offer_sub_program")
	private String offerSubProgram;
	@Column("offer_status")
	private String offerStatus;
	@Column("price_title")
	private String priceTitle;
	@Column("price_value")
	private String priceValue;
	@Column("savings_value_txt")
	private String savingsValueText;
	@Column("title_desc")
	private Map<String, String> titleDescription;
	@Column("title_desc_set")
	private Set<String> titleDescriptionSet;
	@Column("product_desc")
	private Map<String, String> productDescription;
	@Column("product_desc_set")
	private Set<String> productDescriptionSet;
	@Column("disclaimer_txt")
	private String disclaimerText;
	@Column("receipt_descriptions")
	private String receiptDescriptions;
	@Column("product_img_id")
	private String productImageId;
	@Column("price_code")
	private String priceCode;
	@Column("is_employee_offer")
	private Boolean isEmployeeOffer;
	@Column("is_default_allocation_offer")
	private Boolean isDefaultAllocationOffer;
	@Column("offer_program_type")
	private String offerProgramType;
	@Column("should_report_redemptions")
	private Boolean shouldReportRedemptions;
	@Column("promo_class_id")
	private String promoClassId;
	@Column("create_ts")
	private ZonedDateTime createdTs;
	@Column("create_app_id")
	private String createdApplicationId;
	@Column("create_user_id")
	private String createdUserId;
	@Column("last_updated_app_id")
	private String lastUpdatedApplicationId;
	@Column("last_updated_user_id")
	private String lastUpdatedUserId;
	@Column("last_update_ts")
	private ZonedDateTime lastUpdatedTs;
	@Column("display_effective_start_dt")
	private ZonedDateTime displayEffectiveStartDate;
	@Column("display_effective_end_dt")
	private ZonedDateTime displayEffectiveEndDate;
	@Column("offer_effective_start_dt")
	private ZonedDateTime offerEffectiveStartDate;
	@Column("offer_effective_end_dt")
	private ZonedDateTime offerEffectiveEndDate;
	@Column("offer_test_effective_start_dt")
	private ZonedDateTime offerTestEffectiveStartDate;
	@Column("offer_test_effective_end_dt")
	private ZonedDateTime offerTestEffectiveEndDate;
	@Column("divisions")
	private Map<String, String> divisions;
	@Column("divisions_set")
	private Set<String> divisionsSet;
	@Column("store_groups")
	private Set<String> storeGroups;
	@Column("store_ids")
	private Set<String> storeIds;
	@Column("postal_codes")
	private Set<Integer> postalCodes;
	@Column("upcs")
	private Set<Long> upcs;
	@Column("terminals")
	private Set<String> terminals;
	@Column("qualification_unit_type")
	private String qualificationUnitType;
	@Column("qualification_unit_sub_type")
	private String qualificationUnitSubType;
	@Column("min_prod_purchase_units")
	private Integer minProdPurchaseUnits;
	@Column("max_prod_purchase_units")
	private Integer maxProdPurchaseUnits;
	@Column("benefit_value_type")
	private String benefitValueType;
	@Column("usage_limit_type_per_user")
	private String usageLimitTypePerUser;
	@Column("usage_limit_per_user")
	private Long usageLimitPerUser;
	@Column("is_buy_x_get_y_offer")
	private Boolean isBuyXGetYOffer;
	@Column("banners")
	private Map<String, String> banners;
	@Column("banners_set")
	private Set<String> bannersSet;
	@Column("channels")
	private Set<String> channels;
	@Column("min_order_total_amount")
	private Double minOrderTotalAmount;
	@Column("min_reward_points")
	private Integer minRewardPoints;
	@Column("min_prod_purchase_units")
	private Integer minGetProdPurchaseUnits;
	@Column("is_benefit_value_applicable_to_buy_items")
	private Boolean isBenefitValueApplicableToBuyItems;
	@Column("is_benefit_value_applicable_to_get_items")
	private Boolean isBenefitValueApplicableToGetItems;
	@Column("is_benefit_value_restricted_to_multiples_of_min_units")
	private Boolean isBenefitValueRestrictedToMultiplesOfMinUnits;
	@Column("benefit_value")
	private Double offerprice;
	@Column("departments")
	private Set<String> departments;
	@Column("usage_limit_type_per_offer")
	private String usageLimitTypePerOffer;
	@Column("usage_limit_per_offer")
	private Long usageLimitPerOffer;
	@Transient
	private boolean fakeDefaultOffer = false;
}