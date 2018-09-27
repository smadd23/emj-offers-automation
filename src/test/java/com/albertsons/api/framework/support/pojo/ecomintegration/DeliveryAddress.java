package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Arrays;
import java.util.List;

/**
 * This class contains the pojo representation of delivery address.
 *
 * @author vkuma26
 */
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"addresses", "links"})
public class DeliveryAddress {

  @JsonProperty("addresses")
  private List<Address> addresses;

  @JsonProperty("links")
  private Links[] links;

  @JsonProperty("addresses")
  public List<Address> getAddresses() {
    return addresses;
  }

  @JsonProperty("addresses")
  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  @JsonProperty("links")
  public Links[] getLinks() {
    return links;
  }

  @JsonProperty("links")
  public void setLinks(Links[] links) {
    this.links = links;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DeliveryAddress that = (DeliveryAddress) o;
    return java.util.Objects.equals(addresses, that.addresses) && Arrays.equals(links, that.links);
  }

  @Override
  public int hashCode() {

    int result = java.util.Objects.hash(addresses);
    result = 31 * result + Arrays.hashCode(links);
    return result;
  }

  @Override
  public String toString() {
    return "DeliveryAddress{"
        + "addresses="
        + addresses
        + ", links="
        + Arrays.toString(links)
        + '}';
  }
}
