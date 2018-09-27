package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Pojo class to represent product info.
 *
 * <p>Created by vbonk00.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "upc",
    "price",
    "basePrice",
    "comment",
    "substitutionValue",
    "quantity",
    "pricePer",
    "promoDescription",
    "promoEndDate",
    "restrictedValue",
    "unitOfMeasure",
    "promoType",
    "description",
    "salesRank",
    "promoText"
})
public class ProductsInfo {

  @JsonProperty("id")
  private String id;

  @JsonProperty("upc")
  private String upc;

  @JsonProperty("price")
  private Float price;

  @JsonProperty("basePrice")
  private Float basePrice;

  @JsonProperty("comment")
  private String comment;

  @JsonProperty("substitutionValue")
  private String substitutionValue;

  @JsonProperty("quantity")
  private Float quantity;

  @JsonProperty("pricePer")
  private Float pricePer;

  @JsonProperty("promoDescription")
  private String promoDescription;

  @JsonProperty("promoEndDate")
  private String promoEndDate;

  @JsonProperty("restrictedValue")
  private Integer restrictedValue;

  @JsonProperty("unitOfMeasure")
  private String unitOfMeasure;

  @JsonProperty("promoType")
  private String promoType;

  @JsonProperty("description")
  private String description;

  @JsonProperty("salesRank")
  private Integer salesRank;

  @JsonProperty("promoText")
  private String promoText;

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("upc")
  public String getUpc() {
    return upc;
  }

  @JsonProperty("upc")
  public void setUpc(String upc) {
    this.upc = upc;
  }

  @JsonProperty("price")
  public Float getPrice() {
    return price;
  }

  @JsonProperty("price")
  public void setPrice(Float price) {
    this.price = price;
  }

  @JsonProperty("basePrice")
  public Float getBasePrice() {
    return basePrice;
  }

  @JsonProperty("basePrice")
  public void setBasePrice(Float basePrice) {
    this.basePrice = basePrice;
  }

  @JsonProperty("comment")
  public String getComment() {
    return comment;
  }

  @JsonProperty("comment")
  public void setComment(String comment) {
    this.comment = comment;
  }

  @JsonProperty("substitutionValue")
  public String getSubstitutionValue() {
    return substitutionValue;
  }

  @JsonProperty("substitutionValue")
  public void setSubstitutionValue(String substitutionValue) {
    this.substitutionValue = substitutionValue;
  }

  @JsonProperty("quantity")
  public Float getQuantity() {
    return quantity;
  }

  @JsonProperty("quantity")
  public void setQuantity(Float quantity) {
    this.quantity = quantity;
  }

  @JsonProperty("pricePer")
  public Float getPricePer() {
    return pricePer;
  }

  @JsonProperty("pricePer")
  public void setPricePer(Float pricePer) {
    this.pricePer = pricePer;
  }

  @JsonProperty("promoDescription")
  public String getPromoDescription() {
    return promoDescription;
  }

  @JsonProperty("promoDescription")
  public void setPromoDescription(String promoDescription) {
    this.promoDescription = promoDescription;
  }

  @JsonProperty("promoEndDate")
  public String getPromoEndDate() {
    return promoEndDate;
  }

  @JsonProperty("promoEndDate")
  public void setPromoEndDate(String promoEndDate) {
    this.promoEndDate = promoEndDate;
  }

  @JsonProperty("restrictedValue")
  public Integer getRestrictedValue() {
    return restrictedValue;
  }

  @JsonProperty("restrictedValue")
  public void setRestrictedValue(Integer restrictedValue) {
    this.restrictedValue = restrictedValue;
  }

  @JsonProperty("unitOfMeasure")
  public String getUnitOfMeasure() {
    return unitOfMeasure;
  }

  @JsonProperty("unitOfMeasure")
  public void setUnitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  @JsonProperty("promoType")
  public String getPromoType() {
    return promoType;
  }

  @JsonProperty("promoType")
  public void setPromoType(String promoType) {
    this.promoType = promoType;
  }

  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  @JsonProperty("description")
  public void setDescription(String description) {
    this.description = description;
  }

  @JsonProperty("salesRank")
  public Integer getSalesRank() {
    return salesRank;
  }

  @JsonProperty("salesRank")
  public void setSalesRank(Integer salesRank) {
    this.salesRank = salesRank;
  }

  public String getPromoText() {
    return promoText;
  }

  public void setPromoText(String promoText) {
    this.promoText = promoText;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ProductsInfo)) return false;
    ProductsInfo that = (ProductsInfo) o;
    return Objects.equal(getId(), that.getId())
        && Objects.equal(getUpc(), that.getUpc())
        && Objects.equal(getPrice(), that.getPrice())
        && Objects.equal(getBasePrice(), that.getBasePrice())
        && Objects.equal(getComment(), that.getComment())
        && Objects.equal(getSubstitutionValue(), that.getSubstitutionValue())
        && Objects.equal(getQuantity(), that.getQuantity())
        && Objects.equal(getPricePer(), that.getPricePer())
        && Objects.equal(getPromoDescription(), that.getPromoDescription())
        && Objects.equal(getPromoEndDate(), that.getPromoEndDate())
        && Objects.equal(getRestrictedValue(), that.getRestrictedValue())
        && Objects.equal(getUnitOfMeasure(), that.getUnitOfMeasure())
        && Objects.equal(getPromoType(), that.getPromoType())
        && Objects.equal(getDescription(), that.getDescription())
        && Objects.equal(getSalesRank(), that.getSalesRank())
        && Objects.equal(getPromoText(), that.getPromoText());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        getId(),
        getUpc(),
        getPrice(),
        getBasePrice(),
        getComment(),
        getSubstitutionValue(),
        getQuantity(),
        getPricePer(),
        getPromoDescription(),
        getPromoEndDate(),
        getRestrictedValue(),
        getUnitOfMeasure(),
        getPromoType(),
        getDescription(),
        getSalesRank(),
        getPromoText());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("upc", upc)
        .add("price", price)
        .add("basePrice", basePrice)
        .add("comment", comment)
        .add("substitutionValue", substitutionValue)
        .add("quantity", quantity)
        .add("pricePer", pricePer)
        .add("promoDescription", promoDescription)
        .add("promoEndDate", promoEndDate)
        .add("restrictedValue", restrictedValue)
        .add("unitOfMeasure", unitOfMeasure)
        .add("promoType", promoType)
        .add("description", description)
        .add("salesRank", salesRank)
        .add("promoText", promoText)
        .toString();
  }
}
