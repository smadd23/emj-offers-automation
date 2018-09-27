package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Class with pojo representation of Rewards type.
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"lifetimeSavings", "currentYearSavings"})
public class RewardsSavings {

  @JsonProperty("lifetimeSavings")
  private int lifetimeSavings;

  @JsonProperty("currentYearSavings")
  private int currentYearSavings;

  @JsonProperty("lifetimeSavings")
  public int getLifetimeSavings() {
    return lifetimeSavings;
  }

  @JsonProperty("lifetimeSavings")
  public void setLifetimeSavings(int lifetimeSavings) {
    this.lifetimeSavings = lifetimeSavings;
  }

  @JsonProperty("currentYearSavings")
  public int getCurrentYearSavings() {
    return currentYearSavings;
  }

  @JsonProperty("currentYearSavings")
  public void setCurrentYearSavings(int currentYearSavings) {
    this.currentYearSavings = currentYearSavings;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RewardsSavings that = (RewardsSavings) o;
    return Objects.equal(lifetimeSavings, that.lifetimeSavings)
        && Objects.equal(currentYearSavings, that.currentYearSavings);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("lifetimeSavings", lifetimeSavings)
        .add("currentYearSavings", currentYearSavings)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(lifetimeSavings, currentYearSavings);
  }
}
