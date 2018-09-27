package com.albertsons.api.framework.support.pojo.ucpservices;

import com.albertsons.api.framework.support.pojo.ecomintegration.Links;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;

/**
 * Class with pojo representation of Rewards type.
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"rewards", "savings", "j4uId", "errors", "links"})
public class RewardsSummary {

  @JsonProperty("rewards")
  private Rewards rewards;

  @JsonProperty("savings")
  private RewardsSavings savings;

  @JsonProperty("j4uId")
  private String j4uId;

  @JsonProperty("errors")
  private List<RewardsError> errors;

  @JsonProperty("links")
  private Links[] links;

  @JsonProperty("rewards")
  public Rewards getRewards() {
    return rewards;
  }

  @JsonProperty("rewards")
  public void setRewards(Rewards rewards) {
    this.rewards = rewards;
  }

  @JsonProperty("savings")
  public RewardsSavings getSavings() {
    return savings;
  }

  @JsonProperty("savings")
  public void setSavings(RewardsSavings savings) {
    this.savings = savings;
  }

  @JsonProperty("j4uId")
  public String getJ4uId() {
    return j4uId;
  }

  @JsonProperty("j4uId")
  public void setJ4uId(String j4uId) {
    this.j4uId = j4uId;
  }

  @JsonProperty("errors")
  public List<RewardsError> getErrors() {
    return errors;
  }

  @JsonProperty("errors")
  public void setErrors(RewardsError[] errors) {
    this.errors = Arrays.asList(errors);
  }

  @JsonProperty("links")
  public Links[] getLinks() {
    return links;
  }

  @JsonProperty("links")
  public void setLinks(Links[] links) {
    this.links = links;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RewardsSummary that = (RewardsSummary) o;
    return Objects.equal(rewards, that.rewards)
        && Objects.equal(savings, that.savings)
        && Objects.equal(j4uId, that.j4uId)
        && Objects.equal(errors, that.errors)
        && Objects.equal(links, that.links);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(rewards, savings, j4uId, errors, links);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("rewards", rewards)
        .add("savings", savings)
        .add("j4uId", j4uId)
        .add("errors", errors)
        .add("links", links)
        .toString();
  }
}
