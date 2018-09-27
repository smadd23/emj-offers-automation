package com.albertsons.api.framework.support.pojo.ucpservices;

import com.albertsons.api.framework.support.pojo.ecomintegration.Links;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Arrays;
import java.util.List;

/**
 * This class contains the pojo representation of user stores.
 *
 * @author vkuma26
 */
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"stores", "links"})
public class UserStores {

  @JsonProperty("stores")
  private List<Store> stores;

  @JsonProperty("links")
  private Links[] links;

  @JsonProperty("stores")
  public List<Store> getStores() {
    return stores;
  }

  @JsonProperty("stores")
  public void setStores(List<Store> stores) {
    this.stores = stores;
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
    UserStores that = (UserStores) o;
    return java.util.Objects.equals(stores, that.stores) && Arrays.equals(links, that.links);
  }

  @Override
  public int hashCode() {

    int result = java.util.Objects.hash(stores);
    result = 31 * result + Arrays.hashCode(links);
    return result;
  }

  @Override
  public String toString() {
    return "DeliveryAddress{" + "stores=" + stores + ", links=" + Arrays.toString(links) + '}';
  }
}
