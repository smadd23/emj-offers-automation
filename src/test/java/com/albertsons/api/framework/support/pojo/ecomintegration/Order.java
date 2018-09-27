package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;


/**
 * This class contains the pojo representation of Order.
 *
 * @author vkuma26
 */
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({
    "number",
    "branchNumber",
    "address",
    "price",
    "priceWithAllFees",
    "isDelivered",
    "isTooLate",
    "checkoutUrl",
    "message",
    "startDate",
    "endDate",
    "Delivery",
    "hasRestrictedItems"
})
public class Order {

  @JsonProperty("number")
  private Integer number;

  @JsonProperty("branchNumber")
  private Integer branchNumber;

  @JsonProperty("address")
  private String address;

  @JsonProperty("price")
  private Float price;

  @JsonProperty("priceWithAllFees")
  private Float priceWithAllFees;

  @JsonProperty("isDelivered")
  private Boolean isDelivered;

  @JsonProperty("isTooLate")
  private Boolean isTooLate;

  @JsonProperty("checkoutUrl")
  private String checkoutUrl;

  @JsonProperty("message")
  private Object message;

  @JsonProperty("startDate")
  private String startDate;

  @JsonProperty("endDate")
  private String endDate;

  @JsonProperty("Delivery")
  private String delivery;

  @JsonProperty("hasRestrictedItems")
  private Boolean hasRestrictedItems;

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public Integer getBranchNumber() {
    return branchNumber;
  }

  public void setBranchNumber(Integer branchNumber) {
    this.branchNumber = branchNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Float getPriceWithAllFees() {
    return priceWithAllFees;
  }

  public void setPriceWithAllFees(Float priceWithAllFees) {
    this.priceWithAllFees = priceWithAllFees;
  }

  public Boolean getDelivered() {
    return isDelivered;
  }

  public void setDelivered(Boolean delivered) {
    isDelivered = delivered;
  }

  public Boolean getTooLate() {
    return isTooLate;
  }

  public void setTooLate(Boolean tooLate) {
    isTooLate = tooLate;
  }

  public String getCheckoutUrl() {
    return checkoutUrl;
  }

  public void setCheckoutUrl(String checkoutUrl) {
    this.checkoutUrl = checkoutUrl;
  }

  public Object getMessage() {
    return message;
  }

  public void setMessage(Object message) {
    this.message = message;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getDelivery() {
    return delivery;
  }

  public void setDelivery(String delivery) {
    this.delivery = delivery;
  }

  public Boolean getHasRestrictedItems() {
    return hasRestrictedItems;
  }

  public void setHasRestrictedItems(Boolean hasRestrictedItems) {
    this.hasRestrictedItems = hasRestrictedItems;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Order)) return false;
    Order order = (Order) o;
    return Objects.equal(getNumber(), order.getNumber())
        && Objects.equal(getBranchNumber(), order.getBranchNumber())
        && Objects.equal(getAddress(), order.getAddress())
        && Objects.equal(getPrice(), order.getPrice())
        && Objects.equal(getPriceWithAllFees(), order.getPriceWithAllFees())
        && Objects.equal(isDelivered, order.isDelivered)
        && Objects.equal(isTooLate, order.isTooLate)
        && Objects.equal(getCheckoutUrl(), order.getCheckoutUrl())
        && Objects.equal(getMessage(), order.getMessage())
        && Objects.equal(getStartDate(), order.getStartDate())
        && Objects.equal(getEndDate(), order.getEndDate())
        && Objects.equal(getDelivery(), order.getDelivery())
        && Objects.equal(getHasRestrictedItems(), order.getHasRestrictedItems());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        getNumber(),
        getBranchNumber(),
        getAddress(),
        getPrice(),
        getPriceWithAllFees(),
        isDelivered,
        isTooLate,
        getCheckoutUrl(),
        getMessage(),
        getStartDate(),
        getEndDate(),
        getDelivery(),
        getHasRestrictedItems());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("number", number)
        .add("branchNumber", branchNumber)
        .add("address", address)
        .add("price", price)
        .add("priceWithAllFees", priceWithAllFees)
        .add("isDelivered", isDelivered)
        .add("isTooLate", isTooLate)
        .add("checkoutUrl", checkoutUrl)
        .add("message", message)
        .add("startDate", startDate)
        .add("endDate", endDate)
        .add("delivery", delivery)
        .add("hasRestrictedItems", hasRestrictedItems)
        .toString();
  }
}
