package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Pojo class to represent BPN product info.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "upc",
    "name",
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
    "image",
    "promoText",
    "triggerQuantity",
    "aisleId",
    "Prop65WarningTypeCD",
    "Prop65WarningText",
    "Prop65WarningIconRequired",
    "description"
})
public class BpnProductInfo {
  @JsonProperty("id")
  private String id;

  @JsonProperty("upc")
  private String upc;

  @JsonProperty("name")
  private String name;

  @JsonProperty("price")
  private Float price;

  @JsonProperty("basePrice")
  private Integer basePrice;

  @JsonProperty("comment")
  private String comment;

  @JsonProperty("substitutionValue")
  private String substitutionValue;

  @JsonProperty("quantity")
  private Integer quantity;

  @JsonProperty("pricePer")
  private Float pricePer;

  @JsonProperty("promoDescription")
  private String promoDescription;

  @JsonProperty("promoEndDate")
  private Object promoEndDate;

  @JsonProperty("restrictedValue")
  private Integer restrictedValue;

  @JsonProperty("unitOfMeasure")
  private String unitOfMeasure;

  @JsonProperty("promoType")
  private String promoType;

  @JsonProperty("image")
  private String image;

  @JsonProperty("promoText")
  private String promoText;

  @JsonProperty("triggerQuantity")
  private Integer triggerQuantity;

  @JsonProperty("aisleId")
  private String aisleId;

  @JsonProperty("Prop65WarningTypeCD")
  private String Prop65WarningTypeCD;

  @JsonProperty("Prop65WarningText")
  private String Prop65WarningText;

  @JsonProperty("Prop65WarningIconRequired")
  private Boolean Prop65WarningIconRequired;

  @JsonProperty("description")
  private String description;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUpc() {
    return upc;
  }

  public void setUpc(String upc) {
    this.upc = upc;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Integer getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(Integer basePrice) {
    this.basePrice = basePrice;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getSubstitutionValue() {
    return substitutionValue;
  }

  public void setSubstitutionValue(String substitutionValue) {
    this.substitutionValue = substitutionValue;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Float getPricePer() {
    return pricePer;
  }

  public void setPricePer(Float pricePer) {
    this.pricePer = pricePer;
  }

  public String getPromoDescription() {
    return promoDescription;
  }

  public void setPromoDescription(String promoDescription) {
    this.promoDescription = promoDescription;
  }

  public Object getPromoEndDate() {
    return promoEndDate;
  }

  public void setPromoEndDate(Object promoEndDate) {
    this.promoEndDate = promoEndDate;
  }

  public Integer getRestrictedValue() {
    return restrictedValue;
  }

  public void setRestrictedValue(Integer restrictedValue) {
    this.restrictedValue = restrictedValue;
  }

  public String getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public String getPromoType() {
    return promoType;
  }

  public void setPromoType(String promoType) {
    this.promoType = promoType;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getPromoText() {
    return promoText;
  }

  public void setPromoText(String promoText) {
    this.promoText = promoText;
  }

  public Integer getTriggerQuantity() {
    return triggerQuantity;
  }

  public void setTriggerQuantity(Integer triggerQuantity) {
    this.triggerQuantity = triggerQuantity;
  }

  public String getAisleId() {
    return aisleId;
  }

  public void setAisleId(String aisleId) {
    this.aisleId = aisleId;
  }

  public String getProp65WarningTypeCD() {
    return Prop65WarningTypeCD;
  }

  public void setProp65WarningTypeCD(String prop65WarningTypeCD) {
    this.Prop65WarningTypeCD = prop65WarningTypeCD;
  }

  public String getProp65WarningText() {
    return Prop65WarningText;
  }

  public void setProp65WarningText(String prop65WarningText) {
    this.Prop65WarningText = prop65WarningText;
  }

  public Boolean getProp65WarningIconRequired() {
    return Prop65WarningIconRequired;
  }

  public void setProp65WarningIconRequired(Boolean prop65WarningIconRequired) {
    this.Prop65WarningIconRequired = prop65WarningIconRequired;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof BpnProductInfo)) return false;
    BpnProductInfo that = (BpnProductInfo) o;
    return Objects.equal(getId(), that.getId())
        && Objects.equal(getUpc(), that.getUpc())
        && Objects.equal(getName(), that.getName())
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
        && Objects.equal(getImage(), that.getImage())
        && Objects.equal(getPromoText(), that.getPromoText())
        && Objects.equal(getTriggerQuantity(), that.getTriggerQuantity())
        && Objects.equal(getAisleId(), that.getAisleId())
        && Objects.equal(getProp65WarningTypeCD(), that.getProp65WarningTypeCD())
        && Objects.equal(getProp65WarningText(), that.getProp65WarningText())
        && Objects.equal(getProp65WarningIconRequired(), that.getProp65WarningIconRequired())
        && Objects.equal(getDescription(), that.getDescription());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        getId(),
        getUpc(),
        getName(),
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
        getImage(),
        getPromoText(),
        getTriggerQuantity(),
        getAisleId(),
        getProp65WarningTypeCD(),
        getProp65WarningText(),
        getProp65WarningIconRequired(),
        getDescription());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("upc", upc)
        .add("name", name)
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
        .add("image", image)
        .add("promoText", promoText)
        .add("triggerQuantity", triggerQuantity)
        .add("aisleId", aisleId)
        .add("Prop65WarningTypeCD", Prop65WarningTypeCD)
        .add("Prop65WarningText", Prop65WarningText)
        .add("Prop65WarningIconRequired", Prop65WarningIconRequired)
        .add("description", description)
        .toString();
  }
}
