package com.albertsons.api.framework.support.pojo.copient;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * This class contains the pojo representation of Update Customer Attribute.
 *
 * @author nisla10
 */
public class UpdateCustomerAttribute {
  
  private String message;
  private String CardID;
  private String updated;
  private String ExtAttributeType;
  private String ExtAttributeValue;
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

  @XmlAttribute(name = "ExtAttributeValue")
  public String getExtAttributeValue() {
    return ExtAttributeValue;
  }

  public void setExtAttributeValue(String ExtAttributeValue) {
    this.ExtAttributeValue = ExtAttributeValue;
  }

  @XmlAttribute(name = "ExtCardTypeID")
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
    UpdateCustomerAttribute that = (UpdateCustomerAttribute) o;
    return Objects.equal(message, that.message) &&
            Objects.equal(CardID, that.CardID) &&
            Objects.equal(updated, that.updated) &&
            Objects.equal(ExtAttributeType, that.ExtAttributeType) &&
            Objects.equal(ExtAttributeValue, that.ExtAttributeValue) &&
            Objects.equal(ExtCardTypeID, that.ExtCardTypeID);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(message, CardID, updated, ExtAttributeType, ExtAttributeValue, ExtCardTypeID);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
            .add("message", message)
            .add("CardID", CardID)
            .add("updated", updated)
            .add("ExtAttributeType", ExtAttributeType)
            .add("ExtAttributeValue", ExtAttributeValue)
            .add("ExtCardTypeID", ExtCardTypeID)
            .toString();
  }
}
