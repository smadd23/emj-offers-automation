package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of product object.
 *
 * @author vbonk00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "price",
    "basePrice",
    "promoEndDate",
    "pricePer",
    "sellByWeight",
    "averageWeight",
    "maxWeight",
    "upc",
    "aisleId",
    "name",
    "image",
    "estimatedDiscount",
    "departmentName",
    "aisleName",
    "shelfName",
    "promoDescription",
    "promoType",
    "promoText",
    "triggerQuantity",
    "comment",
    "substitutionValue",
    "inlinePromoId",
    "inlinePromoImage",
    "quantity",
    "details",
    "nutritionFacts",
    "displayType",
    "unitOfMeasure",
    "restrictedValue",
    "salesRank",
    "width",
    "depth",
    "height",
    "zonecode",
    "prop65WarningTypeCD",
    "prop65WarningText",
    "prop65WarningIconRequired",
    "productDetailsUrl"
})
public class Product {
  @JsonProperty("id")
  private String id;

  @JsonProperty("price")
  private Float price;

  @JsonProperty("basePrice")
  private Integer basePrice;

  @JsonProperty("promoEndDate")
  private Object promoEndDate;

  @JsonProperty("pricePer")
  private Float pricePer;

  @JsonProperty("sellByWeight")
  private String sellByWeight;

  @JsonProperty("averageWeight")
  private String averageWeight;

  @JsonProperty("maxWeight")
  private String maxWeight;

  @JsonProperty("upc")
  private String upc;

  @JsonProperty("aisleId")
  private String aisleId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("image")
  private String image;

  @JsonProperty("estimatedDiscount")
  private Integer estimatedDiscount;

  @JsonProperty("departmentName")
  private String departmentName;

  @JsonProperty("aisleName")
  private String aisleName;

  @JsonProperty("shelfName")
  private String shelfName;

  @JsonProperty("promoDescription")
  private String promoDescription;

  @JsonProperty("promoType")
  private String promoType;

  @JsonProperty("promoText")
  private String promoText;

  @JsonProperty("triggerQuantity")
  private Integer triggerQuantity;

  @JsonProperty("comment")
  private String comment;

  @JsonProperty("substitutionValue")
  private String substitutionValue;

  @JsonProperty("inlinePromoId")
  private String inlinePromoId;

  @JsonProperty("inlinePromoImage")
  private String inlinePromoImage;

  @JsonProperty("quantity")
  private Integer quantity;

  @JsonProperty("details")
  private Object details;

  @JsonProperty("nutritionFacts")
  private Object nutritionFacts;

  @JsonProperty("displayType")
  private Integer displayType;

  @JsonProperty("unitOfMeasure")
  private String unitOfMeasure;

  @JsonProperty("restrictedValue")
  private Integer restrictedValue;

  @JsonProperty("salesRank")
  private Integer salesRank;

  @JsonProperty("width")
  private Integer width;

  @JsonProperty("depth")
  private Integer depth;

  @JsonProperty("height")
  private Integer height;

  @JsonProperty("zonecode")
  private Object zonecode;

  @JsonProperty("prop65WarningTypeCD")
  private String prop65WarningTypeCD;

  @JsonProperty("prop65WarningText")
  private String prop65WarningText;

  @JsonProperty("prop65WarningIconRequired")
  private Boolean prop65WarningIconRequired;

  @JsonProperty("productDetailsUrl")
  private Object productDetailsUrl;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public Object getPromoEndDate() {
    return promoEndDate;
  }

  public void setPromoEndDate(Object promoEndDate) {
    this.promoEndDate = promoEndDate;
  }

  public Float getPricePer() {
    return pricePer;
  }

  public void setPricePer(Float pricePer) {
    this.pricePer = pricePer;
  }

  public String getSellByWeight() {
    return sellByWeight;
  }

  public void setSellByWeight(String sellByWeight) {
    this.sellByWeight = sellByWeight;
  }

  public String getAverageWeight() {
    return averageWeight;
  }

  public void setAverageWeight(String averageWeight) {
    this.averageWeight = averageWeight;
  }

  public String getMaxWeight() {
    return maxWeight;
  }

  public void setMaxWeight(String maxWeight) {
    this.maxWeight = maxWeight;
  }

  public String getUpc() {
    return upc;
  }

  public void setUpc(String upc) {
    this.upc = upc;
  }

  public String getAisleId() {
    return aisleId;
  }

  public void setAisleId(String aisleId) {
    this.aisleId = aisleId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Integer getEstimatedDiscount() {
    return estimatedDiscount;
  }

  public void setEstimatedDiscount(Integer estimatedDiscount) {
    this.estimatedDiscount = estimatedDiscount;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public String getAisleName() {
    return aisleName;
  }

  public void setAisleName(String aisleName) {
    this.aisleName = aisleName;
  }

  public String getShelfName() {
    return shelfName;
  }

  public void setShelfName(String shelfName) {
    this.shelfName = shelfName;
  }

  public String getPromoDescription() {
    return promoDescription;
  }

  public void setPromoDescription(String promoDescription) {
    this.promoDescription = promoDescription;
  }

  public String getPromoType() {
    return promoType;
  }

  public void setPromoType(String promoType) {
    this.promoType = promoType;
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

  public String getInlinePromoId() {
    return inlinePromoId;
  }

  public void setInlinePromoId(String inlinePromoId) {
    this.inlinePromoId = inlinePromoId;
  }

  public String getInlinePromoImage() {
    return inlinePromoImage;
  }

  public void setInlinePromoImage(String inlinePromoImage) {
    this.inlinePromoImage = inlinePromoImage;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Object getDetails() {
    return details;
  }

  public void setDetails(Object details) {
    this.details = details;
  }

  public Object getNutritionFacts() {
    return nutritionFacts;
  }

  public void setNutritionFacts(Object nutritionFacts) {
    this.nutritionFacts = nutritionFacts;
  }

  public Integer getDisplayType() {
    return displayType;
  }

  public void setDisplayType(Integer displayType) {
    this.displayType = displayType;
  }

  public String getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public Integer getRestrictedValue() {
    return restrictedValue;
  }

  public void setRestrictedValue(Integer restrictedValue) {
    this.restrictedValue = restrictedValue;
  }

  public Integer getSalesRank() {
    return salesRank;
  }

  public void setSalesRank(Integer salesRank) {
    this.salesRank = salesRank;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getDepth() {
    return depth;
  }

  public void setDepth(Integer depth) {
    this.depth = depth;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Object getZonecode() {
    return zonecode;
  }

  public void setZonecode(Object zonecode) {
    this.zonecode = zonecode;
  }

  public String getProp65WarningTypeCD() {
    return prop65WarningTypeCD;
  }

  public void setProp65WarningTypeCD(String prop65WarningTypeCD) {
    this.prop65WarningTypeCD = prop65WarningTypeCD;
  }

  public String getProp65WarningText() {
    return prop65WarningText;
  }

  public void setProp65WarningText(String prop65WarningText) {
    this.prop65WarningText = prop65WarningText;
  }

  public Boolean getProp65WarningIconRequired() {
    return prop65WarningIconRequired;
  }

  public void setProp65WarningIconRequired(Boolean prop65WarningIconRequired) {
    this.prop65WarningIconRequired = prop65WarningIconRequired;
  }

  public Object getProductDetailsUrl() {
    return productDetailsUrl;
  }

  public void setProductDetailsUrl(Object productDetailsUrl) {
    this.productDetailsUrl = productDetailsUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Product)) return false;
    Product product = (Product) o;
    return Objects.equal(getId(), product.getId())
        && Objects.equal(getPrice(), product.getPrice())
        && Objects.equal(getBasePrice(), product.getBasePrice())
        && Objects.equal(getPromoEndDate(), product.getPromoEndDate())
        && Objects.equal(getPricePer(), product.getPricePer())
        && Objects.equal(getSellByWeight(), product.getSellByWeight())
        && Objects.equal(getAverageWeight(), product.getAverageWeight())
        && Objects.equal(getMaxWeight(), product.getMaxWeight())
        && Objects.equal(getUpc(), product.getUpc())
        && Objects.equal(getAisleId(), product.getAisleId())
        && Objects.equal(getName(), product.getName())
        && Objects.equal(getImage(), product.getImage())
        && Objects.equal(getEstimatedDiscount(), product.getEstimatedDiscount())
        && Objects.equal(getDepartmentName(), product.getDepartmentName())
        && Objects.equal(getAisleName(), product.getAisleName())
        && Objects.equal(getShelfName(), product.getShelfName())
        && Objects.equal(getPromoDescription(), product.getPromoDescription())
        && Objects.equal(getPromoType(), product.getPromoType())
        && Objects.equal(getPromoText(), product.getPromoText())
        && Objects.equal(getTriggerQuantity(), product.getTriggerQuantity())
        && Objects.equal(getComment(), product.getComment())
        && Objects.equal(getSubstitutionValue(), product.getSubstitutionValue())
        && Objects.equal(getInlinePromoId(), product.getInlinePromoId())
        && Objects.equal(getInlinePromoImage(), product.getInlinePromoImage())
        && Objects.equal(getQuantity(), product.getQuantity())
        && Objects.equal(getDetails(), product.getDetails())
        && Objects.equal(getNutritionFacts(), product.getNutritionFacts())
        && Objects.equal(getDisplayType(), product.getDisplayType())
        && Objects.equal(getUnitOfMeasure(), product.getUnitOfMeasure())
        && Objects.equal(getRestrictedValue(), product.getRestrictedValue())
        && Objects.equal(getSalesRank(), product.getSalesRank())
        && Objects.equal(getWidth(), product.getWidth())
        && Objects.equal(getDepth(), product.getDepth())
        && Objects.equal(getHeight(), product.getHeight())
        && Objects.equal(getZonecode(), product.getZonecode())
        && Objects.equal(getProp65WarningTypeCD(), product.getProp65WarningTypeCD())
        && Objects.equal(getProp65WarningText(), product.getProp65WarningText())
        && Objects.equal(getProp65WarningIconRequired(), product.getProp65WarningIconRequired())
        && Objects.equal(getProductDetailsUrl(), product.getProductDetailsUrl());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        getId(),
        getPrice(),
        getBasePrice(),
        getPromoEndDate(),
        getPricePer(),
        getSellByWeight(),
        getAverageWeight(),
        getMaxWeight(),
        getUpc(),
        getAisleId(),
        getName(),
        getImage(),
        getEstimatedDiscount(),
        getDepartmentName(),
        getAisleName(),
        getShelfName(),
        getPromoDescription(),
        getPromoType(),
        getPromoText(),
        getTriggerQuantity(),
        getComment(),
        getSubstitutionValue(),
        getInlinePromoId(),
        getInlinePromoImage(),
        getQuantity(),
        getDetails(),
        getNutritionFacts(),
        getDisplayType(),
        getUnitOfMeasure(),
        getRestrictedValue(),
        getSalesRank(),
        getWidth(),
        getDepth(),
        getHeight(),
        getZonecode(),
        getProp65WarningTypeCD(),
        getProp65WarningText(),
        getProp65WarningIconRequired(),
        getProductDetailsUrl());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("price", price)
        .add("basePrice", basePrice)
        .add("promoEndDate", promoEndDate)
        .add("pricePer", pricePer)
        .add("sellByWeight", sellByWeight)
        .add("averageWeight", averageWeight)
        .add("maxWeight", maxWeight)
        .add("upc", upc)
        .add("aisleId", aisleId)
        .add("name", name)
        .add("image", image)
        .add("estimatedDiscount", estimatedDiscount)
        .add("departmentName", departmentName)
        .add("aisleName", aisleName)
        .add("shelfName", shelfName)
        .add("promoDescription", promoDescription)
        .add("promoType", promoType)
        .add("promoText", promoText)
        .add("triggerQuantity", triggerQuantity)
        .add("comment", comment)
        .add("substitutionValue", substitutionValue)
        .add("inlinePromoId", inlinePromoId)
        .add("inlinePromoImage", inlinePromoImage)
        .add("quantity", quantity)
        .add("details", details)
        .add("nutritionFacts", nutritionFacts)
        .add("displayType", displayType)
        .add("unitOfMeasure", unitOfMeasure)
        .add("restrictedValue", restrictedValue)
        .add("salesRank", salesRank)
        .add("width", width)
        .add("depth", depth)
        .add("height", height)
        .add("zonecode", zonecode)
        .add("prop65WarningTypeCD", prop65WarningTypeCD)
        .add("prop65WarningText", prop65WarningText)
        .add("prop65WarningIconRequired", prop65WarningIconRequired)
        .add("productDetailsUrl", productDetailsUrl)
        .toString();
  }
}
