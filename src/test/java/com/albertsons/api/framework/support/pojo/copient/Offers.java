package com.albertsons.api.framework.support.pojo.copient;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * This class contains the pojo representation of Offers information.
 *
 * @author nisla10
 */
public class Offers {

  private String id;
  private String operation;
  private String logixId;
  private String success;

  @XmlAttribute(name = "id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @XmlAttribute(name = "operation")
  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  @XmlAttribute(name = "logixId")
  public String getLogixId() {
    return logixId;
  }

  public void setLogixId(String logixId) {
    this.logixId = logixId;
  }

  @XmlAttribute(name = "success")
  public String getSuccess() {
    return success;
  }

  public void setSuccess(String success) {
    this.success = success;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Offers offers = (Offers) o;
    return Objects.equal(id, offers.id)
        && Objects.equal(operation, offers.operation)
        && Objects.equal(logixId, offers.logixId)
        && Objects.equal(success, offers.success);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id, operation, logixId, success);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("operation", operation)
        .add("logixId", logixId)
        .add("success", success)
        .toString();
  }
}
