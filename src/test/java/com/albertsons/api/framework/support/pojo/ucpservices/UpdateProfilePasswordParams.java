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
@JsonPropertyOrder({"emailId", "password", "oldPassword"})
public class UpdateProfilePasswordParams {

  @JsonProperty("emailId")
  private String emailId;

  @JsonProperty("password")
  private String password;

  @JsonProperty("oldPassword")
  private String oldPassword;

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

  @JsonProperty("oldPassword")
  public String getOldPassword() {
    return oldPassword;
  }

  @JsonProperty("oldPassword")
  public void setOldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateProfilePasswordParams that = (UpdateProfilePasswordParams) o;
    return Objects.equals(emailId, that.emailId)
        && Objects.equals(password, that.password)
        && Objects.equals(oldPassword, that.oldPassword);
  }

  @Override
  public int hashCode() {

    return Objects.hash(emailId, password, oldPassword);
  }

  @Override
  public String toString() {
    return "UpdateProfilePasswordParams{"
        + "emailId='"
        + emailId
        + '\''
        + ", password='"
        + password
        + '\''
        + ", oldPassword='"
        + oldPassword
        + '\''
        + '}';
  }
}
