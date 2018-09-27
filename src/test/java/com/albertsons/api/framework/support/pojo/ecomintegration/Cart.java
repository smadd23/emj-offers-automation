package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * Pojo class to represent cart.
 *
 * <p>Created by vbonk00.
 */
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
public class Cart {

  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("cartItems")
  private List<CartItem> cartItems = null;

  @JsonProperty("cartSummary")
  private CartSummary cartSummary;

  @JsonProperty("changedItems")
  private Object changedItems;

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
  public Object getChangedItems() {
    return changedItems;
  }

  @JsonProperty("changedItems")
  public void setChangedItems(Object changedItems) {
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
    if (o == null || getClass() != o.getClass()) return false;
    Cart cart = (Cart) o;
    return Objects.equal(ack, cart.ack)
        && Objects.equal(cartItems, cart.cartItems)
        && Objects.equal(cartSummary, cart.cartSummary)
        && Objects.equal(changedItems, cart.changedItems)
        && Objects.equal(selectedDelivery, cart.selectedDelivery)
        && Objects.equal(hasRestrictedItems, cart.hasRestrictedItems)
        && Objects.equal(minimumBasketSize, cart.minimumBasketSize)
        && Objects.equal(totalProducts, cart.totalProducts)
        && Objects.equal(currentPage, cart.currentPage)
        && Objects.equal(totalPages, cart.totalPages);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        ack,
        cartItems,
        cartSummary,
        changedItems,
        selectedDelivery,
        hasRestrictedItems,
        minimumBasketSize,
        totalProducts,
        currentPage,
        totalPages);
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
        .toString();
  }
}
