package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Current POJO class is representation of Registration error list detail.
 *
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"code", "message", "fieldName"})
public class RegistrationErrorDetail {

  @JsonProperty("code")
  private String code;

  @JsonProperty("message")
  private String message;

  @JsonProperty("fieldName")
  private String fieldName;

  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  @JsonProperty("code")
  public void setCode(String code) {
    this.code = code;
  }

  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  @JsonProperty("message")
  public void setMessage(String message) {
    this.message = message;
  }

  @JsonProperty("fieldName")
  public String getFieldName() {
    return fieldName;
  }

  @JsonProperty("fieldName")
  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrationErrorDetail that = (RegistrationErrorDetail) o;
    return java.util.Objects.equals(code, that.code)
        && java.util.Objects.equals(message, that.message)
        && java.util.Objects.equals(fieldName, that.fieldName);
  }

  @Override
  public int hashCode() {

    return java.util.Objects.hash(code, message, fieldName);
  }

  @Override
  public String toString() {
    return "RegistrationErrorDetail{"
        + "code='"
        + code
        + '\''
        + ", message='"
        + message
        + '\''
        + ", fieldName='"
        + fieldName
        + '\''
        + '}';
  }
}
