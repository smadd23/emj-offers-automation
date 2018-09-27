package com.albertsons.api.framework.support.pojo.ucpservices;

import com.albertsons.api.framework.support.pojo.ecomintegration.Links;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * This class contains the pojo representation of Subscription Details.
 *
 * @author vkuma26
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"loyaltyPartners", "links"})
public class UserLoyaltyPartners {

  @JsonProperty("loyaltyPartners")
  private List<LoyaltyPartner> loyaltyPartners = null;

  @JsonProperty("links")
  private Links[] links;

  @JsonProperty("loyaltyPartners")
  public List<LoyaltyPartner> getLoyaltyPartners() {
    return loyaltyPartners;
  }

  @JsonProperty("loyaltyPartners")
  public void setLoyaltyPartners(List<LoyaltyPartner> loyaltyPartners) {
    this.loyaltyPartners = loyaltyPartners;
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
    UserLoyaltyPartners that = (UserLoyaltyPartners) o;
    return Objects.equals(loyaltyPartners, that.loyaltyPartners)
        && Arrays.equals(links, that.links);
  }

  @Override
  public int hashCode() {

    int result = Objects.hash(loyaltyPartners);
    result = 31 * result + Arrays.hashCode(links);
    return result;
  }

  @Override
  public String toString() {
    return "UserLoyaltyPartners{"
        + "loyaltyPartners="
        + loyaltyPartners
        + ", links="
        + Arrays.toString(links)
        + '}';
  }
}
