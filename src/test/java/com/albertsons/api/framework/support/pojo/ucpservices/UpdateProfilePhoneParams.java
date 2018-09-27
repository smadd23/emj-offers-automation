package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/**
 * Current class contains the POJO representation of updating of Profile Phone Params.
 *
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"oldPhone", "phone", "emailId"})
public class UpdateProfilePhoneParams {

  @JsonProperty("oldPhone")
  private PhoneProfile oldPhone;

  @JsonProperty("phone")
  private PhoneProfile phone;

  @JsonProperty("emailId")
  private String emailId;

  @JsonProperty("oldPhone")
  public PhoneProfile getOldPhone() {
    return oldPhone;
  }

  @JsonProperty("oldPhone")
  public void setOldPhone(PhoneProfile oldPhone) {
    this.oldPhone = oldPhone;
  }

  @JsonProperty("phone")
  public PhoneProfile getPhone() {
    return phone;
  }

  @JsonProperty("phone")
  public void setPhone(PhoneProfile phone) {
    this.phone = phone;
  }

  @JsonProperty("emailId")
  public String getEmailId() {
    return emailId;
  }

  @JsonProperty("emailId")
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateProfilePhoneParams that = (UpdateProfilePhoneParams) o;
    return Objects.equals(oldPhone, that.oldPhone)
        && Objects.equals(phone, that.phone)
        && Objects.equals(emailId, that.emailId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(oldPhone, phone, emailId);
  }

  @Override
  public String toString() {
    return "UpdateProfilePhoneParams{"
        + "oldPhone="
        + oldPhone
        + ", phone="
        + phone
        + ", emailId='"
        + emailId
        + '\''
        + '}';
  }
}
