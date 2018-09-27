package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * Current class contains the POJO representation of Full Registration.
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "emailId",
    "password",
    "firstName",
    "lastName",
    "phone",
    "clubCardNumber",
    "zipCode",
    "rememberMe",
    "preferences",
    "addresses",
    "terms",
    "digitalReceipt"
})
public class FullRegistrationParams {
  @JsonProperty("emailId")
  private String emailId;

  @JsonProperty("password")
  private String password;

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

  @JsonProperty("preferences")
  private RegistrationPreferences preferences;

  @JsonProperty("addresses")
  private List<RegistrationAddress> addresses = null;

  @JsonProperty("terms")
  private String terms;

  @JsonProperty("digitalReceipt")
  private String digitalReceipt;

  @JsonProperty("emailId")
  public String getEmailId() {
    return emailId;
  }

  @JsonProperty("emailId")
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  @JsonProperty("password")
  public void setPassword(String password) {
    this.password = password;
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

  @JsonProperty("preferences")
  public RegistrationPreferences getPreferences() {
    return preferences;
  }

  @JsonProperty("preferences")
  public void setPreferences(RegistrationPreferences preferences) {
    this.preferences = preferences;
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

  @JsonProperty("digitalReceipt")
  public String getDigitalReceipt() {
    return digitalReceipt;
  }

  @JsonProperty("digitalReceipt")
  public void setDigitalReceipt(String digitalReceipt) {
    this.digitalReceipt = digitalReceipt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FullRegistrationParams that = (FullRegistrationParams) o;
    return Objects.equal(getEmailId(), that.getEmailId())
        && Objects.equal(getPassword(), that.getPassword())
        && Objects.equal(getFirstName(), that.getFirstName())
        && Objects.equal(getLastName(), that.getLastName())
        && Objects.equal(getPhone(), that.getPhone())
        && Objects.equal(getClubCardNumber(), that.getClubCardNumber())
        && Objects.equal(getZipCode(), that.getZipCode())
        && Objects.equal(getRememberMe(), that.getRememberMe())
        && Objects.equal(getPreferences(), that.getPreferences())
        && Objects.equal(getAddresses(), that.getAddresses())
        && Objects.equal(getTerms(), that.getTerms())
        && Objects.equal(getDigitalReceipt(), that.getDigitalReceipt());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        getEmailId(),
        getPassword(),
        getFirstName(),
        getLastName(),
        getPhone(),
        getClubCardNumber(),
        getZipCode(),
        getRememberMe(),
        getPreferences(),
        getAddresses(),
        getTerms(),
        getDigitalReceipt());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("emailId", emailId)
        .add("password", password)
        .add("firstName", firstName)
        .add("lastName", lastName)
        .add("phone", phone)
        .add("clubCardNumber", clubCardNumber)
        .add("zipCode", zipCode)
        .add("rememberMe", rememberMe)
        .add("preferences", preferences)
        .add("addresses", addresses)
        .add("terms", terms)
        .add("digitalReceipt", digitalReceipt)
        .toString();
  }
}
