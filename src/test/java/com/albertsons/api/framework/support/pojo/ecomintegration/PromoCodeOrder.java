package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * This class contains the pojo representation of full details of promo code.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "ack",
  "isLimitExceeded",
  "firstTimeShopper",
  "message",
  "requiredProducts",
  "promoCodes"
})
public class PromoCodeOrder {
  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("isLimitExceeded")
  private Boolean isLimitExceeded;

  @JsonProperty("firstTimeShopper")
  private Boolean firstTimeShopper;

  @JsonProperty("message")
  private Object message;

  @JsonProperty("requiredProducts")
  private Object requiredProducts;

  @JsonProperty("promoCodes")
  private List<PromoCode> promoCodes = null;

  @JsonProperty("ack")
  public Boolean getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  @JsonProperty("isLimitExceeded")
  public Boolean getIsLimitExceeded() {
    return isLimitExceeded;
  }

  @JsonProperty("isLimitExceeded")
  public void setIsLimitExceeded(Boolean isLimitExceeded) {
    this.isLimitExceeded = isLimitExceeded;
  }

  @JsonProperty("firstTimeShopper")
  public Boolean getFirstTimeShopper() {
    return firstTimeShopper;
  }

  @JsonProperty("firstTimeShopper")
  public void setFirstTimeShopper(Boolean firstTimeShopper) {
    this.firstTimeShopper = firstTimeShopper;
  }

  @JsonProperty("message")
  public Object getMessage() {
    return message;
  }

  @JsonProperty("message")
  public void setMessage(Object message) {
    this.message = message;
  }

  @JsonProperty("requiredProducts")
  public Object getRequiredProducts() {
    return requiredProducts;
  }

  @JsonProperty("requiredProducts")
  public void setRequiredProducts(Object requiredProducts) {
    this.requiredProducts = requiredProducts;
  }

  @JsonProperty("promoCodes")
  public List<PromoCode> getPromoCodes() {
    return promoCodes;
  }

  @JsonProperty("promoCodes")
  public void setPromoCodes(List<PromoCode> promoCodes) {
    this.promoCodes = promoCodes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PromoCodeOrder)) return false;
    PromoCodeOrder that = (PromoCodeOrder) o;
    return Objects.equal(getAck(), that.getAck())
        && Objects.equal(getIsLimitExceeded(), that.getIsLimitExceeded())
        && Objects.equal(getFirstTimeShopper(), that.getFirstTimeShopper())
        && Objects.equal(getMessage(), that.getMessage())
        && Objects.equal(getRequiredProducts(), that.getRequiredProducts())
        && Objects.equal(getPromoCodes(), that.getPromoCodes());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        getAck(),
        getIsLimitExceeded(),
        getFirstTimeShopper(),
        getMessage(),
        getRequiredProducts(),
        getPromoCodes());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("isLimitExceeded", isLimitExceeded)
        .add("firstTimeShopper", firstTimeShopper)
        .add("message", message)
        .add("requiredProducts", requiredProducts)
        .add("promoCodes", promoCodes)
        .toString();
  }
}
