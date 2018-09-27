package com.albertsons.api.framework.support.pojo.copient;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * This class contains the pojo representation of Remove Customer Attribute descriptor.
 *
 * @author nisla10
 */
public class RemoveCustomerAttribute {
  
  private String message;
  private String CardID;
  private String updated;
  private String ExtAttributeType;
  private String ExtCardTypeID;

  @XmlAttribute(name = "message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @XmlElement(name = "CardID")
  public String getCardID() {
    return CardID;
  }

  public void setCardID(String CardID) {
    this.CardID = CardID;
  }

  @XmlAttribute(name = "updated")
  public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  @XmlElement(name = "ExtAttributeType")
  public String getExtAttributeType() {
    return ExtAttributeType;
  }

  public void setExtAttributeType(String ExtAttributeType) {
    this.ExtAttributeType = ExtAttributeType;
  }

  @XmlElement(name = "ExtCardTypeID")
  public String getExtCardTypeID() {
    return ExtCardTypeID;
  }

  public void setExtCardTypeID(String ExtCardTypeID) {
    this.ExtCardTypeID = ExtCardTypeID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RemoveCustomerAttribute that = (RemoveCustomerAttribute) o;
    return Objects.equal(message, that.message) &&
            Objects.equal(CardID, that.CardID) &&
            Objects.equal(updated, that.updated) &&
            Objects.equal(ExtAttributeType, that.ExtAttributeType) &&
            Objects.equal(ExtCardTypeID, that.ExtCardTypeID);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(message, CardID, updated, ExtAttributeType, ExtCardTypeID);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
            .add("message", message)
            .add("CardID", CardID)
            .add("updated", updated)
            .add("ExtAttributeType", ExtAttributeType)
            .add("ExtCardTypeID", ExtCardTypeID)
            .toString();
  }
}
