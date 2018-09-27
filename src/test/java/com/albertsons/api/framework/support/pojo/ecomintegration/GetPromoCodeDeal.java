package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class contains the pojo representation of promo code deal.
 *
 * @author vbonk00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "ack",
  "promo",
  "promoInterstitial",
  "promoCode",
  "products",
  "infoLabel",
  "image",
  "image2",
  "offerDescription",
  "totalProducts",
  "currentPage",
  "totalPages"
})
public class GetPromoCodeDeal {
  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("promo")
  private Promo promo;

  @JsonProperty("promoInterstitial")
  private PromoInterstitial promoInterstitial;

  @JsonProperty("promoCode")
  private String promoCode;

  @JsonProperty("products")
  private List<Product> products = null;

  @JsonProperty("infoLabel")
  private Object infoLabel;

  @JsonProperty("image")
  private Object image;

  @JsonProperty("image2")
  private Object image2;

  @JsonProperty("offerDescription")
  private String offerDescription;

  @JsonProperty("totalProduct")
  private Integer totalProduct;

  @JsonProperty("currentPage")
  private Integer currentPage;

  @JsonProperty("totalPages")
  private Integer totalPages;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("ack")
  public Boolean getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  @JsonProperty("promo")
  public Promo getPromo() {
    return promo;
  }

  @JsonProperty("promo")
  public void setPromo(Promo promo) {
    this.promo = promo;
  }

  @JsonProperty("promoInterstitial")
  public PromoInterstitial getPromoInterstitial() {
    return promoInterstitial;
  }

  @JsonProperty("promoInterstitial")
  public void setPromoInterstitial(PromoInterstitial promoInterstitial) {
    this.promoInterstitial = promoInterstitial;
  }

  @JsonProperty("promoCode")
  public String getPromoCode() {
    return promoCode;
  }

  @JsonProperty("promoCode")
  public void setPromoCode(String promoCode) {
    this.promoCode = promoCode;
  }

  @JsonProperty("products")
  public List<Product> getProducts() {
    return products;
  }

  @JsonProperty("products")
  public void setProducts(List<Product> products) {
    this.products = products;
  }

  @JsonProperty("infoLabel")
  public Object getInfoLabel() {
    return infoLabel;
  }

  @JsonProperty("infoLabel")
  public void setInfoLabel(Object infoLabel) {
    this.infoLabel = infoLabel;
  }

  @JsonProperty("image")
  public Object getImage() {
    return image;
  }

  @JsonProperty("image")
  public void setImage(Object image) {
    this.image = image;
  }

  @JsonProperty("image2")
  public Object getImage2() {
    return image2;
  }

  @JsonProperty("image2")
  public void setImage2(Object image2) {
    this.image2 = image2;
  }

  @JsonProperty("offerDescription")
  public String getOfferDescription() {
    return offerDescription;
  }

  @JsonProperty("offerDescription")
  public void setOfferDescription(String offerDescription) {
    this.offerDescription = offerDescription;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  public Integer getTotalProduct() {
    return totalProduct;
  }

  public void setTotalProduct(Integer totalProduct) {
    this.totalProduct = totalProduct;
  }

  public Integer getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
  }

  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof GetPromoCodeDeal)) return false;
    GetPromoCodeDeal that = (GetPromoCodeDeal) o;
    return Objects.equal(getAck(), that.getAck())
        && Objects.equal(getPromo(), that.getPromo())
        && Objects.equal(getPromoInterstitial(), that.getPromoInterstitial())
        && Objects.equal(getPromoCode(), that.getPromoCode())
        && Objects.equal(getProducts(), that.getProducts())
        && Objects.equal(getInfoLabel(), that.getInfoLabel())
        && Objects.equal(getImage(), that.getImage())
        && Objects.equal(getImage2(), that.getImage2())
        && Objects.equal(getOfferDescription(), that.getOfferDescription())
        && Objects.equal(getTotalProduct(), that.getTotalProduct())
        && Objects.equal(getCurrentPage(), that.getCurrentPage())
        && Objects.equal(getTotalPages(), that.getTotalPages());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        getAck(),
        getPromo(),
        getPromoInterstitial(),
        getPromoCode(),
        getProducts(),
        getInfoLabel(),
        getImage(),
        getImage2(),
        getOfferDescription(),
        getTotalProduct(),
        getCurrentPage(),
        getTotalPages());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("promo", promo)
        .add("promoInterstitial", promoInterstitial)
        .add("promoCode", promoCode)
        .add("products", products)
        .add("infoLabel", infoLabel)
        .add("image", image)
        .add("image2", image2)
        .add("offerDescription", offerDescription)
        .add("totalProduct", totalProduct)
        .add("currentPage", currentPage)
        .add("totalPages", totalPages)
        .toString();
  }
}
