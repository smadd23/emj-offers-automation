package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import java.util.Objects;

/**
 * This class contains the pojo representation of error.
 *
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"status", "error", "errorCode", "message", "debugMessage", "subErrors"})
public class UcaError {

  @JsonProperty("status")
  private String status;

  @JsonProperty("error")
  private String error;

  @JsonProperty("errorCode")
  private String errorCode;

  @JsonProperty("message")
  private String message;

  @JsonProperty("debugMessage")
  private String debugMessage;

  @JsonProperty("subErrors")
  private List<UcaSubError> subErrors = null;

  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(String httpStatus) {
    this.status = httpStatus;
  }

  @JsonProperty("error")
  public String getError() {
    return error;
  }

  @JsonProperty("error")
  public void setError(String error) {
    this.error = error;
  }

  @JsonProperty("errorCode")
  public String getErrorCode() {
    return errorCode;
  }

  @JsonProperty("errorCode")
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  @JsonProperty("message")
  public void setMessage(String message) {
    this.message = message;
  }

  @JsonProperty("debugMessage")
  public String getDebugMessage() {
    return debugMessage;
  }

  @JsonProperty("debugMessage")
  public void setDebugMessage(String debugMessage) {
    this.debugMessage = debugMessage;
  }

  @JsonProperty("subErrors")
  public List<UcaSubError> getSubErrors() {
    return subErrors;
  }

  @JsonProperty("subErrors")
  public void setSubErrors(List<UcaSubError> subErrors) {
    this.subErrors = subErrors;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UcaError ucaError = (UcaError) o;
    return Objects.equals(status, ucaError.status)
        && Objects.equals(error, ucaError.error)
        && Objects.equals(errorCode, ucaError.errorCode)
        && Objects.equals(message, ucaError.message)
        && Objects.equals(debugMessage, ucaError.debugMessage)
        && Objects.equals(subErrors, ucaError.subErrors);
  }

  @Override
  public int hashCode() {

    return Objects.hash(status, error, errorCode, message, debugMessage, subErrors);
  }

  @Override
  public String toString() {
    return "UcaError{"
        + "status='"
        + status
        + '\''
        + ", error='"
        + error
        + '\''
        + ", errorCode='"
        + errorCode
        + '\''
        + ", message='"
        + message
        + '\''
        + ", debugMessage='"
        + debugMessage
        + '\''
        + ", subErrors="
        + subErrors
        + '}';
  }
}
