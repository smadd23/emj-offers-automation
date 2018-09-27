package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of dug store.
 *
 * @author vbonk00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "ro_no",
  "ro_name",
  "addr_1",
  "addr_2",
  "city",
  "state",
  "zipcode",
  "active_from",
  "active_to",
  "banner",
  "isPreferred",
  "dist"
})
public class DugStore {

  @JsonProperty("ro_no")
  private Integer roNo;

  @JsonProperty("ro_name")
  private String roName;

  @JsonProperty("addr_1")
  private String addr1;

  @JsonProperty("addr_2")
  private String addr2;

  @JsonProperty("city")
  private String city;

  @JsonProperty("state")
  private String state;

  @JsonProperty("zipcode")
  private String zipcode;

  @JsonProperty("active_from")
  private String activeFrom;

  @JsonProperty("active_to")
  private String activeTo;

  @JsonProperty("banner")
  private String banner;

  @JsonProperty("isPreferred")
  private Boolean isPreferred;

  @JsonProperty("dist")
  private Float dist;

  @JsonProperty("ro_no")
  public Integer getRoNo() {
    return roNo;
  }

  @JsonProperty("ro_no")
  public void setRoNo(Integer roNo) {
    this.roNo = roNo;
  }

  @JsonProperty("ro_name")
  public String getRoName() {
    return roName;
  }

  @JsonProperty("ro_name")
  public void setRoName(String roName) {
    this.roName = roName;
  }

  @JsonProperty("addr_1")
  public String getAddr1() {
    return addr1;
  }

  @JsonProperty("addr_1")
  public void setAddr1(String addr1) {
    this.addr1 = addr1;
  }

  @JsonProperty("addr_2")
  public String getAddr2() {
    return addr2;
  }

  @JsonProperty("addr_2")
  public void setAddr2(String addr2) {
    this.addr2 = addr2;
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

  @JsonProperty("zipcode")
  public String getZipcode() {
    return zipcode;
  }

  @JsonProperty("zipcode")
  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  @JsonProperty("active_from")
  public String getActiveFrom() {
    return activeFrom;
  }

  @JsonProperty("active_from")
  public void setActiveFrom(String activeFrom) {
    this.activeFrom = activeFrom;
  }

  @JsonProperty("active_to")
  public String getActiveTo() {
    return activeTo;
  }

  @JsonProperty("active_to")
  public void setActiveTo(String activeTo) {
    this.activeTo = activeTo;
  }

  @JsonProperty("banner")
  public String getBanner() {
    return banner;
  }

  @JsonProperty("banner")
  public void setBanner(String banner) {
    this.banner = banner;
  }

  @JsonProperty("isPreferred")
  public Boolean getIsPreferred() {
    return isPreferred;
  }

  @JsonProperty("isPreferred")
  public void setIsPreferred(Boolean isPreferred) {
    this.isPreferred = isPreferred;
  }

  @JsonProperty("dist")
  public Float getDist() {
    return dist;
  }

  @JsonProperty("dist")
  public void setDist(Float dist) {
    this.dist = dist;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DugStore dugStore = (DugStore) o;
    return Objects.equal(roNo, dugStore.roNo)
        && Objects.equal(roName, dugStore.roName)
        && Objects.equal(addr1, dugStore.addr1)
        && Objects.equal(addr2, dugStore.addr2)
        && Objects.equal(city, dugStore.city)
        && Objects.equal(state, dugStore.state)
        && Objects.equal(zipcode, dugStore.zipcode)
        && Objects.equal(activeFrom, dugStore.activeFrom)
        && Objects.equal(activeTo, dugStore.activeTo)
        && Objects.equal(banner, dugStore.banner)
        && Objects.equal(isPreferred, dugStore.isPreferred)
        && Objects.equal(dist, dugStore.dist);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        roNo,
        roName,
        addr1,
        addr2,
        city,
        state,
        zipcode,
        activeFrom,
        activeTo,
        banner,
        isPreferred,
        dist);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("roNo", roNo)
        .add("roName", roName)
        .add("addr1", addr1)
        .add("addr2", addr2)
        .add("city", city)
        .add("state", state)
        .add("zipcode", zipcode)
        .add("activeFrom", activeFrom)
        .add("activeTo", activeTo)
        .add("banner", banner)
        .add("isPreferred", isPreferred)
        .add("dist", dist)
        .toString();
  }
}
