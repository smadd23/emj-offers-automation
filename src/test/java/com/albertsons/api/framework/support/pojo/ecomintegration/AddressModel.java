package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * This class contains the pojo representation of address model.
 *
 * @author vbonk00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"SelectedAddress", "Addresses", "From"})
public class AddressModel {

  @JsonProperty("SelectedAddress")
  private String selectedAddress;

  @JsonProperty("Addresses")
  private List<Addresses> addresses = null;

  @JsonProperty("From")
  private String from;

  @JsonProperty("SelectedAddress")
  public String getSelectedAddress() {
    return selectedAddress;
  }

  @JsonProperty("SelectedAddress")
  public void setSelectedAddress(String selectedAddress) {
    this.selectedAddress = selectedAddress;
  }

  @JsonProperty("Addresses")
  public List<Addresses> getAddresses() {
    return addresses;
  }

  @JsonProperty("Addresses")
  public void setAddresses(List<Addresses> addresses) {
    this.addresses = addresses;
  }

  @JsonProperty("From")
  public String getFrom() {
    return from;
  }

  @JsonProperty("From")
  public void setFrom(String from) {
    this.from = from;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AddressModel that = (AddressModel) o;
    return Objects.equal(selectedAddress, that.selectedAddress)
        && Objects.equal(addresses, that.addresses)
        && Objects.equal(from, that.from);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(selectedAddress, addresses, from);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("selectedAddress", selectedAddress)
        .add("addresses", addresses)
        .add("from", from)
        .toString();
  }
}
