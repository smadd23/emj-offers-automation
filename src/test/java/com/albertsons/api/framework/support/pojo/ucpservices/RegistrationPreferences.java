
package com.albertsons.api.framework.support.pojo.ucpservices;

import com.albertsons.api.framework.support.pojo.ucpservices.RegStorePreferences;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * Current class contains the POJO representation of preferences of UCA Registration.
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"emailOffers", "stores"})
public class RegistrationPreferences {
  @JsonProperty("emailOffers")
  private String emailOffers;

  @JsonProperty("stores")
  private List<RegStorePreferences> stores = null;

  @JsonProperty("emailOffers")
  public String getEmailOffers() {
    return emailOffers;
  }

  @JsonProperty("emailOffers")
  public void setEmailOffers(String emailOffers) {
    this.emailOffers = emailOffers;
  }

  @JsonProperty("stores")
  public List<RegStorePreferences> getStores() {
    return stores;
  }

  @JsonProperty("stores")
  public void setStores(List<RegStorePreferences> stores) {
    this.stores = stores;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrationPreferences that = (RegistrationPreferences) o;
    return Objects.equal(getEmailOffers(), that.getEmailOffers())
        && Objects.equal(getStores(), that.getStores());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getEmailOffers(), getStores());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("emailOffers", emailOffers)
        .add("stores", stores)
        .toString();
  }
}