package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"code", "message"})
public class EcomTokenError {

  @JsonProperty("code")
  private String code;

  @JsonProperty("message")
  private String message;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EcomTokenError that = (EcomTokenError) o;
    return Objects.equal(code, that.code)
        && Objects.equal(message, that.message)
        && Objects.equal(additionalProperties, that.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(code, message, additionalProperties);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("code", code)
        .add("message", message)
        .add("additionalProperties", additionalProperties)
        .toString();
  }
}
