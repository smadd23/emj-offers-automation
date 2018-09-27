package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of account info.
 *
 * @author vbonk00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"dayPhone", "eveningPhone", "clubCardId", "currentAddress"})
public class AccountInfo {

  @JsonProperty("dayPhone")
  private String dayPhone;

  @JsonProperty("eveningPhone")
  private String eveningPhone;

  @JsonProperty("clubCardId")
  private String clubCardId;

  @JsonProperty("currentAddress")
  private String currentAddress;

  @JsonProperty("dayPhone")
  public String getDayPhone() {
    return dayPhone;
  }

  @JsonProperty("dayPhone")
  public void setDayPhone(String dayPhone) {
    this.dayPhone = dayPhone;
  }

  @JsonProperty("eveningPhone")
  public String getEveningPhone() {
    return eveningPhone;
  }

  @JsonProperty("eveningPhone")
  public void setEveningPhone(String eveningPhone) {
    this.eveningPhone = eveningPhone;
  }

  @JsonProperty("clubCardId")
  public String getClubCardId() {
    return clubCardId;
  }

  @JsonProperty("clubCardId")
  public void setClubCardId(String clubCardId) {
    this.clubCardId = clubCardId;
  }

  @JsonProperty("currentAddress")
  public String getCurrentAddress() {
    return currentAddress;
  }

  @JsonProperty("currentAddress")
  public void setCurrentAddress(String currentAddress) {
    this.currentAddress = currentAddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AccountInfo that = (AccountInfo) o;
    return Objects.equal(dayPhone, that.dayPhone)
        && Objects.equal(eveningPhone, that.eveningPhone)
        && Objects.equal(clubCardId, that.clubCardId)
        && Objects.equal(currentAddress, that.currentAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(dayPhone, eveningPhone, clubCardId, currentAddress);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("dayPhone", dayPhone)
        .add("eveningPhone", eveningPhone)
        .add("clubCardId", clubCardId)
        .add("currentAddress", currentAddress)
        .toString();
  }
}
