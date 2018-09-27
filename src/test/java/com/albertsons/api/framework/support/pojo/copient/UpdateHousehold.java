package com.albertsons.api.framework.support.pojo.copient;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * This class contains the pojo representation of Update Household.
 *
 * @author nisla10
 */
public class UpdateHousehold {
 
  private String message;
  private String HHID;
  private String updated;
  private String AirmileMemberID;

  @XmlAttribute(name = "message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @XmlElement(name = "HHID")
  public String getHHID() {
    return HHID;
  }

  public void setHHID(String HHID) {
    this.HHID = HHID;
  }

  @XmlAttribute(name = "updated")
  public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  @XmlElement(name = "AirmileMemberID")
  public String getAirmileMemberID() {
    return AirmileMemberID;
  }

  public void setAirmileMemberID(String AirmileMemberID) {
    this.AirmileMemberID = AirmileMemberID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UpdateHousehold that = (UpdateHousehold) o;
    return Objects.equal(message, that.message) &&
            Objects.equal(HHID, that.HHID) &&
            Objects.equal(updated, that.updated) &&
            Objects.equal(AirmileMemberID, that.AirmileMemberID);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(message, HHID, updated, AirmileMemberID);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
            .add("message", message)
            .add("HHID", HHID)
            .add("updated", updated)
            .add("AirmileMemberID", AirmileMemberID)
            .toString();
  }
}
