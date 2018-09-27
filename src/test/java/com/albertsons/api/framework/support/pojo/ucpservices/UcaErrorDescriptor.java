package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * This class contains the pojo representation of error descriptor.
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UcaErrorDescriptor {

  private UcaError ucaErrors = null;

  public UcaError getErrors() {
    return ucaErrors;
  }

  public void setErrors(UcaError authErrors) {
    this.ucaErrors = authErrors;
  }
}
