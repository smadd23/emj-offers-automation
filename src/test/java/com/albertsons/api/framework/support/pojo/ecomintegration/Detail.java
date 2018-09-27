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
@JsonPropertyOrder({"header", "value"})
public class Detail {

  @JsonProperty("header")
  private String header;

  @JsonProperty("value")
  private String value;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("header")
  public String getHeader() {
    return header;
  }

  @JsonProperty("header")
  public void setHeader(String header) {
    this.header = header;
  }

  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(String value) {
    this.value = value;
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
    if (!(o instanceof Detail)) return false;
    Detail detail = (Detail) o;
    return Objects.equal(header, detail.header)
        && Objects.equal(value, detail.value)
        && Objects.equal(additionalProperties, detail.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(header, value, additionalProperties);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("header", header)
        .add("value", value)
        .add("additionalProperties", additionalProperties)
        .toString();
  }
}
