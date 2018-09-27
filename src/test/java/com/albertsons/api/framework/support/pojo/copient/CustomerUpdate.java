package com.albertsons.api.framework.support.pojo.copient;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class contains the pojo representation of Customer update.
 * @author nisla10
 */
@XmlRootElement(name = "CustomerUpdate")
public class CustomerUpdate {
  
  private String returnCode;
  private String Message;
  private UpdateCustomerAttribute UpdateCustomerAttribute;
  private UpdateHousehold UpdateHousehold;
  private RemoveCustomerAttribute RemoveCustomerAttribute;

  @XmlAttribute(name = "returnCode")
  public String getReturnCode() {
    return returnCode;
  }
  public void setReturnCode(String returnCode) {
    this.returnCode = returnCode;
  }

  @XmlElement(name = "Message")
  public String getMessage() {
    return Message;
  }
  public void setMessage(String message) {
    Message = message;
  }
  @XmlElement(name = "UpdateCustomerAttribute")
  public UpdateCustomerAttribute getUpdateCustomerAttribute() {
    return UpdateCustomerAttribute;
  }

  public void setUpdateCustomerAttribute(UpdateCustomerAttribute UpdateCustomerAttribute) {
    this.UpdateCustomerAttribute = UpdateCustomerAttribute;
  }

  @XmlElement(name = "UpdateHousehold")
  public UpdateHousehold getUpdateHousehold() {
    return UpdateHousehold;
  }
  public void setUpdateHousehold(UpdateHousehold updateHousehold) {
    UpdateHousehold = updateHousehold;
  }

  @XmlElement(name = "RemoveCustomerAttribute")
  public RemoveCustomerAttribute getRemoveCustomerAttribute() {
    return RemoveCustomerAttribute;
  }
  public void setRemoveCustomerAttribute(RemoveCustomerAttribute removeCustomerAttribute) {
    RemoveCustomerAttribute = removeCustomerAttribute;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CustomerUpdate that = (CustomerUpdate) o;
    return Objects.equal(returnCode, that.returnCode) &&
            Objects.equal(Message, that.Message) &&
            Objects.equal(UpdateCustomerAttribute, that.UpdateCustomerAttribute) &&
            Objects.equal(UpdateHousehold, that.UpdateHousehold) &&
            Objects.equal(RemoveCustomerAttribute, that.RemoveCustomerAttribute);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(returnCode, Message, UpdateCustomerAttribute, UpdateHousehold, RemoveCustomerAttribute);
  }
  
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
            .add("returnCode", returnCode)
            .add("Message", Message)
            .add("UpdateCustomerAttribute", UpdateCustomerAttribute)
            .add("UpdateHousehold", UpdateHousehold)

            .add("RemoveCustomerAttribute", RemoveCustomerAttribute)
            .toString();
  }
}

