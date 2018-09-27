package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of post delivery slots.
 *
 * @author vkuma26
 */
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({
  "ack",
  "isLessMinimum",
  "expiredOffers",
  "expiredProducts",
  "restrictedProducts"
})
public class PostDeliverySlots {

  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("isLessMinimum")
  private Boolean isLessMinimum;

  @JsonProperty("expiredOffers")
  private Object expiredOffers;

  @JsonProperty("expiredProducts")
  private Object expiredProducts;

  @JsonProperty("restrictedProducts")
  private Object restrictedProducts;

  @JsonProperty("ack")
  public Boolean getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  @JsonProperty("isLessMinimum")
  public Boolean getIsLessMinimum() {
    return isLessMinimum;
  }

  @JsonProperty("isLessMinimum")
  public void setIsLessMinimum(Boolean isLessMinimum) {
    this.isLessMinimum = isLessMinimum;
  }

  @JsonProperty("expiredOffers")
  public Object getExpiredOffers() {
    return expiredOffers;
  }

  @JsonProperty("expiredOffers")
  public void setExpiredOffers(Object expiredOffers) {
    this.expiredOffers = expiredOffers;
  }

  @JsonProperty("expiredProducts")
  public Object getExpiredProducts() {
    return expiredProducts;
  }

  @JsonProperty("expiredProducts")
  public void setExpiredProducts(Object expiredProducts) {
    this.expiredProducts = expiredProducts;
  }

  @JsonProperty("restrictedProducts")
  public Object getRestrictedProducts() {
    return restrictedProducts;
  }

  @JsonProperty("restrictedProducts")
  public void setRestrictedProducts(Object restrictedProducts) {
    this.restrictedProducts = restrictedProducts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PostDeliverySlots)) return false;
    PostDeliverySlots that = (PostDeliverySlots) o;
    return Objects.equal(getAck(), that.getAck())
        && Objects.equal(getIsLessMinimum(), that.getIsLessMinimum())
        && Objects.equal(getExpiredOffers(), that.getExpiredOffers())
        && Objects.equal(getExpiredProducts(), that.getExpiredProducts())
        && Objects.equal(getRestrictedProducts(), that.getRestrictedProducts());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        getAck(),
        getIsLessMinimum(),
        getExpiredOffers(),
        getExpiredProducts(),
        getRestrictedProducts());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("isLessMinimum", isLessMinimum)
        .add("expiredOffers", expiredOffers)
        .add("expiredProducts", expiredProducts)
        .add("restrictedProducts", restrictedProducts)
        .toString();
  }
}
