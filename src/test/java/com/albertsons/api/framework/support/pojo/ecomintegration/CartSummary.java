package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"cost", "itemsCount", "EstimatedClubCardSavings"})
public class CartSummary {

  @JsonProperty("cost")
  private Double cost;

  @JsonProperty("itemsCount")
  private Integer itemsCount;

  @JsonProperty("EstimatedClubCardSavings")
  private Double estimatedClubCardSavings;

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public Integer getItemsCount() {
    return itemsCount;
  }

  public void setItemsCount(Integer itemsCount) {
    this.itemsCount = itemsCount;
  }

  public Double getEstimatedClubCardSavings() {
    return estimatedClubCardSavings;
  }

  public void setEstimatedClubCardSavings(Double estimatedClubCardSavings) {
    estimatedClubCardSavings = estimatedClubCardSavings;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CartSummary)) return false;
    CartSummary that = (CartSummary) o;
    return Objects.equal(getCost(), that.getCost())
        && Objects.equal(getItemsCount(), that.getItemsCount())
        && Objects.equal(getEstimatedClubCardSavings(), that.getEstimatedClubCardSavings());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getCost(), getItemsCount(), getEstimatedClubCardSavings());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("cost", cost)
        .add("itemsCount", itemsCount)
        .add("EstimatedClubCardSavings", estimatedClubCardSavings)
        .toString();
  }
}
