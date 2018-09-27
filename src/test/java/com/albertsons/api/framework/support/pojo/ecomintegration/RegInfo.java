package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of user registration info.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "zipExists",
    "city",
    "state",
    "zipCode",
    "customerType",
    "title",
    "securityQuestion",
    "howRecommended"
})
public class RegInfo {

  @JsonProperty("zipExists")
  private Boolean zipExists;

  @JsonProperty("city")
  private Object city;

  @JsonProperty("state")
  private Object state;

  @JsonProperty("zipCode")
  private String zipCode;

  @JsonProperty("customerType")
  private Object customerType;

  @JsonProperty("title")
  private UserTitle title;

  @JsonProperty("securityQuestion")
  private SecurityQuestion securityQuestion;

  @JsonProperty("howRecommended")
  private HowRecommended howRecommended;

  @JsonProperty("zipExists")
  public Boolean getZipExists() {
    return zipExists;
  }

  @JsonProperty("zipExists")
  public void setZipExists(Boolean zipExists) {
    this.zipExists = zipExists;
  }

  @JsonProperty("city")
  public Object getCity() {
    return city;
  }

  @JsonProperty("city")
  public void setCity(Object city) {
    this.city = city;
  }

  @JsonProperty("state")
  public Object getState() {
    return state;
  }

  @JsonProperty("state")
  public void setState(Object state) {
    this.state = state;
  }

  @JsonProperty("zipCode")
  public String getZipCode() {
    return zipCode;
  }

  @JsonProperty("zipCode")
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  @JsonProperty("customerType")
  public Object getCustomerType() {
    return customerType;
  }

  @JsonProperty("customerType")
  public void setCustomerType(Object customerType) {
    this.customerType = customerType;
  }

  @JsonProperty("title")
  public UserTitle getTitle() {
    return title;
  }

  @JsonProperty("title")
  public void setTitle(UserTitle title) {
    this.title = title;
  }

  @JsonProperty("securityQuestion")
  public SecurityQuestion getSecurityQuestion() {
    return securityQuestion;
  }

  @JsonProperty("securityQuestion")
  public void setSecurityQuestion(SecurityQuestion securityQuestion) {
    this.securityQuestion = securityQuestion;
  }

  @JsonProperty("howRecommended")
  public HowRecommended getHowRecommended() {
    return howRecommended;
  }

  @JsonProperty("howRecommended")
  public void setHowRecommended(HowRecommended howRecommended) {
    this.howRecommended = howRecommended;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof RegInfo)) return false;
    RegInfo regInfo = (RegInfo) o;
    return Objects.equal(getZipExists(), regInfo.getZipExists())
        && Objects.equal(getCity(), regInfo.getCity())
        && Objects.equal(getState(), regInfo.getState())
        && Objects.equal(getZipCode(), regInfo.getZipCode())
        && Objects.equal(getCustomerType(), regInfo.getCustomerType())
        && Objects.equal(getTitle(), regInfo.getTitle())
        && Objects.equal(getSecurityQuestion(), regInfo.getSecurityQuestion())
        && Objects.equal(getHowRecommended(), regInfo.getHowRecommended());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        getZipExists(),
        getCity(),
        getState(),
        getZipCode(),
        getCustomerType(),
        getTitle(),
        getSecurityQuestion(),
        getHowRecommended());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).toString();
  }
}
