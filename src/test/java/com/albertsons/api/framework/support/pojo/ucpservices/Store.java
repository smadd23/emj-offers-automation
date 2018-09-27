package com.albertsons.api.framework.support.pojo.ucpservices;

import com.albertsons.api.framework.support.pojo.ecomintegration.Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Objects;

/**
 * This class contains the pojo representation of Phone.
 *
 * @author vkuma26
 */
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"userPreference", "storeId", "banner", "address", "services"})
public class Store {

  @JsonProperty("userPreference")
  private String userPreference;

  @JsonProperty("storeId")
  private String storeId;

  @JsonProperty("banner")
  private String banner;

  @JsonProperty("address")
  private List<Address> address;

  @JsonProperty("services")
  private List<Services> services;

  @JsonProperty("userPreference")
  public String getUserPreference() {
    return userPreference;
  }

  @JsonProperty("userPreference")
  public void setUserPreference(String userPreference) {
    this.userPreference = userPreference;
  }

  @JsonProperty("storeId")
  public String getStoreId() {
    return storeId;
  }

  @JsonProperty("storeId")
  public void setStoreId(String storeId) {
    this.storeId = storeId;
  }

  @JsonProperty("banner")
  public String getBanner() {
    return banner;
  }

  @JsonProperty("banner")
  public void setBanner(String banner) {
    this.banner = banner;
  }

  @JsonProperty("address")
  public List<Address> getAddress() {
    return address;
  }

  @JsonProperty("address")
  public void setAddress(List<Address> address) {
    this.address = address;
  }

  @JsonProperty("services")
  public List<Services> getServices() {
    return services;
  }

  @JsonProperty("services")
  public void setServices(List<Services> services) {
    this.services = services;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Store store = (Store) o;
    return Objects.equals(userPreference, store.userPreference)
        && Objects.equals(storeId, store.storeId)
        && Objects.equals(banner, store.banner)
        && Objects.equals(address, store.address)
        && Objects.equals(services, store.services);
  }

  @Override
  public int hashCode() {

    return Objects.hash(userPreference, storeId, banner, address, services);
  }

  @Override
  public String toString() {
    return "Store{"
        + "userPreference='"
        + userPreference
        + '\''
        + ", storeId='"
        + storeId
        + '\''
        + ", banner='"
        + banner
        + '\''
        + ", address="
        + address
        + ", services="
        + services
        + '}';
  }
}
