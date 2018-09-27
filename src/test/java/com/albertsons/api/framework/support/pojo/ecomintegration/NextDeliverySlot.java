package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of next delivery slots.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"storeId", "slotId", "serviceId", "start", "end"})
public class NextDeliverySlot {
  @JsonProperty("storeId")
  private String storeId;

  @JsonProperty("slotId")
  private String slotId;

  @JsonProperty("serviceId")
  private String serviceId;

  @JsonProperty("start")
  private String start;

  @JsonProperty("end")
  private String end;

  @JsonProperty("storeId")
  public String getStoreId() {
    return storeId;
  }

  @JsonProperty("storeId")
  public void setStoreId(String storeId) {
    this.storeId = storeId;
  }

  @JsonProperty("slotId")
  public String getSlotId() {
    return slotId;
  }

  @JsonProperty("slotId")
  public void setSlotId(String slotId) {
    this.slotId = slotId;
  }

  @JsonProperty("serviceId")
  public String getServiceId() {
    return serviceId;
  }

  @JsonProperty("serviceId")
  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }

  @JsonProperty("start")
  public String getStart() {
    return start;
  }

  @JsonProperty("start")
  public void setStart(String start) {
    this.start = start;
  }

  @JsonProperty("end")
  public String getEnd() {
    return end;
  }

  @JsonProperty("end")
  public void setEnd(String end) {
    this.end = end;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof NextDeliverySlot)) return false;
    NextDeliverySlot that = (NextDeliverySlot) o;
    return Objects.equal(getStoreId(), that.getStoreId())
        && Objects.equal(getSlotId(), that.getSlotId())
        && Objects.equal(getServiceId(), that.getServiceId())
        && Objects.equal(getStart(), that.getStart())
        && Objects.equal(getEnd(), that.getEnd());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getStoreId(), getSlotId(), getServiceId(), getStart(), getEnd());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("storeId", storeId)
        .add("slotId", slotId)
        .add("serviceId", serviceId)
        .add("start", start)
        .add("end", end)
        .toString();
  }
}
