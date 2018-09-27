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
  "id",
  "price",
  "promoEndDate",
  "pricePer",
  "sellByWeight",
  "averageWeight",
  "maxWeight",
  "aisleId",
  "name",
  "image",
  "departmentName",
  "aisleName",
  "shelfName",
  "promoDescription",
  "promoType",
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
  "salesRank"
})
public class ProductDetail {

  @JsonProperty("id")
  private String id;

  @JsonProperty("price")
  private Integer price;

  @JsonProperty("promoEndDate")
  private Object promoEndDate;

  @JsonProperty("pricePer")
  private Integer pricePer;

  @JsonProperty("sellByWeight")
  private String sellByWeight;

  @JsonProperty("averageWeight")
  private String averageWeight;

  @JsonProperty("maxWeight")
  private String maxWeight;

  @JsonProperty("aisleId")
  private String aisleId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("image")
  private String image;

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
  private List<Detail> details = null;

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

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("price")
  public Integer getPrice() {
    return price;
  }

  @JsonProperty("price")
  public void setPrice(Integer price) {
    this.price = price;
  }

  @JsonProperty("promoEndDate")
  public Object getPromoEndDate() {
    return promoEndDate;
  }

  @JsonProperty("promoEndDate")
  public void setPromoEndDate(Object promoEndDate) {
    this.promoEndDate = promoEndDate;
  }

  @JsonProperty("pricePer")
  public Integer getPricePer() {
    return pricePer;
  }

  @JsonProperty("pricePer")
  public void setPricePer(Integer pricePer) {
    this.pricePer = pricePer;
  }

  @JsonProperty("sellByWeight")
  public String getSellByWeight() {
    return sellByWeight;
  }

  @JsonProperty("sellByWeight")
  public void setSellByWeight(String sellByWeight) {
    this.sellByWeight = sellByWeight;
  }

  @JsonProperty("averageWeight")
  public String getAverageWeight() {
    return averageWeight;
  }

  @JsonProperty("averageWeight")
  public void setAverageWeight(String averageWeight) {
    this.averageWeight = averageWeight;
  }

  @JsonProperty("maxWeight")
  public String getMaxWeight() {
    return maxWeight;
  }

  @JsonProperty("maxWeight")
  public void setMaxWeight(String maxWeight) {
    this.maxWeight = maxWeight;
  }

  @JsonProperty("aisleId")
  public String getAisleId() {
    return aisleId;
  }

  @JsonProperty("aisleId")
  public void setAisleId(String aisleId) {
    this.aisleId = aisleId;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("image")
  public String getImage() {
    return image;
  }

  @JsonProperty("image")
  public void setImage(String image) {
    this.image = image;
  }

  @JsonProperty("departmentName")
  public String getDepartmentName() {
    return departmentName;
  }

  @JsonProperty("departmentName")
  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  @JsonProperty("aisleName")
  public String getAisleName() {
    return aisleName;
  }

  @JsonProperty("aisleName")
  public void setAisleName(String aisleName) {
    this.aisleName = aisleName;
  }

  @JsonProperty("shelfName")
  public String getShelfName() {
    return shelfName;
  }

  @JsonProperty("shelfName")
  public void setShelfName(String shelfName) {
    this.shelfName = shelfName;
  }

  @JsonProperty("promoDescription")
  public String getPromoDescription() {
    return promoDescription;
  }

  @JsonProperty("promoDescription")
  public void setPromoDescription(String promoDescription) {
    this.promoDescription = promoDescription;
  }

  @JsonProperty("promoType")
  public String getPromoType() {
    return promoType;
  }

  @JsonProperty("promoType")
  public void setPromoType(String promoType) {
    this.promoType = promoType;
  }

  @JsonProperty("triggerQuantity")
  public Integer getTriggerQuantity() {
    return triggerQuantity;
  }

  @JsonProperty("triggerQuantity")
  public void setTriggerQuantity(Integer triggerQuantity) {
    this.triggerQuantity = triggerQuantity;
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

  @JsonProperty("inlinePromoId")
  public String getInlinePromoId() {
    return inlinePromoId;
  }

  @JsonProperty("inlinePromoId")
  public void setInlinePromoId(String inlinePromoId) {
    this.inlinePromoId = inlinePromoId;
  }

  @JsonProperty("inlinePromoImage")
  public String getInlinePromoImage() {
    return inlinePromoImage;
  }

  @JsonProperty("inlinePromoImage")
  public void setInlinePromoImage(String inlinePromoImage) {
    this.inlinePromoImage = inlinePromoImage;
  }

  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  @JsonProperty("quantity")
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @JsonProperty("details")
  public List<Detail> getDetails() {
    return details;
  }

  @JsonProperty("details")
  public void setDetails(List<Detail> details) {
    this.details = details;
  }

  @JsonProperty("nutritionFacts")
  public Object getNutritionFacts() {
    return nutritionFacts;
  }

  @JsonProperty("nutritionFacts")
  public void setNutritionFacts(Object nutritionFacts) {
    this.nutritionFacts = nutritionFacts;
  }

  @JsonProperty("displayType")
  public Integer getDisplayType() {
    return displayType;
  }

  @JsonProperty("displayType")
  public void setDisplayType(Integer displayType) {
    this.displayType = displayType;
  }

  @JsonProperty("unitOfMeasure")
  public String getUnitOfMeasure() {
    return unitOfMeasure;
  }

  @JsonProperty("unitOfMeasure")
  public void setUnitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  @JsonProperty("restrictedValue")
  public Integer getRestrictedValue() {
    return restrictedValue;
  }

  @JsonProperty("restrictedValue")
  public void setRestrictedValue(Integer restrictedValue) {
    this.restrictedValue = restrictedValue;
  }

  @JsonProperty("salesRank")
  public Integer getSalesRank() {
    return salesRank;
  }

  @JsonProperty("salesRank")
  public void setSalesRank(Integer salesRank) {
    this.salesRank = salesRank;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ProductDetail)) return false;
    ProductDetail that = (ProductDetail) o;
    return Objects.equal(id, that.id)
        && Objects.equal(price, that.price)
        && Objects.equal(promoEndDate, that.promoEndDate)
        && Objects.equal(pricePer, that.pricePer)
        && Objects.equal(sellByWeight, that.sellByWeight)
        && Objects.equal(averageWeight, that.averageWeight)
        && Objects.equal(maxWeight, that.maxWeight)
        && Objects.equal(aisleId, that.aisleId)
        && Objects.equal(name, that.name)
        && Objects.equal(image, that.image)
        && Objects.equal(departmentName, that.departmentName)
        && Objects.equal(aisleName, that.aisleName)
        && Objects.equal(shelfName, that.shelfName)
        && Objects.equal(promoDescription, that.promoDescription)
        && Objects.equal(promoType, that.promoType)
        && Objects.equal(triggerQuantity, that.triggerQuantity)
        && Objects.equal(comment, that.comment)
        && Objects.equal(substitutionValue, that.substitutionValue)
        && Objects.equal(inlinePromoId, that.inlinePromoId)
        && Objects.equal(inlinePromoImage, that.inlinePromoImage)
        && Objects.equal(quantity, that.quantity)
        && Objects.equal(details, that.details)
        && Objects.equal(nutritionFacts, that.nutritionFacts)
        && Objects.equal(displayType, that.displayType)
        && Objects.equal(unitOfMeasure, that.unitOfMeasure)
        && Objects.equal(restrictedValue, that.restrictedValue)
        && Objects.equal(salesRank, that.salesRank)
        && Objects.equal(additionalProperties, that.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        id,
        price,
        promoEndDate,
        pricePer,
        sellByWeight,
        averageWeight,
        maxWeight,
        aisleId,
        name,
        image,
        departmentName,
        aisleName,
        shelfName,
        promoDescription,
        promoType,
        triggerQuantity,
        comment,
        substitutionValue,
        inlinePromoId,
        inlinePromoImage,
        quantity,
        details,
        nutritionFacts,
        displayType,
        unitOfMeasure,
        restrictedValue,
        salesRank,
        additionalProperties);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("price", price)
        .add("promoEndDate", promoEndDate)
        .add("pricePer", pricePer)
        .add("sellByWeight", sellByWeight)
        .add("averageWeight", averageWeight)
        .add("maxWeight", maxWeight)
        .add("aisleId", aisleId)
        .add("name", name)
        .add("image", image)
        .add("departmentName", departmentName)
        .add("aisleName", aisleName)
        .add("shelfName", shelfName)
        .add("promoDescription", promoDescription)
        .add("promoType", promoType)
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
        .add("additionalProperties", additionalProperties)
        .toString();
  }
}
