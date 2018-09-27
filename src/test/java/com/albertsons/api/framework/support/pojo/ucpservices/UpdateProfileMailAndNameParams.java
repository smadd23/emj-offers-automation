package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/**
 * Current class is POJO representation of updating profile.
 *
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "oldFirstName",
    "firstName",
    "oldLastName",
    "lastName",
    "oldEmailId",
    "emailId",
    "oldPassword",
    "newPassword"
})
public class UpdateProfileMailAndNameParams {

  @JsonProperty("oldFirstName")
  private String oldFirstName;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("oldLastName")
  private String oldLastName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("oldEmailId")
  private String oldEmailId;

  @JsonProperty("emailId")
  private String emailId;

  @JsonProperty("oldPassword")
  private String oldPassword;

  @JsonProperty("newPassword")
  private String newPassword;

  @JsonProperty("oldFirstName")
  public String getOldFirstName() {
    return oldFirstName;
  }

  @JsonProperty("oldFirstName")
  public void setOldFirstName(String oldFirstName) {
    this.oldFirstName = oldFirstName;
  }

  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  @JsonProperty("firstName")
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @JsonProperty("oldLastName")
  public String getOldLastName() {
    return oldLastName;
  }

  @JsonProperty("oldLastName")
  public void setOldLastName(String oldLastName) {
    this.oldLastName = oldLastName;
  }

  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  @JsonProperty("lastName")
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @JsonProperty("oldEmailId")
  public String getOldEmailId() {
    return oldEmailId;
  }

  @JsonProperty("oldEmailId")
  public void setOldEmailId(String oldEmailId) {
    this.oldEmailId = oldEmailId;
  }

  @JsonProperty("emailId")
  public String getEmailId() {
    return emailId;
  }

  @JsonProperty("emailId")
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  @JsonProperty("oldPassword")
  public String getOldPassword() {
    return oldPassword;
  }

  @JsonProperty("oldPassword")
  public void setOldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
  }

  @JsonProperty("newPassword")
  public String getNewPassword() {
    return newPassword;
  }

  @JsonProperty("newPassword")
  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateProfileMailAndNameParams that = (UpdateProfileMailAndNameParams) o;
    return Objects.equals(oldFirstName, that.oldFirstName)
        && Objects.equals(firstName, that.firstName)
        && Objects.equals(oldLastName, that.oldLastName)
        && Objects.equals(lastName, that.lastName)
        && Objects.equals(oldEmailId, that.oldEmailId)
        && Objects.equals(emailId, that.emailId)
        && Objects.equals(oldPassword, that.oldPassword)
        && Objects.equals(newPassword, that.newPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        oldFirstName,
        firstName,
        oldLastName,
        lastName,
        oldEmailId,
        emailId,
        oldPassword,
        newPassword);
  }

  @Override
  public String toString() {
    return "UpdateProfileMailAndNameParams{"
        + "oldFirstName='"
        + oldFirstName
        + '\''
        + ", firstName='"
        + firstName
        + '\''
        + ", oldLastName='"
        + oldLastName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + ", oldEmailId='"
        + oldEmailId
        + '\''
        + ", emailId='"
        + emailId
        + '\''
        + ", oldPassword='"
        + oldPassword
        + '\''
        + ", newPassword='"
        + newPassword
        + '\''
        + '}';
  }
}
