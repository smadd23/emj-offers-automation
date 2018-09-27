package com.albertsons.api.framework.support.pojo.ecomintegration;

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
 * Pojo class to represent Orders List object.
 *
 * <p>Created by vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ack", "currentOrder", "Delivery", "orderDueForDelivery", "orderHistory"})
public class GetOrdersList {
  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("currentOrder")
  private Order currentOrder;

  @JsonProperty("Delivery")
  private Object delivery;

  @JsonProperty("orderDueForDelivery")
  private List<Order> orderDueForDelivery = null;

  @JsonProperty("orderHistory")
  private List<Order> orderHistory = null;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("ack")
  public Boolean getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  public Order getCurrentOrder() {
    return currentOrder;
  }

  public void setCurrentOrder(Order currentOrder) {
    this.currentOrder = currentOrder;
  }

  public Object getDelivery() {
    return delivery;
  }

  public void setDelivery(Object delivery) {
    this.delivery = delivery;
  }

  public List<Order> getOrderDueForDelivery() {
    return orderDueForDelivery;
  }

  public void setOrderDueForDelivery(List<Order> orderDueForDelivery) {
    this.orderDueForDelivery = orderDueForDelivery;
  }

  public List<Order> getOrderHistory() {
    return orderHistory;
  }

  public void setOrderHistory(List<Order> orderHistory) {
    this.orderHistory = orderHistory;
  }

  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(Map<String, Object> additionalProperties) {
    this.additionalProperties = additionalProperties;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof GetOrdersList)) return false;
    GetOrdersList that = (GetOrdersList) o;
    return Objects.equal(ack, that.ack)
        && java.util.Objects.equals(currentOrder, that.currentOrder)
        && java.util.Objects.equals(delivery, that.delivery)
        && java.util.Objects.equals(orderDueForDelivery, that.orderDueForDelivery)
        && java.util.Objects.equals(orderHistory, that.orderHistory);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(ack, currentOrder, delivery, orderDueForDelivery, orderHistory);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("curentOrder", currentOrder)
        .add("delivery", delivery)
        .add("orderDueForDelivery", orderDueForDelivery)
        .add("orderHistory", orderHistory)
        .toString();
  }
}
