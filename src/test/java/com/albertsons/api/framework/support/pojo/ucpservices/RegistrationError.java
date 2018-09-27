package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

/**
 * Current class is POJO representation of Registration Error.
 *
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"authorization", "errors"})
public class RegistrationError {

  @JsonProperty("authorization")
  private RegistrationAuthResponse registrationAuthResponse;

  @JsonProperty("errors")
  private List<RegistrationErrorDetail> errors = null;

  @JsonProperty("authorization")
  public RegistrationAuthResponse getRegistrationAuthResponse() {
    return registrationAuthResponse;
  }

  @JsonProperty("authorization")
  public void setRegistrationAuthResponse(RegistrationAuthResponse registrationAuthResponse) {
    this.registrationAuthResponse = registrationAuthResponse;
  }

  @JsonProperty("errors")
  public List<RegistrationErrorDetail> getErrors() {
    return errors;
  }

  @JsonProperty("errors")
  public void setErrors(List<RegistrationErrorDetail> errors) {
    this.errors = errors;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrationError that = (RegistrationError) o;
    return java.util.Objects.equals(registrationAuthResponse, that.registrationAuthResponse)
        && java.util.Objects.equals(errors, that.errors);
  }

  @Override
  public int hashCode() {

    return java.util.Objects.hash(registrationAuthResponse, errors);
  }

  @Override
  public String toString() {
    return "RegistrationError{"
        + "registrationAuthResponse="
        + registrationAuthResponse
        + ", errors="
        + errors
        + '}';
  }
}
