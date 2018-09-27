package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * Current class contains the POJO representation of Delta Registration.
 *
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "emailId",
    "firstName",
    "lastName",
    "phone",
    "clubCardNumber",
    "zipCode",
    "rememberMe",
    "addresses",
    "terms"
})
public class DeltaRegistrationParams {

  @JsonProperty("emailId")
  private String emailId;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("phone")
  private List<Phone> phone = null;

  @JsonProperty("clubCardNumber")
  private String clubCardNumber;

  @JsonProperty("zipCode")
  private String zipCode;

  @JsonProperty("rememberMe")
  private String rememberMe;

  @JsonProperty("addresses")
  private List<RegistrationAddress> addresses = null;

  @JsonProperty("terms")
  private String terms;

  @JsonProperty("emailId")
  public String getEmailId() {
    return emailId;
  }

  @JsonProperty("emailId")
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  @JsonProperty("firstName")
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  @JsonProperty("lastName")
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @JsonProperty("phone")
  public List<Phone> getPhone() {
    return phone;
  }

  @JsonProperty("phone")
  public void setPhone(List<Phone> phone) {
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

  @JsonProperty("zipCode")
  public String getZipCode() {
    return zipCode;
  }

  @JsonProperty("zipCode")
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  @JsonProperty("rememberMe")
  public String getRememberMe() {
    return rememberMe;
  }

  @JsonProperty("rememberMe")
  public void setRememberMe(String rememberMe) {
    this.rememberMe = rememberMe;
  }

  @JsonProperty("addresses")
  public List<RegistrationAddress> getAddresses() {
    return addresses;
  }

  @JsonProperty("addresses")
  public void setAddresses(List<RegistrationAddress> addresses) {
    this.addresses = addresses;
  }

  @JsonProperty("terms")
  public String getTerms() {
    return terms;
  }

  @JsonProperty("terms")
  public void setTerms(String terms) {
    this.terms = terms;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeltaRegistrationParams that = (DeltaRegistrationParams) o;
    return Objects.equal(emailId, that.emailId)
        && Objects.equal(firstName, that.firstName)
        && Objects.equal(lastName, that.lastName)
        && Objects.equal(phone, that.phone)
        && Objects.equal(clubCardNumber, that.clubCardNumber)
        && Objects.equal(zipCode, that.zipCode)
        && Objects.equal(rememberMe, that.rememberMe)
        && Objects.equal(addresses, that.addresses)
        && Objects.equal(terms, that.terms);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        emailId, firstName, lastName, phone, clubCardNumber, zipCode, rememberMe, addresses, terms);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("emailId", emailId)
        .add("firstName", firstName)
        .add("lastName", lastName)
        .add("phone", phone)
        .add("clubCardNumber", clubCardNumber)
        .add("zipCode", zipCode)
        .add("rememberMe", rememberMe)
        .add("addresses", addresses)
        .add("terms", terms)
        .toString();
  }
}
