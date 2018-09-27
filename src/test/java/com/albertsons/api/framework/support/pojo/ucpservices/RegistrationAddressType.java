package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/** Current class contains the POJO representation of address Type
 * parameter in Full Registration of UCA Fascade Service.
 * @author SKuna02
 * */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name"})
public class RegistrationAddressType {

  @JsonProperty("name")
  private String name;

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrationAddressType that = (RegistrationAddressType) o;
    return Objects.equal(getName(), that.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getName());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .toString();
  }
}