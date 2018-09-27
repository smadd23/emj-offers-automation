package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Pojo class to represent omniture params.
 *
 * <p>Created by vbonk00.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"userId", "storeNumber", "zipCode"})
public class OmnitureParams {

  @JsonProperty("userId")
  private String userId;

  @JsonProperty("storeNumber")
  private String storeNumber;

  @JsonProperty("zipCode")
  private String zipCode;

  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }

  @JsonProperty("userId")
  public void setUserId(String userId) {
    this.userId = userId;
  }

  @JsonProperty("storeNumber")
  public String getStoreNumber() {
    return storeNumber;
  }

  @JsonProperty("storeNumber")
  public void setStoreNumber(String storeNumber) {
    this.storeNumber = storeNumber;
  }

  @JsonProperty("zipCode")
  public String getZipCode() {
    return zipCode;
  }

  @JsonProperty("zipCode")
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OmnitureParams that = (OmnitureParams) o;
    return Objects.equal(userId, that.userId)
        && Objects.equal(storeNumber, that.storeNumber)
        && Objects.equal(zipCode, that.zipCode);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(userId, storeNumber, zipCode);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("userId", userId)
        .add("storeNumber", storeNumber)
        .add("zipCode", zipCode)
        .toString();
  }
}
