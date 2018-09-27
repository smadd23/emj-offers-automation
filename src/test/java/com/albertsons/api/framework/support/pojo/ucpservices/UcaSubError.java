package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Current class is POJO representation of UCA SubError.
 *
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"object", "field", "message"})
public class UcaSubError {

  @JsonProperty("object")
  private String object;

  @JsonProperty("field")
  private String field;

  @JsonProperty("message")
  private String message;

  public String getObject() {
    return object;
  }

  public void setObject(String object) {
    this.object = object;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UcaSubError that = (UcaSubError) o;
    return Objects.equal(getObject(), that.getObject())
        && Objects.equal(getField(), that.getField())
        && Objects.equal(getMessage(), that.getMessage());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getObject(), getField(), getMessage());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("object", object)
        .add("field", field)
        .add("message", message)
        .toString();
  }
}
