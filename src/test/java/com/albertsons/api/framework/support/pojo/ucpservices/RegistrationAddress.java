package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * Current class contains the POJO representation of Address element in Full Registration.
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"addressType", "address1", "address2", "zipCode", "city", "state", "phone"})
public class RegistrationAddress {
  @JsonProperty("addressType")
  private RegistrationAddressType addressType;

  @JsonProperty("address1")
  private String address1;

  @JsonProperty("address2")
  private String address2;

  @JsonProperty("zipCode")
  private String zipCode;

  @JsonProperty("city")
  private String city;

  @JsonProperty("state")
  private String state;

  @JsonProperty("phone")
  private List<Phone> phone = null;

  @JsonProperty("addressType")
  public RegistrationAddressType getAddressType() {
    return addressType;
  }

  @JsonProperty("addressType")
  public void setAddressType(RegistrationAddressType addressType) {
    this.addressType = addressType;
  }

  @JsonProperty("address1")
  public String getAddress1() {
    return address1;
  }

  @JsonProperty("address1")
  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  @JsonProperty("address2")
  public String getAddress2() {
    return address2;
  }

  @JsonProperty("address2")
  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  @JsonProperty("zipCode")
  public String getZipCode() {
    return zipCode;
  }

  @JsonProperty("zipCode")
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  @JsonProperty("city")
  public String getCity() {
    return city;
  }

  @JsonProperty("city")
  public void setCity(String city) {
    this.city = city;
  }

  @JsonProperty("state")
  public String getState() {
    return state;
  }

  @JsonProperty("state")
  public void setState(String state) {
    this.state = state;
  }

  @JsonProperty("phone")
  public List<Phone> getPhone() {
    return phone;
  }

  @JsonProperty("phone")
  public void setPhone(List<Phone> phone) {
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrationAddress that = (RegistrationAddress) o;
    return Objects.equal(getAddressType(), that.getAddressType())
        && Objects.equal(getAddress1(), that.getAddress1())
        && Objects.equal(getAddress2(), that.getAddress2())
        && Objects.equal(getZipCode(), that.getZipCode())
        && Objects.equal(getCity(), that.getCity())
        && Objects.equal(getState(), that.getState())
        && Objects.equal(getPhone(), that.getPhone());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        getAddressType(),
        getAddress1(),
        getAddress2(),
        getZipCode(),
        getCity(),
        getState(),
        getPhone());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("addressType", addressType)
        .add("address1", address1)
        .add("address2", address2)
        .add("zipCode", zipCode)
        .add("city", city)
        .add("state", state)
        .add("phone", phone)
        .toString();
  }
}
