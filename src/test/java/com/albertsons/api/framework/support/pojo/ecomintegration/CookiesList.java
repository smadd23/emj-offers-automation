package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * This class contains the pojo representation of cookies list.
 *
 * @author vbonk00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ack", "cookies", "registered", "deliverypreferences"})
public class CookiesList {

  @JsonProperty("ack")
  private Boolean ack = false;

  @JsonProperty("cookies")
  private List<Cookie> cookies = null;

  @JsonProperty("registered")
  private Boolean registered = false;

  @JsonProperty("deliverypreferences")
  private DeliveryPreferences deliveryPreferences;

  @JsonProperty("ack")
  public Boolean getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  @JsonProperty("cookies")
  public List<Cookie> getCookies() {
    return cookies;
  }

  @JsonProperty("cookies")
  public void setCookies(List<Cookie> cookies) {
    this.cookies = cookies;
  }

  @JsonProperty("registered")
  public Boolean getRegistered() {
    return registered;
  }

  @JsonProperty("registered")
  public void setRegistered(Boolean registered) {
    this.registered = registered;
  }

  @JsonProperty("deliverypreferences")
  public DeliveryPreferences getDeliveryPreferences() {
    return deliveryPreferences;
  }

  @JsonProperty("deliverypreferences")
  public void setDeliveryPreferences(DeliveryPreferences deliverypreferences) {
    this.deliveryPreferences = deliverypreferences;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CookiesList that = (CookiesList) o;
    return Objects.equal(ack, that.ack)
        && Objects.equal(cookies, that.cookies)
        && Objects.equal(registered, that.registered)
        && Objects.equal(deliveryPreferences, that.deliveryPreferences);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(ack, cookies, registered, deliveryPreferences);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("cookies", cookies)
        .add("registered", registered)
        .add("deliverypreferences", deliveryPreferences)
        .toString();
  }
}
