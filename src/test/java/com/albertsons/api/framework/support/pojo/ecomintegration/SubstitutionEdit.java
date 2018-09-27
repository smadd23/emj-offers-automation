package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * This class contains the pojo representation of substitution edit response.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ack", "deliveryInfoUrl", "paymentInfoUrl", "cookies"})
public class SubstitutionEdit {

  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("deliveryInfoUrl")
  private String deliveryInfoUrl;

  @JsonProperty("paymentInfoUrl")
  private String paymentInfoUrl;

  @JsonProperty("cookies")
  private List<Object> cookies = null;

  @JsonProperty("ack")
  public Boolean getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  @JsonProperty("deliveryInfoUrl")
  public String getDeliveryInfoUrl() {
    return deliveryInfoUrl;
  }

  @JsonProperty("deliveryInfoUrl")
  public void setDeliveryInfoUrl(String deliveryInfoUrl) {
    this.deliveryInfoUrl = deliveryInfoUrl;
  }

  @JsonProperty("paymentInfoUrl")
  public String getPaymentInfoUrl() {
    return paymentInfoUrl;
  }

  @JsonProperty("paymentInfoUrl")
  public void setPaymentInfoUrl(String paymentInfoUrl) {
    this.paymentInfoUrl = paymentInfoUrl;
  }

  @JsonProperty("cookies")
  public List<Object> getCookies() {
    return cookies;
  }

  @JsonProperty("cookies")
  public void setCookies(List<Object> cookies) {
    this.cookies = cookies;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SubstitutionEdit)) return false;
    SubstitutionEdit that = (SubstitutionEdit) o;
    return Objects.equal(getAck(), that.getAck())
        && Objects.equal(getDeliveryInfoUrl(), that.getDeliveryInfoUrl())
        && Objects.equal(getPaymentInfoUrl(), that.getPaymentInfoUrl())
        && Objects.equal(getCookies(), that.getCookies());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getAck(), getDeliveryInfoUrl(), getPaymentInfoUrl(), getCookies());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("deliveryInfoUrl", deliveryInfoUrl)
        .add("paymentInfoUrl", paymentInfoUrl)
        .add("cookies", cookies)
        .toString();
  }
}
