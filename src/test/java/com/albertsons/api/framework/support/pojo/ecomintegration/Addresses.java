package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of addresses.
 *
 * @author vbonk00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "AddressOrExternalId",
  "AddressId",
  "ExternalId",
  "AddressName",
  "Address1",
  "Address2",
  "City",
  "State",
  "ZipCode",
  "ServiceType"
})
public class Addresses {

  @JsonProperty("AddressOrExternalId")
  private String addressOrExternalId;

  @JsonProperty("AddressId")
  private Integer addressId;

  @JsonProperty("ExternalId")
  private Object externalId;

  @JsonProperty("AddressName")
  private String addressName;

  @JsonProperty("Address1")
  private String address1;

  @JsonProperty("Address2")
  private String address2;

  @JsonProperty("City")
  private String city;

  @JsonProperty("State")
  private String state;

  @JsonProperty("ZipCode")
  private String zipCode;

  @JsonProperty("ServiceType")
  private ServiceType serviceType;

  @JsonProperty("AddressOrExternalId")
  public String getAddressOrExternalId() {
    return addressOrExternalId;
  }

  @JsonProperty("AddressOrExternalId")
  public void setAddressOrExternalId(String addressOrExternalId) {
    this.addressOrExternalId = addressOrExternalId;
  }

  @JsonProperty("AddressId")
  public Integer getAddressId() {
    return addressId;
  }

  @JsonProperty("AddressId")
  public void setAddressId(Integer addressId) {
    this.addressId = addressId;
  }

  @JsonProperty("ExternalId")
  public Object getExternalId() {
    return externalId;
  }

  @JsonProperty("ExternalId")
  public void setExternalId(Object externalId) {
    this.externalId = externalId;
  }

  @JsonProperty("AddressName")
  public String getAddressName() {
    return addressName;
  }

  @JsonProperty("AddressName")
  public void setAddressName(String addressName) {
    this.addressName = addressName;
  }

  @JsonProperty("Address1")
  public String getAddress1() {
    return address1;
  }

  @JsonProperty("Address1")
  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  @JsonProperty("Address2")
  public String getAddress2() {
    return address2;
  }

  @JsonProperty("Address2")
  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  @JsonProperty("City")
  public String getCity() {
    return city;
  }

  @JsonProperty("City")
  public void setCity(String city) {
    this.city = city;
  }

  @JsonProperty("State")
  public String getState() {
    return state;
  }

  @JsonProperty("State")
  public void setState(String state) {
    this.state = state;
  }

  @JsonProperty("ZipCode")
  public String getZipCode() {
    return zipCode;
  }

  @JsonProperty("ZipCode")
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  @JsonProperty("ServiceType")
  public ServiceType getServiceType() {
    return serviceType;
  }

  @JsonProperty("ServiceType")
  public void setServiceType(ServiceType serviceType) {
    this.serviceType = serviceType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Addresses addresses = (Addresses) o;
    return Objects.equal(addressOrExternalId, addresses.addressOrExternalId)
        && Objects.equal(addressId, addresses.addressId)
        && Objects.equal(externalId, addresses.externalId)
        && Objects.equal(addressName, addresses.addressName)
        && Objects.equal(address1, addresses.address1)
        && Objects.equal(address2, addresses.address2)
        && Objects.equal(city, addresses.city)
        && Objects.equal(state, addresses.state)
        && Objects.equal(zipCode, addresses.zipCode)
        && Objects.equal(serviceType, addresses.serviceType);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        addressOrExternalId,
        addressId,
        externalId,
        addressName,
        address1,
        address2,
        city,
        state,
        zipCode,
        serviceType);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("addressOrExternalId", addressOrExternalId)
        .add("addressId", addressId)
        .add("externalId", externalId)
        .add("addressName", addressName)
        .add("address1", address1)
        .add("address2", address2)
        .add("city", city)
        .add("state", state)
        .add("zipCode", zipCode)
        .add("serviceType", serviceType)
        .toString();
  }
}
