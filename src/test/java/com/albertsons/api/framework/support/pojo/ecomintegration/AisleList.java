package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import java.util.List;
import java.util.Objects;

/**
 * Pojo class to represent AisleList object.
 *
 * @author vbonk00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ack", "aisles"})
public class AisleList {

  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("aisles")
  private List<Aisle> aisles = null;

  @JsonProperty("ack")
  public Boolean getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  @JsonProperty("aisles")
  public List<Aisle> getAisles() {
    return aisles;
  }

  @JsonProperty("aisles")
  public void setAisles(List<Aisle> aisles) {
    this.aisles = aisles;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AisleList aisleList = (AisleList) o;
    return Objects.equals(ack, aisleList.ack) && Objects.equals(aisles, aisleList.aisles);
  }

  @Override
  public int hashCode() {

    return Objects.hash(ack, aisles);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("ack", ack).add("aisles", aisles).toString();
  }
}
