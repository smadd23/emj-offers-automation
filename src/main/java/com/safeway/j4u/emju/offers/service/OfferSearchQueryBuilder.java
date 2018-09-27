package com.safeway.j4u.emju.offers.service;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.safeway.j4u.emju.offers.model.OfferSearchCriteria;
import com.safeway.j4u.emju.offers.util.OffersConstants;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class OfferSearchQueryBuilder {

	public Select buildAttributesClause(List<OfferSearchCriteria> srchCriteriaList) {
		Select select = QueryBuilder.select()
				.column("offer_id")
				.column("external_offer_id")
				.column("aggregator_offer_id")
				.column("offer_provider_nm")
				.column("categories")
				.column("primary_category")
				.column("events")
				.column("offer_program_cd")
				.column("offer_sub_program")
				.column("offer_status")
				.column("price_title")
				.column("price_value")
				.column("savings_value_txt")
				.column("title_desc")
				.column("product_desc")
				.column("disclaimer_txt")
				.column("receipt_descriptions")
				.column("product_img_id")
				.column("price_code")
				.column("is_employee_offer")
				.column("is_default_allocation_offer")
				.column("offer_program_type")
				.column("should_report_redemptions")
				.column("promo_class_id")
				.column("create_ts")
				.column("create_app_id")
				.column("create_user_id")
				.column("last_updated_app_id")
				.column("last_updated_user_id")
				.column("last_update_ts")
				.column("display_effective_start_dt")
				.column("display_effective_end_dt")
				.column("offer_effective_start_dt")
				.column("offer_effective_end_dt")
				.column("offer_test_effective_start_dt")
				.column("offer_test_effective_end_dt")
				.column("divisions")
				.column("store_groups")
				.column("store_ids")
				.column("postal_codes")
				.column("upcs")
				.column("terminals")
				.column("qualification_unit_type")
				.column("qualification_unit_sub_type")
				.column("min_prod_purchase_units")
				.column("max_prod_purchase_units")
				.column("benefit_value_type")
				.column("usage_limit_type_per_user")
				.column("usage_limit_per_user")
				.column("is_buy_x_get_y_offer")
				.column("banners")
				.column("channels")
				.column("min_order_total_amount")
				.column("min_reward_points")
				.column("min_prod_purchase_units")
				.column("is_benefit_value_applicable_to_buy_items")
				.column("is_benefit_value_applicable_to_get_items")
				.column("is_benefit_value_restricted_to_multiples_of_min_units")
				.column("benefit_value")
				.column("departments")
				.column("usage_limit_type_per_offer")
				.column("usage_limit_per_offer")
				.from(OffersConstants.CORE_OFFER_DETAILS);
		Select.Where where = select.where();
		StringBuilder searchExpression = new StringBuilder();

		srchCriteriaList.stream().forEach(srchCriteria -> {
			searchExpression.append((searchExpression.length() > 0 ? " AND " : "") + srchCriteria.getKey() + ":"
					+ srchCriteria.getValue());
		});

		where.and(QueryBuilder.eq("solr_query", searchExpression.toString()));
		return select;
	}

	public Optional<Select> buildHouseholdIdClause(List<OfferSearchCriteria> srchCriteriaList) {
		Optional<Select> ss = srchCriteriaList.stream()
				.filter(s -> s.getKey().equals(OffersConstants.COLUMN_HOUSEHOLD_ID)).findFirst().map(householdId -> {
					Select select = QueryBuilder.select().from(OffersConstants.CORE_OFFERS_BY_HOUSEHOLDS);
					select.where().and(QueryBuilder.eq("solr_query", "household_id :" + householdId.getValue()));
					return select;
				});

		return ss;
	}

}
