package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import java.util.List;

/**
 * This class contains the pojo representation of promo code deals.
 *
 * <p>Created by vbonk00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ack", "promos"})
public class PromoCodeDeals {

  @JsonProperty("ack")
  private Boolean ack = false;

  @JsonProperty("promos")
  private List<Promo> promos = null;

  @JsonProperty("ack")
  public Boolean getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  @JsonProperty("promos")
  public List<Promo> getPromos() {
    return promos;
  }

  @JsonProperty("promos")
  public void setPromos(List<Promo> promos) {
    this.promos = promos;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("ack", ack).add("promos", promos).toString();
  }
}
