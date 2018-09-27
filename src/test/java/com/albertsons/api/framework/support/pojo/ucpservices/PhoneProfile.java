package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/**
 * This class contains the pojo representation of Phone in Profile.
 *
 * @author SKuna02
 */
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"purpose", "number"})
public class PhoneProfile {

  @JsonProperty("purpose")
  private String purpose;

  @JsonProperty("number")
  private String number;

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
    PhoneProfile that = (PhoneProfile) o;
    return Objects.equals(purpose, that.purpose) && Objects.equals(number, that.number);
  }

  @Override
  public int hashCode() {

    return Objects.hash(purpose, number);
  }

  @Override
  public String toString() {
    return "PhoneProfile{" + "purpose='" + purpose + '\'' + ", number='" + number + '\'' + '}';
  }
}
