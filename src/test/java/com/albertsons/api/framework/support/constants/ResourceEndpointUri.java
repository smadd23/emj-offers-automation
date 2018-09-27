package com.albertsons.api.framework.support.constants;

/** This class contains the resource endpoint uri's. */

public final class ResourceEndpointUri {
  public static final String SLASH_DELIMITER = "/";
  public static final String QUERY_DELIMITER = "?q=";
  public static final String GALLERY_CORE = "/J4UProgram1/polaris/services/gallery";
  public static final String GALLERY_OFFERS = "/offers";
  public static final String GALLERY_ANONYMOUS =
      "/J4UProgram1/polaris/services/gallery/offers/anonymous";

  // Ecom endpoints
  public static final String ECOM_AISLE = "/ecom/api/aisle";
  public static final String ECOM_HISTORYLASTORDER = "/ecom/api/historylastorder";
  public static final String ECOM_HISTORYLIST = "/ecom/api/historylist";
  public static final String ECOM_HISTORYLISTBYAISLES = "/ecom/api/historylistbyaisles";
  public static final String ECOM_CART = "/ecom/api/cart";
  public static final String ECOM_SEARCH = "/ecom/api/search";
  public static final String ECOM_AEMSEARCH = "/ecom/api/aemsearch";
  public static final String ECOM_PROMOCODEDEAL = "/ecom/api/promocodedeals";
  public static final String ECOM_PRODUCTDETAILS = "/ecom/api/product/";
  public static final String ECOM_CLUBCARDSPECIALS = "/ecom/api/clubcardspecials";
  public static final String ECOM_BOGOSPECIALS = "/ecom/api/bogospecials";
  public static final String ECOM_AEMPRODUCTDETAILS = "/ecom/api/aemproduct/";
  public static final String ECOM_AEMCLUBCARDSPECIALS = "/ecom/api/aemclubcardspecials";
  public static final String ECOM_AEMBOGOSPECIALS = "/ecom/api/aembogospecials";
  public static final String ECOM_AEMPROMOCODEDEALS = "/ecom/api/aempromocodedeals/";
  public static final String ECOM_ORDERLIST = "/ecom/api/order";
  public static final String ECOM_AEMAISLE = "/ecom/api/aemaisle";
  public static final String ECOM_AEMHISTORYLASTORDER = "/ecom/api/aemhistorylastorder";
  public static final String ECOM_DELIVERYSLOTFORGUEST = "/ecom/api/DeliveryForGuest";
  public static final String ECOM_DELIVERY = "/ecom/api/delivery";
  public static final String ECOM_DELIVERYPREFERENCE = "/ecom/api/account/deliverypreferences";
  public static final String ECOM_COOKIELIST = "/ecom/api/cookie";
  public static final String ECOM_PRELOAD = "/ecom/api/preload";
  public static final String ECOM_PRECHECKOUT = "/ecom/api/precheckout";
  public static final String ECOM_PROMOCODE = "/ecom/api/promocode";
  public static final String ECOM_SIGNIN = "/ecom/api/signin";
  public static final String ECOM_SUBSTITUTION = "/ecom/api/substitution";
  public static final String ECOM_PRODUCTSBYBPN = "/ecom/api/ProductsByBPN";
  public static final String ECOM_PRODUCTSBYUPC = "/ecom/api/ProductsByUPC";
  public static final String ECOM_PRODUCTPRICEBYBPN = "/ecom/api/ProductPricebyBPN";
  public static final String ECOM_DUGSTORES = "/ecom/api/dugstores";
  public static final String ECOM_GETUSERSELECTEDSLOT = "/ecom/api/getUserSelectedSlot";
  public static final String ECOM_NEXTDELIVERYSLOTS = "/ecom/api/nextdeliveryslots";
  public static final String ECOM_CARTSUMMARY = "/ecom/api/cartsummary";
  public static final String ECOM_ZIP = "/ecom/api/zip";
  public static final String ECOM_REGISTER = "/ecom/api/register";

  // UCA endpoints
  public static final String UCA_REWARDS = "/api/uca/customers/1/rewards";
  public static final String UCA_ADDRESS = "/api/uca/customers/1/addresses";
  public static final String UCA_STORES = "/api/uca/customers/1/stores";
  public static final String UCA_SUBSCRIPTION = "/api/uca/customers/1/subscriptions";
  public static final String UCA_LOYALTYPARTNERS = "/api/uca/customers/1/loyaltypartners";
  public static final String UCA_DIGITALRECEIPTS = "/api/uca/customers/1/purchases?";
  public static final String UCA_DIGITALRECEIPTS_DETAIL = "/api/uca/customers/1/purchases/";
  public static final String UCA_REGISTER = "/api/uca/customers/register";
  public static final String UCA_KMSI = "/api/uca/customers/1/kmsi";
  public static final String UCA_PROFILE = "/api/uca/customers/1/profile";
  public static final String UCA_PASSWORD = "/api/uca/pwd";
  public static final String UCA_DELTAREGISTER = "/api/uca/customers/register/stepup";

  // Copient endpoints
  public static final String EXTERNAL_OFFER_CONNECTER = "/CPE/ExternalOfferConnector.asmx/AddOffer";
  public static final String EXTERNAL_OFFER_CONNECTER_CLIP_BUNDLE =
      "/CPE/ExternalOfferConnector.asmx/ClipBundle";
  public static final String CUSTOMER_UPDATE = "/CustomerUpdate.asmx/Update";

  //OfferSearch endpoint
  public static final String OFFER_SEARCH="/offer";

  public ResourceEndpointUri() {
    /* This class should not be instantiated */
  }
}
