package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of substitution information for a product.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "totalPrice",
  "quantity",
  "productName",
  "productId",
  "isSpecial",
  "substitutionValue"
})
public class Substitution {

  @JsonProperty("totalPrice")
  private Float totalPrice;

  @JsonProperty("quantity")
  private Integer quantity;

  @JsonProperty("productName")
  private String productName;

  @JsonProperty("productId")
  private String productId;

  @JsonProperty("isSpecial")
  private Boolean isSpecial;

  @JsonProperty("substitutionValue")
  private String substitutionValue;

  @JsonProperty("totalPrice")
  public Float getTotalPrice() {
    return totalPrice;
  }

  @JsonProperty("totalPrice")
  public void setTotalPrice(Float totalPrice) {
    this.totalPrice = totalPrice;
  }

  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  @JsonProperty("quantity")
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @JsonProperty("productName")
  public String getProductName() {
    return productName;
  }

  @JsonProperty("productName")
  public void setProductName(String productName) {
    this.productName = productName;
  }

  @JsonProperty("productId")
  public String getProductId() {
    return productId;
  }

  @JsonProperty("productId")
  public void setProductId(String productId) {
    this.productId = productId;
  }

  @JsonProperty("isSpecial")
  public Boolean getIsSpecial() {
    return isSpecial;
  }

  @JsonProperty("isSpecial")
  public void setIsSpecial(Boolean isSpecial) {
    this.isSpecial = isSpecial;
  }

  @JsonProperty("substitutionValue")
  public String getSubstitutionValue() {
    return substitutionValue;
  }

  @JsonProperty("substitutionValue")
  public void setSubstitutionValue(String substitutionValue) {
    this.substitutionValue = substitutionValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Substitution)) return false;
    Substitution that = (Substitution) o;
    return Objects.equal(getTotalPrice(), that.getTotalPrice())
        && Objects.equal(getQuantity(), that.getQuantity())
        && Objects.equal(getProductName(), that.getProductName())
        && Objects.equal(getProductId(), that.getProductId())
        && Objects.equal(getIsSpecial(), that.getIsSpecial())
        && Objects.equal(getSubstitutionValue(), that.getSubstitutionValue());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        getTotalPrice(),
        getQuantity(),
        getProductName(),
        getProductId(),
        getIsSpecial(),
        getSubstitutionValue());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("totalPrice", totalPrice)
        .add("quantity", quantity)
        .add("productName", productName)
        .add("productId", productId)
        .add("isSpecial", isSpecial)
        .add("substitutionValue", substitutionValue)
        .toString();
  }
}
