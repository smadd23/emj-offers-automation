package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of user selected delivery slot.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ack",
    "deliveryType",
    "slotId",
    "slotTypeId",
    "start",
    "end",
    "address1",
    "address2",
    "city",
    "zipcode",
    "state"
})
public class UserSelectedSlot {
  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("deliveryType")
  private String deliveryType;

  @JsonProperty("slotId")
  private Integer slotId;

  @JsonProperty("slotTypeId")
  private Integer slotTypeId;

  @JsonProperty("start")
  private String start;

  @JsonProperty("end")
  private String end;

  @JsonProperty("address1")
  private String address1;

  @JsonProperty("address2")
  private String address2;

  @JsonProperty("city")
  private String city;

  @JsonProperty("zipcode")
  private String zipcode;

  @JsonProperty("state")
  private String state;

  public Boolean getAck() {
    return ack;
  }

  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  public String getDeliveryType() {
    return deliveryType;
  }

  public void setDeliveryType(String deliveryType) {
    this.deliveryType = deliveryType;
  }

  public Integer getSlotId() {
    return slotId;
  }

  public void setSlotId(Integer slotId) {
    this.slotId = slotId;
  }

  public Integer getSlotTypeId() {
    return slotTypeId;
  }

  public void setSlotTypeId(Integer slotTypeId) {
    this.slotTypeId = slotTypeId;
  }

  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public String getEnd() {
    return end;
  }

  public void setEnd(String end) {
    this.end = end;
  }

  public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof UserSelectedSlot)) return false;
    UserSelectedSlot that = (UserSelectedSlot) o;
    return Objects.equal(getAck(), that.getAck())
        && Objects.equal(getDeliveryType(), that.getDeliveryType())
        && Objects.equal(getSlotId(), that.getSlotId())
        && Objects.equal(getSlotTypeId(), that.getSlotTypeId())
        && Objects.equal(getStart(), that.getStart())
        && Objects.equal(getEnd(), that.getEnd())
        && Objects.equal(getAddress1(), that.getAddress1())
        && Objects.equal(getAddress2(), that.getAddress2())
        && Objects.equal(getCity(), that.getCity())
        && Objects.equal(getZipcode(), that.getZipcode())
        && Objects.equal(getState(), that.getState());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        getAck(),
        getDeliveryType(),
        getSlotId(),
        getSlotTypeId(),
        getStart(),
        getEnd(),
        getAddress1(),
        getAddress2(),
        getCity(),
        getZipcode(),
        getState());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("deliveryType", deliveryType)
        .add("slotId", slotId)
        .add("slotTypeId", slotTypeId)
        .add("start", start)
        .add("end", end)
        .add("address1", address1)
        .add("address2", address2)
        .add("city", city)
        .add("zipcode", zipcode)
        .add("state", state)
        .toString();
  }
}
