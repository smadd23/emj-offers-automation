package com.albertsons.api.framework.support.pojo.galleryservices;

import com.albertsons.api.framework.support.pojo.galleryservices.Error;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

/**
 * This class contains the pojo representation of error descriptor.
 *
 * @author mdeen04
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"errors"})
public class ErrorDescriptor {

  @JsonProperty("errors")
  private List<Error> errors = null;

  @JsonProperty("errors")
  public List<Error> getErrors() {
    return errors;
  }

  @JsonProperty("errors")
  public void setErrors(List<Error> errors) {
    this.errors = errors;
  }
}
