package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of error descriptor.
 * @author SKuna02
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"asOfDate", "clubId", "rewardPoints", "rewardsAvailable", "rewardsExpire"})
public class Rewards {

  @JsonProperty("asOfDate")
  private String asOfDate;

  @JsonProperty("clubId")
  private String clubId;

  @JsonProperty("rewardPoints")
  private String rewardPoints;

  @JsonProperty("rewardsAvailable")
  private String rewardsAvailable;

  @JsonProperty("rewardsExpire")
  private String rewardsExpire;

  @JsonProperty("asOfDate")
  public String getAsOfDate() {
    return asOfDate;
  }

  @JsonProperty("asOfDate")
  public void setAsOfDate(String asOfDate) {
    this.asOfDate = asOfDate;
  }

  @JsonProperty("clubId")
  public String getClubId() {
    return clubId;
  }

  @JsonProperty("clubId")
  public void setClubId(String clubId) {
    this.clubId = clubId;
  }

  @JsonProperty("rewardPoints")
  public String getRewardPoints() {
    return rewardPoints;
  }

  @JsonProperty("rewardPoints")
  public void setRewardPoints(String rewardPoints) {
    this.rewardPoints = rewardPoints;
  }

  @JsonProperty("rewardsAvailable")
  public String getRewardsAvailable() {
    return rewardsAvailable;
  }

  @JsonProperty("rewardsAvailable")
  public void setRewardsAvailable(String rewardsAvailable) {
    this.rewardsAvailable = rewardsAvailable;
  }

  @JsonProperty("rewardsExpire")
  public String getRewardsExpire() {
    return rewardsExpire;
  }

  @JsonProperty("rewardsExpire")
  public void setRewardsExpire(String rewardsExpire) {
    this.rewardsExpire = rewardsExpire;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rewards rewards = (Rewards) o;
    return Objects.equal(getAsOfDate(), rewards.getAsOfDate()) &&
        Objects.equal(getClubId(), rewards.getClubId()) &&
        Objects.equal(getRewardPoints(), rewards.getRewardPoints()) &&
        Objects.equal(getRewardsAvailable(), rewards.getRewardsAvailable()) &&
        Objects.equal(getRewardsExpire(), rewards.getRewardsExpire());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getAsOfDate(), getClubId(), getRewardPoints(), getRewardsAvailable(),
        getRewardsExpire());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("asOfDate", asOfDate)
        .add("clubId", clubId)
        .add("rewardPoints", rewardPoints)
        .add("rewardsAvailable", rewardsAvailable)
        .add("rewardsExpire", rewardsExpire)
        .toString();
  }
}
