package com.albertsons.api.framework.support.pojo.ucpservices;

import com.albertsons.api.framework.support.pojo.ecomintegration.Links;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * This class contains the pojo representation of Profile.
 *
 * @author SKuna02
 */
@JsonInclude(Include.NON_NULL)
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
    "errors",
    "links"
})
public class Profile {

  @JsonProperty("emailId")
  private String emailId;

  @JsonProperty("banner")
  private String banner;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("phone")
  private List<PhoneProfile> phone = null;

  @JsonProperty("clubCardNumber")
  private String clubCardNumber;

  @JsonProperty("customerId")
  private String customerId;

  @JsonProperty("hhid")
  private String hhid;

  @JsonProperty("alternateIds")
  private List<AlternateId> alternateIds = null;

  @JsonProperty("errors")
  private List<RegistrationErrorDetail> errors = null;

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
  public List<PhoneProfile> getPhone() {
    return phone;
  }

  @JsonProperty("phone")
  public void setPhone(List<PhoneProfile> phone) {
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
  public String getCustomerId() {
    return customerId;
  }

  @JsonProperty("customerId")
  public void setCustomerId(String customerId) {
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
  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  @JsonProperty("alternateIds")
  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
  }

  @JsonProperty("errors")
  public List<RegistrationErrorDetail> getErrors() {
    return errors;
  }

  @JsonProperty("errors")
  public void setErrors(List<RegistrationErrorDetail> errors) {
    this.errors = errors;
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
    Profile profile = (Profile) o;
    return Objects.equals(emailId, profile.emailId)
        && Objects.equals(banner, profile.banner)
        && Objects.equals(lastName, profile.lastName)
        && Objects.equals(firstName, profile.firstName)
        && Objects.equals(phone, profile.phone)
        && Objects.equals(clubCardNumber, profile.clubCardNumber)
        && Objects.equals(customerId, profile.customerId)
        && Objects.equals(hhid, profile.hhid)
        && Objects.equals(alternateIds, profile.alternateIds)
        && Objects.equals(errors, profile.errors)
        && Arrays.equals(links, profile.links);
  }

  @Override
  public int hashCode() {

    int result =
        Objects.hash(
            emailId,
            banner,
            lastName,
            firstName,
            phone,
            clubCardNumber,
            customerId,
            hhid,
            alternateIds,
            errors);
    result = 31 * result + Arrays.hashCode(links);
    return result;
  }

  @Override
  public String toString() {
    return "Profile{"
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
        + ", errors="
        + errors
        + ", links="
        + Arrays.toString(links)
        + '}';
  }
}
