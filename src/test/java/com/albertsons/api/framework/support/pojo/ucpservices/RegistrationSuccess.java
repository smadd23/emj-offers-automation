package com.albertsons.api.framework.support.pojo.ucpservices;

import com.albertsons.api.framework.support.pojo.ecomintegration.Links;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Arrays;

/**
 * Current class is POJO representation of Registration Success.
 * @author SKuna02
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "customerId",
        "clubCardNumber",
        "authorization",
        "links"
})

public class RegistrationSuccess {

  @JsonProperty("customerId")
  private String customerId;

  @JsonProperty("clubCardNumber")
  private String clubCardNumber;

  @JsonProperty("authorization")
  private RegistrationAuthResponse authorization;

  @JsonProperty("links")
  private Links[] links = null;

  @JsonProperty("customerId")
  public String getCustomerId() {
    return customerId;
  }

  @JsonProperty("customerId")
  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  @JsonProperty("clubCardNumber")
  public String getClubCardNumber() {
    return clubCardNumber;
  }

  @JsonProperty("clubCardNumber")
  public void setClubCardNumber(String clubCardNumber) {
    this.clubCardNumber = clubCardNumber;
  }

  @JsonProperty("authorization")
  public RegistrationAuthResponse getAuthorization() {
    return authorization;
  }

  @JsonProperty("authorization")
  public void setAuthorization(RegistrationAuthResponse authorization) {
    this.authorization = authorization;
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
    RegistrationSuccess that = (RegistrationSuccess) o;
    return java.util.Objects.equals(customerId, that.customerId)
            && java.util.Objects.equals(clubCardNumber, that.clubCardNumber)
            && java.util.Objects.equals(authorization, that.authorization)
            && Arrays.equals(links, that.links);
  }

  @Override
  public int hashCode() {

    int result = java.util.Objects.hash(customerId, clubCardNumber, authorization);
    result = 31 * result + Arrays.hashCode(links);
    return result;
  }

  @Override
  public String toString() {
    return "RegistrationSuccess{"
            + "customerId='" + customerId + '\''
            + ", clubCardNumber='" + clubCardNumber + '\''
            + ", authorization=" + authorization
            + ", links=" + Arrays.toString(links)
            + '}';
  }
}
