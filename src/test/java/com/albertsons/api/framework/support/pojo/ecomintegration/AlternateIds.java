package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of Alternate Ids
 *
 * @author vkumar218
 */
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"type", "value"})
public class AlternateIds {

  @JsonProperty("value")
  private String value;

  @JsonProperty("type")
  private String type;

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlternateIds alternateIds = (AlternateIds) o;
    return Objects.equal(value, alternateIds.value) && Objects.equal(type, alternateIds.type);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value, type);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("value", value).add("type", type).toString();
  }
}
