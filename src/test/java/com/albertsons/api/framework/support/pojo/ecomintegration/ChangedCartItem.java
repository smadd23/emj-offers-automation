package com.albertsons.api.framework.support.pojo.ecomintegration;

/**
 * Pojo class to represent changed cart item when a cart is modified.
 *
 * <p>Created by vkuma26
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "price", "quantity"})
public class ChangedCartItem {

  @JsonProperty("name")
  private String name;

  @JsonProperty("price")
  private Float price;

  @JsonProperty("quantity")
  private Integer quantity;

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("price")
  public Float getPrice() {
    return price;
  }

  @JsonProperty("price")
  public void setPrice(Float price) {
    this.price = price;
  }

  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  @JsonProperty("quantity")
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ChangedCartItem)) return false;
    ChangedCartItem that = (ChangedCartItem) o;
    return java.util.Objects.equals(getName(), that.getName())
        && java.util.Objects.equals(getPrice(), that.getPrice())
        && java.util.Objects.equals(getQuantity(), that.getQuantity());
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(getName(), getPrice(), getQuantity());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .add("price", price)
        .add("quantity", quantity)
        .toString();
  }
}
