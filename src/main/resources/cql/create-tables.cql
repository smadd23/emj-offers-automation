CREATE TABLE IF NOT EXISTS offers.offer_details ( offer_id bigint PRIMARY KEY, external_offer_id text, offer_provider_nm text, aggregator_offer_id text,
categories map<text, text>, primary_category map<text, text>, events map<text, text>, display_effective_start_dt timestamp,
display_effective_end_dt timestamp, offer_effective_start_dt timestamp, offer_effective_end_dt timestamp, offer_test_effective_start_dt timestamp,
offer_test_effective_end_dt timestamp, offer_program_cd text, offer_sub_program text, offer_status text, price_title text,
price_value text, savings_value_txt text, title_desc map<text,text>, product_desc map<text,text>, disclaimer_txt text, product_img_id text, 
banners map<text,text>, divisions map<text,text>, price_code text, is_employee_offer boolean, is_default_allocation_offer boolean, offer_program_type text,
should_report_redemptions boolean, promo_class_id text, receipt_descriptions text, store_groups set<text>, store_ids set<text>, postal_codes set<int>, upcs set<int>,
channels set<text>, terminals set<text>, qualification_unit_type text, qualification_unit_sub_type text, min_prod_purchase_units int, max_prod_purchase_units int,
min_order_total_amount double, min_reward_points int, benefit_value_type text, benefit_value double, is_buy_x_get_y_offer boolean, 
min_get_prod_purchase_units int, is_benefit_value_applicable_to_buy_items boolean, is_benefit_value_applicable_to_get_items boolean, 
is_benefit_value_restricted_to_multiples_of_min_units boolean, departments set<text>, usage_limit_type_per_user text,
usage_limit_type_per_offer text, usage_limit_per_offer bigint, usage_limit_per_user bigint, create_app_id text, create_user_id text, create_ts timestamp,
last_updated_app_id text, last_updated_user_id text, last_update_ts timestamp );

CREATE SEARCH INDEX IF NOT EXISTS ON offers.offer_details with columns offer_id, external_offer_id, events, offer_program_type, price_code, offer_status,  offer_program_cd, offer_effective_start_dt, offer_effective_end_dt, store_ids, postal_codes, upcs, banners, categories, divisions, product_desc, title_desc;


CREATE TABLE IF NOT EXISTS offers.offers_by_household (household_id bigint PRIMARY KEY, offers_info_ map<text,text>);
CREATE SEARCH INDEX IF NOT EXISTS ON offers.offers_by_household with columns household_id, offers_info_;
