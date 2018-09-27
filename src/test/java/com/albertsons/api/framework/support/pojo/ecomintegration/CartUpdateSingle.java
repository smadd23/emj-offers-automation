package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Pojo class to represent single product to update cart.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"productId", "quantity"})
public class CartUpdateSingle {
  @JsonProperty("productId")
  private String productId;

  @JsonProperty("quantity")
  private Integer quantity;

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CartUpdateSingle)) return false;
    CartUpdateSingle that = (CartUpdateSingle) o;
    return Objects.equal(getProductId(), that.getProductId())
        && Objects.equal(getQuantity(), that.getQuantity());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getProductId(), getQuantity());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("productId", productId)
        .add("quantity", quantity)
        .toString();
  }
}
