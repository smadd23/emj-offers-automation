package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * This class contains the pojo representation of Address.
 *
 * @author vkumar218
 */
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"addressId", "addressName", "address1", "address2", "zipCode", "city", "state"})
public class Address {

  @JsonProperty("addressId")
  private String addressId;

  @JsonProperty("addressName")
  private String addressName;

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

  @JsonProperty("addressId")
  public String getAddressId() {
    return addressId;
  }

  @JsonProperty("addressId")
  public void setAddressId(String addressId) {
    this.addressId = addressId;
  }

  @JsonProperty("addressName")
  public String getAddressName() {
    return addressName;
  }

  @JsonProperty("addressName")
  public void setAddressName(String addressName) {
    this.addressName = addressName;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Address address = (Address) o;
    return java.util.Objects.equals(addressId, address.addressId)
        && java.util.Objects.equals(addressName, address.addressName)
        && java.util.Objects.equals(address1, address.address1)
        && java.util.Objects.equals(address2, address.address2)
        && java.util.Objects.equals(zipCode, address.zipCode)
        && java.util.Objects.equals(city, address.city)
        && java.util.Objects.equals(state, address.state);
  }

  @Override
  public int hashCode() {

    return java.util.Objects.hash(addressId, addressName, address1, address2, zipCode, city, state);
  }

  @Override
  public String toString() {
    return "Address{"
        + "addressId='"
        + addressId
        + '\''
        + "addressId='"
        + addressName
        + '\''
        + ", address1='"
        + address1
        + '\''
        + ", address1='"
        + address2
        + '\''
        + ", zipCode='"
        + zipCode
        + '\''
        + ", city='"
        + city
        + '\''
        + ", state='"
        + state
        + '\''
        + '}';
  }
}
