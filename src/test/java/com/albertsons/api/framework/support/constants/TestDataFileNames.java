package com.albertsons.api.framework.support.constants;

/** This class defines test data file name used in the test. */
public final class TestDataFileNames {

  /* Test data for json schema validation */
  public static final String AUTHENTICATED_GALLERY_SCHEMA =
      "authenticated_gallery_json_schema.json";
  public static final String GET_REWARDS_SCHEMA = "get_rewards_schema.json";
  public static final String OFFER_SEARCH_PARENT_STATUS_SCHEMA = "offerSearchParent_status_schema.json";

  // Copient responses
  public static final String ADD_NEW_OFFER = "addNew_offer.xml";
  public static final String ADD_EXISTING_OFFER = "addExisting_offer.xml";
  public static final String ADD_OFFER_NOCLIENTID = "addOffer_noClientid.xml";
  public static final String ADD_EXISTING_OFFER_ANOTHER_SOURCEID =
      "addExistingOffer_anotherSouceId.xml";
  public static final String ADD_OFFER_INVALID_SOURCEID = "addOffer_invalidSourceid.xml";
  public static final String ADD_OFFER_INVALID_OFFERXML = "addOffer_invalidOfferXml.xml";
  public static final String CLIP_BUNDLE = "clipBundle.xml";
  public static final String CUSTOMER_ATTRIBUTE_UPDATE = "updateCustomer_attribute.xml";
  public static final String CUSTOMER_ATTRIBUTE_UPDATE_IRRELEVANT_TYPE =
      "updateCustomerwithIrrelevantType.xml";
  public static final String CUSTOMER_ATTRIBUTE_UPDATE_INVALID_GUID =
      "customerUpdate_InvalidGuid.xml";
  public static final String CUSTOMER_ATTRIBUTE_UPDATE_INVALID_XML =
      "customerUpdate_invalidXml.xml";
  public static final String UPDATE_HOUSE_HOLD = "updateHousehold.xml";
  public static final String REMOVE_CUSTOMER_ATTRIBUTE = "removeCustomerAttribute.xml";

  /* UCA Test data for response validation */
  public static final String AUTH_OFFER_WITH_VALID_STORE_AND_PRGM =
      "authenticated_offer_with_valid_store_id_and_program.json";
  public static final String GET_REWARDS_NO_REWARDS = "getrewards_norewards";
  public static final String GET_REWARDS_WITH_REWARDS = "getrewards_rewards";
  public static final String GET_PROFILE_FOR_FULL_REGISTERED_USER = "getprofile_validdetails";
  public static final String GET_PROFILE_FOR_LOYALTY_USER = "getprofileloyalty_validdetails";
  public static final String GET_DELIVERY_ADDRESS = "get_delivery_address.json";
  public static final String GET_STORES = "get_stores.json";
  public static final String PROFILE_UPDATE_PHONE_RESPONSE = "profile_update_phone_response.json";
  public static final String USER_SUBSCRIPTION_DETAILS_RESPONSE =
      "user_subscription_details_response.json";
  public static final String USER_LOYALTYPARTNERS_RESPONSE = "user_loyaltyPartners_response.json";
  public static final String GET_DIGITAL_RECEIPTS = "get_digitalreceipts_validdetails.json";
  public static final String GET_DIGITAL_RECEIPTS_DETAIL =
      "get_digitalreceiptsdetail_validdetails.json";

  // Ecom Response files
  public static final String LAST_ORDER_HISTORY = "last_order_history.json";
  public static final String GET_AEM_AISLE = "get_aem_aisle_response.json";
  public static final String ORDER_HISTORY = "order_history.json";
  public static final String SIGNIN_ERROR = "ecom_singin_error.json";
  public static final String EXPIRED_TOKEN_ERROR = "ecom_expired_token_error.json";
  public static final String INVALID_TOKEN_ERROR = "ecom_invalid_token_error.json";
  public static final String GET_CART_ITEMS = "get_cart_items.json";
  public static final String POST_CART_ITEMS = "post_cart_items.json";
  public static final String GET_CART_ITEMS_NON_EXISTING_ORDER =
      "get_cart_items_non_existing_order.json";
  public static final String GET_CART_ITEMS_INVALID_ORDER = "get_cart_items_invalid_order.json";
  public static final String GET_EMPTY_CART = "get_empty_cart.json";
  public static final String GET_PRODUCT_SEARCH = "get_product_search_response.json";
  public static final String GET_AEM_PRODUCT_SEARCH_RESPONSE =
      "get_aem_product_search_response.json";
  public static final String GET_SEARCH_BY_KEYWORDBRAND_RESPONSE =
      "get_product_searchbykeywordandbrand_response.json";
  public static final String GET_AEM_SEARCH_BY_KEYBRAND_RESPONSE =
      "get_aem_product_searchbykeyandbrand_response.json";
  public static final String NO_RESULT_PRODUCT_SEARCH = "no_result_product_search_response.json";
  public static final String NO_RESULT_AEM_PRODUCT_SEARCH =
      "no_result_aem_product_search_response.json";
  public static final String GET_AEM_CLUB_CARD_SPECIALS_RESPONSE =
      "get_aem_club_card_specials_response.json";
  public static final String GET_CLUB_CARD_SPECIALS_ERROR_RESPONSE =
      "get_club_card_specials_error_response.json";
  public static final String PRODUCT_DETAILS = "product_details.json";
  public static final String GET_PROMOCODE_DEALS = "get_promocode_deals_response.json";
  public static final String GET_ORDERS_LIST_RESPONSE = "get_orders_list_response.json";
  public static final String GET_BOGO_SPECIALS_RESPONSE =
      "ecomintegration/get_bogo_specials_response.json";
  public static final String GET_BOGO_SPECIALS_ERROR_RESPONSE =
      "ecomintegration/get_bogo_specials_error_response.json";
  public static final String GET_AEM_PRODUCT_DETAILS_RESPONSE =
      "get_aem_product_details_response.json";
  public static final String GET_AISLE_LIST_RESPONSE = "get_aisle_list_response.json";
  public static final String GET_GUEST_AISLE_LIST_RESPONSE = "get_guest_aisle_list_response.json";
  public static final String GET_DELIVERY_FOR_GUEST_RESPONSE = "delivery_for_guest_response.json";
  public static final String GET_DELIVERY_SLOTS_RESPONSE = "get_delivery_slots_response.json";
  public static final String GET_NEXT_DELIVERY_SLOTS_RESPONSE = "get_next_delivery_slots_response.json";
  public static final String POST_DELIVERY_SLOTS_RESPONSE = "post_delivery_slots_response.json";
  public static final String PROMO_CODE_DEALS_RESPONSE = "promo_code_deals_response.json";
  public static final String COOKIES_LIST_RESPONSE = "cookies_list_response.json";
  public static final String PRELOAD_RESPONSE = "preload_response.json";
  public static final String PROMOCODE_RESPONSE = "promocode_response.json";
  public static final String SIGNIN_RESPONSE = "signin_response.json";
  public static final String SUBSTITUTION_LIST_RESPONSE = "substitution_list_response.json";
  public static final String SUBSTITUTION_EDIT_RESPONSE = "substitution_edit_response.json";
  public static final String GET_CLUB_CARD_SPECIALS_RESPONSE =
      "get_club_card_specials_response.json";
  public static final String GET_AEM_BOGO_SPECIALS_RESPONSE = "get_aem_bogo_specials_response.json";
  public static final String GET_BOGO_SPECIALS_NO_PARAMS_RESPONSE =
      "ecomintegration/get_bogo_specials_no_params_response.json";
  public static final String PRODUCTS_BY_SHELF_RESPONSE =
      "ecomintegration/get_products_byshelf_response.json";
  public static final String PRODUCTS_BY_BPN_RESPONSE =
      "ecomintegration/post_products_bybpn_response.json";
  public static final String DELIVERY_PREFERENCES_RESPONSE =
      "ecomintegration/get_delivery_preferences_response.json";
  public static final String GET_USERSELECTED_SLOT_RESPONSE = "ecomintegration/get_userselected_slot_response.json";
  public static final String CARTSUMMARY_RESPONSE = "cartsummary_response.json";
  public static final String ZIPCODE_RESPONSE = "zipcode_response.json";
  public static final String GET_REG_INFO_RESPONSE = "get_reginfo_response.json";

  // Ecom Schema files
  public static final String LAST_ORDER_HISTORY_SCHEMA = "last_order_json_schema.json";
  public static final String GET_AISLE_SCHEMA = "get_aisle_schema.json";
  public static final String GET_AEM_AISLE_SCHEMA = "get_aem_aisle_schema.json";
  public static final String ORDER_HISTORY_SCHEMA = "order_history_json_schema.json";
  public static final String SIGNIN_ERROR_SCHEMA = "ecom_sigin_error_schema.json";
  public static final String GET_CART_ITEMS_SCHEMA = "get_cart_items_schema.json";
  public static final String POST_CART_ITEMS_SCHEMA = "post_cart_items_schema.json";
  public static final String GET_CART_NONEXISTORDER_SCHEMA = "get_cart_nonexistorder_schema.json";
  public static final String GET_SEARCH_RESULT_SCHEMA = "get_product_search_schema.json";
  public static final String GET_AEM_SEARCH_RESULT_SCHEMA = "get_aem_product_search_schema.json";
  public static final String GET_AEM_CLUB_CARD_SPECIALS_SCHEMA =
      "get_aem_club_card_specials_schema.json";
  public static final String GET_PROMOCODE_DEALS_SCHEMA = "get_promocode_deals_schema.json";
  public static final String GET_ORDERS_LIST_SCHEMA = "get_orders_list_schema.json";
  public static final String PRODUCT_DETAILS_SCHEMA = "product_details_json_schema.json";
  public static final String GET_BOGO_SPECIALS_SCHEMA = "get_bogo_specials_schema.json";
  public static final String GET_AISLE_LIST_SCHEMA = "get_aisle_list_schema.json";
  public static final String GET_SEARCH_BY_KEYWORDBRAND_SCHEMA =
      "get_product_searchbykeywordandbrand_schema.json";
  public static final String GET_AEM_SEARCH_BY_KEYBRAND_SCHEMA =
      "get_aem_prod_searchbykeyandbrand_schema.json";
  public static final String GET_DELIVERY_FOR_GUEST_SCHEMA = "delivery_for_guest_schema.json";
  public static final String GET_DELIVERY_PREFERENCES_SCHEMA =
      "ecomintegration/get_delivery_preferences_schema.json";
  public static final String GET_DELIVERY_SLOTS_SCHEMA = "get_deliverySlots_schema.json";
  public static final String GET_NEXT_DELIVERY_SLOTS_SCHEMA = "get_next_deliverySlots_schema.json";
  public static final String POST_DELIVERY_SLOTS_SCHEMA = "post_deliverySlots_schema.json";
  public static final String PROMO_CODE_DEALS_SCHEMA = "promocodedeals_schema.json";
  public static final String COOKIES_LIST_SCHEMA = "cookies_list_schema.json";
  public static final String PRELOAD_SCHEMA = "preload_schema.json";
  public static final String PROMOCODE_SCHEMA = "promocode_schema.json";
  public static final String SIGNIN_SCHEMA = "signin_schema.json";
  public static final String SUBSTITUTION_LIST_SCHEMA = "substitution_list_schema.json";
  public static final String SUBSTITUTION_EDIT_SCHEMA = "substitution_edit_schema.json";
  public static final String GET_CLUB_CARD_SPECIALS_SCHEMA = "get_club_card_specials_schema.json";
  public static final String GET_BOGO_SPECIALS_NO_PARAMS_SCHEMA =
      "ecomintegration/get_bogo_specials_no_params_schema.json";
  public static final String PRODUCTS_BY_SHELF_SCHEMA =
      "ecomintegration/get_products_byshelf_schema.json";
  public static final String PRODUCTS_BY_BPN_SCHEMA =
      "ecomintegration/post_products_bybpn_schema.json";
  public static final String PRODUCT_PRICE_BY_BPN_SCHEMA =
      "ecomintegration/post_product_price_bybpn_schema.json";
  public static final String GET_DUGSTORES_SCHEMA = "ecomintegration/get_dugstores_schema.json";
  public static final String GET_USERSELECTED_SLOT_SCHEMA = "ecomintegration/get_userselectedslot_schema.json";
  public static final String CARTSUMMARY_SCHEMA = "cartsummary_schema.json";
  public static final String ECOM_MESSAGE_SCHEMA = "ecom_message_schema.json";
  public static final String ECOM_GET_REGISTER_INFO_SCHEMA =  "get_register_information_schema.json";

  // UCP Schema Files
  public static final String GET_DELIVERY_ADDRESS_SCHEMA = "get_deliveryAddress_schema.json";
  public static final String PROFILE_UPDATE_RESPONSE_SCHEMA = "profile_update_response_schema.json";
  public static final String GET_STORES_SCHEMA = "get_stores_schema.json";
  public static final String USER_SUBSCRIBTION_DETAILS_SCHEMA =
      "user_subscription_details_schema.json";
  public static final String USER_LOYALTYPARTNERS_SCHEMA = "user_loyaltyPartners_schema.json";

  // Ecom Body data files
  public static final String PROMOCODE_ADD_BODY = "promocodetest_addpromo.json";
  public static final String PROMOCODE_DELETE_BODY = "promocodetest_deletepromo.json";
  public static final String DELIVERYSLOT_RESERVE_BODY = "deliveryslotstest_reserveslot.json";
  public static final String CARTSERVICE_DATARESET_BODY = "cartservicestest_datareset.json";
  public static final String CARTSERVICE_DATAUPDATE_BODY = "cartservicestest_dataupdate.json";
  public static final String CARTSERVICE_INVALID_DATAUPDATE_BODY = "cartservicestest_invalid_dataupdate.json";
  public static final String SUBSTITUTION_EDIT_MC_BODY = "substitutiontest_edit_MC.json";
  public static final String SUBSTITUTION_EDIT_TS_BODY = "substitutiontest_edit_TS.json";
  public static final String SUBSTITUTION_EDIT_INVALID_BODY = "substitutiontest_edit_invalid.json";
  public static final String COMMONAPI_ADD_CARTITEMS = "commonapi-addcartitems.json";
  public static final String PRODUCTSBYBPN_BODY = "productsbybpntest_idlist.json";
  public static final String PRODUCTSBYUPC_BODY = "productsbyupctest_idlist.json";
  public static final String DELIVERYPREFERENCES_SUPERDUG_BODY = "deliverypreferencestest_superDug.json";
  public static final String DELIVERYPREFERENCES_PREFADDRESS_BODY = "deliverypreferencestest_prefAddress.json";
  public static final String GETUSERSELECTEDSLOTS_BLANK_BODY = "getuserselectedslot_blank.txt";
  public static final String PRODUCTSEARCH_BODY = "productsearchtest_bodydata.json";
  public static final String AEMAISLE_BODY = "aemaisletest_body.json";
  public static final String HISTORYLIST_BY_AISLES_BODY = "historylistbyaislestest_body.json";
  public static final String ZIPCODE_BODY = "zipcode_body.json";

  // UCP Body data files
  public static final String REGISTER_SHORT = "shortregistration_validdetails.json";
  public static final String REGISTER_FULL = "fullregistration_validdetails.json";
  public static final String REGISTER_DELTA = "deltaregistration_validdetails.json";
  public static final String KMSI_UPDATE = "kmsi_update.json";
  public static final String UPDATEPROFILE_EMAILANDNAME = "updateprofile_emailandname.json";
  public static final String UPDATEPROFILE_SHORT_EMAILANDNAME =
      "updateprofile_short_emailandname.json";
  public static final String UPDATEPROFILE_PHONE = "updateprofile_phone.json";
  public static final String UPDATE_PASSWORD = "updateprofile_password.json";

  // Temporary Files were being used for dynamic data preparation of json.
  public static final String REGISTER_TEMP = "tempfile_registration.json";
  public static final String PROFILE_TEMP = "tempfile_profile.json";

  //Offer search Data
  public static final String OFFER_SEARCH_BY_OFFERID = "offerSearch/responseOne.json";
  public static final String OFFER_SEARCH_BY_STOREID = "offerSearch/responseThree.json";
  public static final String OFFER_SEARCH_BY_HHID = "offerSearch/offer_search_by_hhid.json";
  public static final String OFFER_SEARCH_BY_ZIP = "offerSearch/responseTwo.json";

  public static final String OFFER_SEARCH_BY_OFFERID_SCHEMA = "offer_search_by_offerID_schema.json";
  public static final String OFFER_SEARCH_BY_OFFERSTATUS_SCHEMA = "offer_search_by_status_schema.json";

  public TestDataFileNames() {
    /* This class should not be instantiated */
  }
}
