package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * This class contains the pojo representation of get next delivery slots.
 *
 * @author vkuma26
 */
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"ack", "nextDeliverySlots"})
public class GetNextDeliverySlots {

  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("nextDeliverySlots")
  private List<NextDeliverySlot> nextDeliverySlots = null;

  @JsonProperty("ack")
  public Boolean getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  @JsonProperty("nextDeliverySlots")
  public List<NextDeliverySlot> getNextDeliverySlots() {
    return nextDeliverySlots;
  }

  @JsonProperty("nextDeliverySlots")
  public void setNextDeliverySlots(List<NextDeliverySlot> nextDeliverySlots) {
    this.nextDeliverySlots = nextDeliverySlots;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof GetNextDeliverySlots)) return false;
    GetNextDeliverySlots that = (GetNextDeliverySlots) o;
    return Objects.equal(getAck(), that.getAck())
        && Objects.equal(getNextDeliverySlots(), that.getNextDeliverySlots());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getAck(), getNextDeliverySlots());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("nextDeliverySlots", nextDeliverySlots)
        .toString();
  }
}
