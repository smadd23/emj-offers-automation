package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * This class contains the pojo representation of delivery For guest.
 *
 * @author vbonk00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "ack",
  "deliverySlots",
  "deliveryType",
  "unAttendedDelivery2HourMessage",
  "unAttendedDelivery4HourMessage"
})
public class DeliveryForGuest {

  @JsonProperty("ack")
  private Boolean ack = false;

  @JsonProperty("deliverySlots")
  private List<DeliverySlot> deliverySlots = null;

  @JsonProperty("deliveryType")
  private Object deliveryType = null;

  @JsonProperty("unAttendedDelivery2HourMessage")
  private Object unAttendedDelivery2HourMessage = null;

  @JsonProperty("unAttendedDelivery4HourMessage")
  private Object unAttendedDelivery4HourMessage = null;

  @JsonProperty("ack")
  public Boolean getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  @JsonProperty("deliverySlots")
  public List<DeliverySlot> getDeliverySlots() {
    return deliverySlots;
  }

  @JsonProperty("deliverySlots")
  public void setDeliverySlots(List<DeliverySlot> deliverySlots) {
    this.deliverySlots = deliverySlots;
  }

  @JsonProperty("deliveryType")
  public Object getDeliveryType() {
    return deliveryType;
  }

  @JsonProperty("deliveryType")
  public void setDeliveryType(Object deliveryType) {
    this.deliveryType = deliveryType;
  }

  @JsonProperty("unAttendedDelivery2HourMessage")
  public Object getUnAttendedDelivery2HourMessage() {
    return unAttendedDelivery2HourMessage;
  }

  @JsonProperty("unAttendedDelivery2HourMessage")
  public void setUnAttendedDelivery2HourMessage(Object unAttendedDelivery2HourMessage) {
    this.unAttendedDelivery2HourMessage = unAttendedDelivery2HourMessage;
  }

  @JsonProperty("unAttendedDelivery4HourMessage")
  public Object getUnAttendedDelivery4HourMessage() {
    return unAttendedDelivery4HourMessage;
  }

  @JsonProperty("unAttendedDelivery4HourMessage")
  public void setUnAttendedDelivery4HourMessage(Object unAttendedDelivery4HourMessage) {
    this.unAttendedDelivery4HourMessage = unAttendedDelivery4HourMessage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DeliveryForGuest that = (DeliveryForGuest) o;
    return Objects.equal(ack, that.ack)
        && Objects.equal(deliverySlots, that.deliverySlots)
        && Objects.equal(deliveryType, that.deliveryType)
        && Objects.equal(unAttendedDelivery2HourMessage, that.unAttendedDelivery2HourMessage)
        && Objects.equal(unAttendedDelivery4HourMessage, that.unAttendedDelivery4HourMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        ack,
        deliverySlots,
        deliveryType,
        unAttendedDelivery2HourMessage,
        unAttendedDelivery4HourMessage);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("deliverySlots", deliverySlots)
        .add("deliveryType", deliveryType)
        .add("unAttendedDelivery2HourMessage", unAttendedDelivery2HourMessage)
        .add("unAttendedDelivery4HourMessage", unAttendedDelivery4HourMessage)
        .toString();
  }
}
