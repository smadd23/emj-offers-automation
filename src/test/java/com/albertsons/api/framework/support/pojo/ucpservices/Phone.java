
package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of Phone.
 * @author SKuna02
 */

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "number"
})

public class Phone {

  @JsonProperty("number")
  private String number;

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

  @JsonProperty("number")
  public String getNumber() {
    return number;
  }

  @JsonProperty("number")
  public void setNumber(String number) {
    this.number = number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Phone phone = (Phone) o;
    return Objects.equal(number, phone.number)
        && Objects.equal(type, phone.type);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(number, type);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("number", number)
        .add("type", type)
        .toString();
  }
}