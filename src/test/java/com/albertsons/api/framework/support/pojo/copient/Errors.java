package com.albertsons.api.framework.support.pojo.copient;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * This class contains the pojo representation of Error descriptor.
 *
 * @author nisla10
 */
public class Errors {
  
  private String message;
  private String code;

  @XmlAttribute(name = "message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @XmlAttribute(name = "code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Errors errors = (Errors) o;
    return Objects.equal(message, errors.message) &&
            Objects.equal(code, errors.code);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(message, code);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
            .add("message", message)
            .add("code", code)
            .toString();
  }
}
