package com.albertsons.api.framework.support.pojo.ucpservices;

import com.albertsons.api.framework.support.pojo.ecomintegration.Links;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Current class contains the POJO representation of Kmsi Valid.
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kmsiId",
    "emailId",
    "sessionToken",
    "expireAt",
    "links"
})

public class KmsiValid {

  @JsonProperty("kmsiId")
  private String kmsiId;

  @JsonProperty("emailId")
  private String emailId;

  @JsonProperty("sessionToken")
  private String sessionToken;

  @JsonProperty("expireAt")
  private String expireAt;

  @JsonProperty("links")
  private Links[] links;

  @JsonProperty("kmsiId")
  public String getKmsiId() {
    return kmsiId;
  }

  @JsonProperty("kmsiId")
  public void setKmsiId(String kmsiId) {
    this.kmsiId = kmsiId;
  }

  @JsonProperty("emailId")
  public String getEmailId() {
    return emailId;
  }

  @JsonProperty("emailId")
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  @JsonProperty("sessionToken")
  public String getSessionToken() {
    return sessionToken;
  }

  @JsonProperty("sessionToken")
  public void setSessionToken(String sessionToken) {
    this.sessionToken = sessionToken;
  }

  @JsonProperty("expireAt")
  public String getExpireAt() {
    return expireAt;
  }

  @JsonProperty("expireAt")
  public void setExpireAt(String expireAt) {
    this.expireAt = expireAt;
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
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KmsiValid kmsiValid = (KmsiValid) o;
    return Objects.equal(getKmsiId(), kmsiValid.getKmsiId()) &&
        Objects.equal(getEmailId(), kmsiValid.getEmailId()) &&
        Objects.equal(getSessionToken(), kmsiValid.getSessionToken()) &&
        Objects.equal(getExpireAt(), kmsiValid.getExpireAt()) &&
        Objects.equal(getLinks(), kmsiValid.getLinks());
  }

  @Override
  public int hashCode() {
    return Objects
        .hashCode(getKmsiId(), getEmailId(), getSessionToken(), getExpireAt(), getLinks());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("kmsiId", kmsiId)
        .add("emailId", emailId)
        .add("sessionToken", sessionToken)
        .add("expireAt", expireAt)
        .add("links", links)
        .toString();
  }
}