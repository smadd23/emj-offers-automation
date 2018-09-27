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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "ack",
  "cartItems",
  "cartSummary",
  "changedItems",
  "selectedDelivery",
  "hasRestrictedItems",
  "minimumBasketSize",
  "totalProducts",
  "currentPage",
  "totalPages"
})
public class GetCart {

  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("cartItems")
  private List<CartItem> cartItems = null;

  @JsonProperty("cartSummary")
  private CartSummary cartSummary;

  @JsonProperty("changedItems")
  private List<ChangedCartItem> changedItems;

  @JsonProperty("selectedDelivery")
  private Integer selectedDelivery;

  @JsonProperty("hasRestrictedItems")
  private Boolean hasRestrictedItems;

  @JsonProperty("minimumBasketSize")
  private Integer minimumBasketSize;

  @JsonProperty("totalProducts")
  private Integer totalProducts;

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

  @JsonProperty("cartItems")
  public List<CartItem> getCartItems() {
    return cartItems;
  }

  @JsonProperty("cartItems")
  public void setCartItems(List<CartItem> cartItems) {
    this.cartItems = cartItems;
  }

  @JsonProperty("cartSummary")
  public CartSummary getCartSummary() {
    return cartSummary;
  }

  @JsonProperty("cartSummary")
  public void setCartSummary(CartSummary cartSummary) {
    this.cartSummary = cartSummary;
  }

  @JsonProperty("changedItems")
  public List<ChangedCartItem> getChangedItems() {
    return changedItems;
  }

  @JsonProperty("changedItems")
  public void setChangedItems(List<ChangedCartItem> changedItems) {
    this.changedItems = changedItems;
  }

  @JsonProperty("selectedDelivery")
  public Integer getSelectedDelivery() {
    return selectedDelivery;
  }

  @JsonProperty("selectedDelivery")
  public void setSelectedDelivery(Integer selectedDelivery) {
    this.selectedDelivery = selectedDelivery;
  }

  @JsonProperty("hasRestrictedItems")
  public Boolean getHasRestrictedItems() {
    return hasRestrictedItems;
  }

  @JsonProperty("hasRestrictedItems")
  public void setHasRestrictedItems(Boolean hasRestrictedItems) {
    this.hasRestrictedItems = hasRestrictedItems;
  }

  @JsonProperty("minimumBasketSize")
  public Integer getMinimumBasketSize() {
    return minimumBasketSize;
  }

  @JsonProperty("minimumBasketSize")
  public void setMinimumBasketSize(Integer minimumBasketSize) {
    this.minimumBasketSize = minimumBasketSize;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  @JsonProperty("totalProducts")
  public Integer getTotalProducts() {
    return totalProducts;
  }

  @JsonProperty("totalProducts")
  public void setTotalProducts(Integer totalProducts) {
    this.totalProducts = totalProducts;
  }

  @JsonProperty("currentPage")
  public Integer getCurrentPage() {
    return currentPage;
  }

  @JsonProperty("currentPage")
  public void setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
  }

  @JsonProperty("totalPages")
  public Integer getTotalPages() {
    return totalPages;
  }

  @JsonProperty("totalPages")
  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof GetCart)) return false;
    GetCart getCart = (GetCart) o;
    return Objects.equal(getAck(), getCart.getAck())
        && Objects.equal(getCartItems(), getCart.getCartItems())
        && Objects.equal(getCartSummary(), getCart.getCartSummary())
        && Objects.equal(getChangedItems(), getCart.getChangedItems())
        && Objects.equal(getSelectedDelivery(), getCart.getSelectedDelivery())
        && Objects.equal(getHasRestrictedItems(), getCart.getHasRestrictedItems())
        && Objects.equal(getMinimumBasketSize(), getCart.getMinimumBasketSize())
        && Objects.equal(getTotalProducts(), getCart.getTotalProducts())
        && Objects.equal(getCurrentPage(), getCart.getCurrentPage())
        && Objects.equal(getTotalPages(), getCart.getTotalPages())
        && Objects.equal(getAdditionalProperties(), getCart.getAdditionalProperties());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        getAck(),
        getCartItems(),
        getCartSummary(),
        getChangedItems(),
        getSelectedDelivery(),
        getHasRestrictedItems(),
        getMinimumBasketSize(),
        getTotalProducts(),
        getCurrentPage(),
        getTotalPages(),
        getAdditionalProperties());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("cartItems", cartItems)
        .add("cartSummary", cartSummary)
        .add("changedItems", changedItems)
        .add("selectedDelivery", selectedDelivery)
        .add("hasRestrictedItems", hasRestrictedItems)
        .add("minimumBasketSize", minimumBasketSize)
        .add("totalProducts", totalProducts)
        .add("currentPage", currentPage)
        .add("totalPages", totalPages)
        .add("additionalProperties", additionalProperties)
        .toString();
  }
}
