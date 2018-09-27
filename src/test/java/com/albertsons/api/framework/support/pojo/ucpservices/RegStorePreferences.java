package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Current class contains the POJO representation of Store preferences of UCA Registration.
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "storeId",
    "storePreference"
})
public class RegStorePreferences {

  @JsonProperty("storeId")
  private String storeId;

  @JsonProperty("storePreference")
  private String storePreference;

  @JsonProperty("storeId")
  public String getStoreId() {
    return storeId;
  }

  @JsonProperty("storeId")
  public void setStoreId(String storeId) {
    this.storeId = storeId;
  }

  @JsonProperty("storePreference")
  public String getStorePreference() {
    return storePreference;
  }

  @JsonProperty("storePreference")
  public void setStorePreference(String storePreference) {
    this.storePreference = storePreference;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegStorePreferences that = (RegStorePreferences) o;
    return Objects.equal(getStoreId(), that.getStoreId())
        && Objects.equal(getStorePreference(), that.getStorePreference());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getStoreId(), getStorePreference());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("storeId", storeId)
        .add("storePreference", storePreference)
        .toString();
  }
}
