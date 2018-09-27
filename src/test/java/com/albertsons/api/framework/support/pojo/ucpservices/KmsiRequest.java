package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.Map;


/**
 * Current class contains the POJO representation of Kmsi Request.
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "emailId",
    "password"
})
public class KmsiRequest  {

  @JsonProperty("emailId")
  private String emailId;

  @JsonProperty("password")
  private String password;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KmsiRequest that = (KmsiRequest) o;
    return Objects.equal(getEmailId(), that.getEmailId()) &&
        Objects.equal(getPassword(), that.getPassword());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getEmailId(), getPassword());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("emailId", emailId)
        .add("password", password)
        .toString();
  }
}