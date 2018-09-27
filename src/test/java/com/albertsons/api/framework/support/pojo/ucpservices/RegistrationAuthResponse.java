package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/**
 * Current class is POJO representation of Registration authorization.
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"sessionToken"})
public class RegistrationAuthResponse {

  @JsonProperty("sessionToken")
  private RegistrationSessionToken sessionToken;

  @JsonProperty("sessionToken")
  public RegistrationSessionToken getSessionToken() {
    return sessionToken;
  }

  @JsonProperty("sessionToken")
  public void setSessionToken(RegistrationSessionToken sessionToken) {
    this.sessionToken = sessionToken;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrationAuthResponse that = (RegistrationAuthResponse) o;
    return Objects.equals(sessionToken, that.sessionToken);
  }

  @Override
  public int hashCode() {

    return Objects.hash(sessionToken);
  }

  @Override
  public String toString() {
    return "RegistrationAuthResponse{" + "sessionToken=" + sessionToken + '}';
  }
}
