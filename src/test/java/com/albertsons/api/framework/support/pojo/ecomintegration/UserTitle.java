package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of title for a user.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"mr", "mrs", "ms", "miss"})
public class UserTitle {

  @JsonProperty("mr")
  private String mr;

  @JsonProperty("mrs")
  private String mrs;

  @JsonProperty("ms")
  private String ms;

  @JsonProperty("miss")
  private String miss;

  @JsonProperty("mr")
  public String getMr() {
    return mr;
  }

  @JsonProperty("mr")
  public void setMr(String mr) {
    this.mr = mr;
  }

  @JsonProperty("mrs")
  public String getMrs() {
    return mrs;
  }

  @JsonProperty("mrs")
  public void setMrs(String mrs) {
    this.mrs = mrs;
  }

  @JsonProperty("ms")
  public String getMs() {
    return ms;
  }

  @JsonProperty("ms")
  public void setMs(String ms) {
    this.ms = ms;
  }

  @JsonProperty("miss")
  public String getMiss() {
    return miss;
  }

  @JsonProperty("miss")
  public void setMiss(String miss) {
    this.miss = miss;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof UserTitle)) return false;
    UserTitle userTitle = (UserTitle) o;
    return Objects.equal(getMr(), userTitle.getMr())
        && Objects.equal(getMrs(), userTitle.getMrs())
        && Objects.equal(getMs(), userTitle.getMs())
        && Objects.equal(getMiss(), userTitle.getMiss());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getMr(), getMrs(), getMs(), getMiss());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("mr", mr)
        .add("mrs", mrs)
        .add("ms", ms)
        .add("miss", miss)
        .toString();
  }
}
