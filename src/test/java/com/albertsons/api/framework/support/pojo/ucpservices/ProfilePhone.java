package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of Profile specific Phone.
 *
 * @author vkumar218
 */
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"purpose", "number"})
public class ProfilePhone {

  @JsonProperty("number")
  private String number;

  @JsonProperty("purpose")
  private String purpose;

  @JsonProperty("purpose")
  public String getPurpose() {
    return purpose;
  }

  @JsonProperty("purpose")
  public void setPurpose(String purpose) {
    this.purpose = purpose;
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
    ProfilePhone phone = (ProfilePhone) o;
    return Objects.equal(number, phone.number) && Objects.equal(purpose, phone.purpose);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(number, purpose);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("number", number)
        .add("purpose", purpose)
        .toString();
  }
}
