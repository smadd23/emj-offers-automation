package com.albertsons.api.framework.support.pojo.ucpservices;

import com.albertsons.api.framework.support.pojo.ecomintegration.Links;
import com.albertsons.api.framework.support.pojo.ecomintegration.AlternateIds;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Arrays;
import java.util.List;

/**
 * This class contains the pojo representation of Profile specific Phone.
 *
 * @author vkumar218
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "emailId",
    "banner",
    "lastName",
    "firstName",
    "phone",
    "clubCardNumber",
    "customerId",
    "hhid",
    "alternateIds",
    "links"
})
public class UpdatedProfile {

  @JsonProperty("emailId")
  private String emailId;

  @JsonProperty("banner")
  private String banner;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("phone")
  private List<ProfilePhone> phone;

  @JsonProperty("clubCardNumber")
  private String clubCardNumber;

  @JsonProperty("customerId")
  private String customerId;

  @JsonProperty("hhid")
  private String hhid;

  @JsonProperty("alternateIds")
  private List<AlternateIds> alternateIds;

  @JsonProperty("links")
  private Links[] links;

  @JsonProperty("emailId")
  public String getEmailId() {
    return emailId;
  }

  @JsonProperty("emailId")
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  @JsonProperty("banner")
  public String getBanner() {
    return banner;
  }

  @JsonProperty("banner")
  public void setBanner(String banner) {
    this.banner = banner;
  }

  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  @JsonProperty("lastName")
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  @JsonProperty("firstName")
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @JsonProperty("phone")
  public List<ProfilePhone> getPhone() {
    return phone;
  }

  @JsonProperty("phone")
  public void setPhone(List<ProfilePhone> phone) {
    this.phone = phone;
  }

  @JsonProperty("clubCardNumber")
  public String getClubCardNumber() {
    return clubCardNumber;
  }

  @JsonProperty("clubCardNumber")
  public void setClubCardNumber(String clubCardNumber) {
    this.clubCardNumber = clubCardNumber;
  }

  @JsonProperty("customerId")
  public String getcustomerId() {
    return customerId;
  }

  @JsonProperty("customerId")
  public void setcustomerId(String customerId) {
    this.customerId = customerId;
  }

  @JsonProperty("hhid")
  public String getHhid() {
    return hhid;
  }

  @JsonProperty("hhid")
  public void setHhid(String hhid) {
    this.hhid = hhid;
  }

  @JsonProperty("alternateIds")
  public List<AlternateIds> getAlternateIds() {
    return alternateIds;
  }

  @JsonProperty("alternateIds")
  public void setAlternateIds(List<AlternateIds> alternateIds) {
    this.alternateIds = alternateIds;
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
    UpdatedProfile that = (UpdatedProfile) o;
    return java.util.Objects.equals(emailId, that.emailId)
        && java.util.Objects.equals(banner, that.banner)
        && java.util.Objects.equals(lastName, that.lastName)
        && java.util.Objects.equals(firstName, that.firstName)
        && java.util.Objects.equals(phone, that.phone)
        && java.util.Objects.equals(clubCardNumber, that.clubCardNumber)
        && java.util.Objects.equals(customerId, that.customerId)
        && java.util.Objects.equals(hhid, that.hhid)
        && java.util.Objects.equals(alternateIds, that.alternateIds)
        && Arrays.equals(links, that.links);
  }

  @Override
  public int hashCode() {

    int result =
        java.util.Objects.hash(
            emailId,
            banner,
            lastName,
            firstName,
            phone,
            clubCardNumber,
            customerId,
            hhid,
            alternateIds);
    result = 31 * result + Arrays.hashCode(links);
    return result;
  }

  @Override
  public String toString() {
    return "UpdatedProfile{"
        + "emailId='"
        + emailId
        + '\''
        + ", banner='"
        + banner
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + ", firstName='"
        + firstName
        + '\''
        + ", phone="
        + phone
        + ", clubCardNumber='"
        + clubCardNumber
        + '\''
        + ", customerId='"
        + customerId
        + '\''
        + ", hhid='"
        + hhid
        + '\''
        + ", alternateIds="
        + alternateIds
        + ", links="
        + Arrays.toString(links)
        + '}';
  }
}
