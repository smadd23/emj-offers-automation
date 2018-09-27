package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Current class is the POJO representation of Alternate Id list of Profile.
 *
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"type", "value"})
public class AlternateId {

  @JsonProperty("type")
  private String type;

  @JsonProperty("value")
  private Integer value;

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("value")
  public Integer getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(Integer value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "AlternateId{" + "type='" + type + '\'' + ", value=" + value + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlternateId that = (AlternateId) o;
    return java.util.Objects.equals(type, that.type) && java.util.Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {

    return java.util.Objects.hash(type, value);
  }
}
