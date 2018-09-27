package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/**
 * Current class is POJO representation of Session parameter.
 *
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"token", "expiresAt"})
public class RegistrationSessionToken {

  @JsonProperty("token")
  private String token;

  @JsonProperty("expiresAt")
  private String expiresAt;

  @JsonProperty("token")
  public String getToken() {
    return token;
  }

  @JsonProperty("token")
  public void setToken(String token) {
    this.token = token;
  }

  @JsonProperty("expiresAt")
  public String getExpiresAt() {
    return expiresAt;
  }

  @JsonProperty("expiresAt")
  public void setExpiresAt(String expiresAt) {
    this.expiresAt = expiresAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrationSessionToken that = (RegistrationSessionToken) o;
    return Objects.equals(token, that.token) && Objects.equals(expiresAt, that.expiresAt);
  }

  @Override
  public int hashCode() {

    return Objects.hash(token, expiresAt);
  }

  @Override
  public String toString() {
    return "RegistrationSessionToken{"
        + "token='"
        + token
        + '\''
        + ", expiresAt='"
        + expiresAt
        + '\''
        + '}';
  }
}
