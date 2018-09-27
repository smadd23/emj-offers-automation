package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * This class contains the pojo representation of sign in.
 *
 * @author vbonk00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "ack",
  "registered",
  "brand",
  "storeId",
  "DeliveryOptions",
  "dugStores",
  "orderCount"
})
public class SignIn {

  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("registered")
  private Boolean registered;

  @JsonProperty("brand")
  private String brand;

  @JsonProperty("storeId")
  private Integer storeId;

  @JsonProperty("DeliveryOptions")
  private DeliveryPreferences deliveryOptions;

  @JsonProperty("dugStores")
  private List<DugStore> dugStores = null;

  @JsonProperty("orderCount")
  private Integer orderCount;

  @JsonProperty("ack")
  public Boolean getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  @JsonProperty("registered")
  public Boolean getRegistered() {
    return registered;
  }

  @JsonProperty("registered")
  public void setRegistered(Boolean registered) {
    this.registered = registered;
  }

  @JsonProperty("brand")
  public String getBrand() {
    return brand;
  }

  @JsonProperty("brand")
  public void setBrand(String brand) {
    this.brand = brand;
  }

  @JsonProperty("storeId")
  public Integer getStoreId() {
    return storeId;
  }

  @JsonProperty("storeId")
  public void setStoreId(Integer storeId) {
    this.storeId = storeId;
  }

  @JsonProperty("DeliveryOptions")
  public DeliveryPreferences getDeliveryOptions() {
    return deliveryOptions;
  }

  @JsonProperty("DeliveryOptions")
  public void setDeliveryOptions(DeliveryPreferences deliveryOptions) {
    this.deliveryOptions = deliveryOptions;
  }

  @JsonProperty("dugStores")
  public List<DugStore> getDugStores() {
    return dugStores;
  }

  @JsonProperty("dugStores")
  public void setDugStores(List<DugStore> dugStores) {
    this.dugStores = dugStores;
  }

  @JsonProperty("orderCount")
  public Integer getOrderCount() {
    return orderCount;
  }

  @JsonProperty("orderCount")
  public void setOrderCount(Integer orderCount) {
    this.orderCount = orderCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SignIn signIn = (SignIn) o;
    return Objects.equal(ack, signIn.ack)
        && Objects.equal(registered, signIn.registered)
        && Objects.equal(brand, signIn.brand)
        && Objects.equal(storeId, signIn.storeId)
        && Objects.equal(deliveryOptions, signIn.deliveryOptions)
        && Objects.equal(dugStores, signIn.dugStores)
        && Objects.equal(orderCount, signIn.orderCount);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        ack, registered, brand, storeId, deliveryOptions, dugStores, orderCount);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("registered", registered)
        .add("brand", brand)
        .add("storeId", storeId)
        .add("deliveryOptions", deliveryOptions)
        .add("dugStores", dugStores)
        .add("orderCount", orderCount)
        .toString();
  }
}
