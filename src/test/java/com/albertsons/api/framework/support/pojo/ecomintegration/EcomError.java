package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.albertsons.api.framework.support.pojo.galleryservices.Error;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ack", "errors"})
public class EcomError {
  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("errors")
  private List<Error> errors = null;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("ack")
  public Boolean getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  @JsonProperty("errors")
  public List<Error> getErrors() {
    return errors;
  }

  @JsonProperty("errors")
  public void setErrors(List<Error> errors) {
    this.errors = errors;
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
    EcomError ecomError = (EcomError) o;
    return Objects.equal(ack, ecomError.ack)
        && Objects.equal(errors, ecomError.errors)
        && Objects.equal(additionalProperties, ecomError.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(ack, errors, additionalProperties);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("errors", errors)
        .add("additionalProperties", additionalProperties)
        .toString();
  }
}
