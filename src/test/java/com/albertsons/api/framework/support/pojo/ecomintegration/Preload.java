package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * Pojo class to represent preload object.
 *
 * <p>Created by vbonk00.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "ack",
  "registered",
  "cart",
  "aisles",
  "historyCompleteList",
  "historyLastOrder",
  "isScanTermsAccepted",
  "currentOrder",
  "accountInfo",
  "omnitureParams",
  "brand"
})
public class Preload {

  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("registered")
  private Boolean registered;

  @JsonProperty("cart")
  private Cart cart;

  @JsonProperty("aisles")
  private List<Aisle> aisles = null;

  @JsonProperty("historyCompleteList")
  private List<CartItem> historyCompleteList = null;

  @JsonProperty("historyLastOrder")
  private List<CartItem> historyLastOrder = null;

  @JsonProperty("isScanTermsAccepted")
  private Boolean isScanTermsAccepted;

  @JsonProperty("currentOrder")
  private Object currentOrder;

  @JsonProperty("accountInfo")
  private AccountInfo accountInfo;

  @JsonProperty("omnitureParams")
  private OmnitureParams omnitureParams;

  @JsonProperty("brand")
  private Object brand;

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

  @JsonProperty("cart")
  public Cart getCart() {
    return cart;
  }

  @JsonProperty("cart")
  public void setCart(Cart cart) {
    this.cart = cart;
  }

  @JsonProperty("aisles")
  public List<Aisle> getAisles() {
    return aisles;
  }

  @JsonProperty("aisles")
  public void setAisles(List<Aisle> aisles) {
    this.aisles = aisles;
  }

  @JsonProperty("historyCompleteList")
  public List<CartItem> getHistoryCompleteList() {
    return historyCompleteList;
  }

  @JsonProperty("historyCompleteList")
  public void setHistoryCompleteList(List<CartItem> historyCompleteList) {
    this.historyCompleteList = historyCompleteList;
  }

  @JsonProperty("historyLastOrder")
  public List<CartItem> getHistoryLastOrder() {
    return historyLastOrder;
  }

  @JsonProperty("historyLastOrder")
  public void setHistoryLastOrder(List<CartItem> historyLastOrder) {
    this.historyLastOrder = historyLastOrder;
  }

  @JsonProperty("isScanTermsAccepted")
  public Boolean getIsScanTermsAccepted() {
    return isScanTermsAccepted;
  }

  @JsonProperty("isScanTermsAccepted")
  public void setIsScanTermsAccepted(Boolean isScanTermsAccepted) {
    this.isScanTermsAccepted = isScanTermsAccepted;
  }

  @JsonProperty("currentOrder")
  public Object getCurrentOrder() {
    return currentOrder;
  }

  @JsonProperty("currentOrder")
  public void setCurrentOrder(Object currentOrder) {
    this.currentOrder = currentOrder;
  }

  @JsonProperty("accountInfo")
  public AccountInfo getAccountInfo() {
    return accountInfo;
  }

  @JsonProperty("accountInfo")
  public void setAccountInfo(AccountInfo accountInfo) {
    this.accountInfo = accountInfo;
  }

  @JsonProperty("omnitureParams")
  public OmnitureParams getOmnitureParams() {
    return omnitureParams;
  }

  @JsonProperty("omnitureParams")
  public void setOmnitureParams(OmnitureParams omnitureParams) {
    this.omnitureParams = omnitureParams;
  }

  @JsonProperty("brand")
  public Object getBrand() {
    return brand;
  }

  @JsonProperty("brand")
  public void setBrand(Object brand) {
    this.brand = brand;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Preload preload = (Preload) o;
    return Objects.equal(ack, preload.ack)
        && Objects.equal(registered, preload.registered)
        && Objects.equal(cart, preload.cart)
        && Objects.equal(aisles, preload.aisles)
        && Objects.equal(historyCompleteList, preload.historyCompleteList)
        && Objects.equal(historyLastOrder, preload.historyLastOrder)
        && Objects.equal(isScanTermsAccepted, preload.isScanTermsAccepted)
        && Objects.equal(currentOrder, preload.currentOrder)
        && Objects.equal(accountInfo, preload.accountInfo)
        && Objects.equal(omnitureParams, preload.omnitureParams)
        && Objects.equal(brand, preload.brand);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        ack,
        registered,
        cart,
        aisles,
        historyCompleteList,
        historyLastOrder,
        isScanTermsAccepted,
        currentOrder,
        accountInfo,
        omnitureParams,
        brand);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("registered", registered)
        .add("cart", cart)
        .add("aisles", aisles)
        .add("historyCompleteList", historyCompleteList)
        .add("historyLastOrder", historyLastOrder)
        .add("isScanTermsAccepted", isScanTermsAccepted)
        .add("currentOrder", currentOrder)
        .add("accountInfo", accountInfo)
        .add("omnitureParams", omnitureParams)
        .add("brand", brand)
        .toString();
  }
}
