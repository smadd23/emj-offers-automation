package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of delivery slot.
 *
 * @author vbonk00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "group", "start", "end", "type"})
public class DeliverySlot {

  @JsonProperty("id")
  private Object id = null;

  @JsonProperty("group")
  private Integer group = 0;

  @JsonProperty("start")
  private String start = "";

  @JsonProperty("end")
  private String end = "";

  @JsonProperty("type")
  private Integer type = 0;

  @JsonProperty("id")
  public Object getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Object id) {
    this.id = id;
  }

  @JsonProperty("group")
  public Integer getGroup() {
    return group;
  }

  @JsonProperty("group")
  public void setGroup(Integer group) {
    this.group = group;
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

  @JsonProperty("type")
  public Integer getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(Integer type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DeliverySlot that = (DeliverySlot) o;
    return Objects.equal(id, that.id)
        && Objects.equal(group, that.group)
        && Objects.equal(start, that.start)
        && Objects.equal(end, that.end)
        && Objects.equal(type, that.type);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id, group, start, end, type);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("group", group)
        .add("start", start)
        .add("end", end)
        .add("type", type)
        .toString();
  }
}
