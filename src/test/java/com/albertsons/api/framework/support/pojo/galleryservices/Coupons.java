package com.albertsons.api.framework.support.pojo.galleryservices;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Class with pojo representation of pd offer type.
 *
 * @author mdeen04
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"mf", "pd"})
public class Coupons {
  @JsonProperty("mf")
  private List<Offer> mf = null;

  @JsonProperty("pd")
  private List<Offer> pd = null;

  @JsonProperty("pd")
  public List<Offer> getPd() {
    return pd;
  }

  @JsonProperty("pd")
  public void setPd(List<Offer> pd) {
    this.pd = pd;
  }

  @JsonProperty("mf")
  public List<Offer> getMf() {
    return mf;
  }

  @JsonProperty("mf")
  public void setMf(List<Offer> mf) {
    this.mf = mf;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((pd == null) ? 0 : pd.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (!(obj instanceof Coupons)) return false;
    Coupons other = (Coupons) obj;
    if (pd == null) {
      if (other.pd != null) return false;
    } else if (!pd.equals(other.pd)) return false;
    return true;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder
        .append("PdOffer [pd=")
        .append(pd)
        .append(", getPd()=")
        .append(getPd())
        .append(", hashCode()=")
        .append(hashCode())
        .append(", getClass()=")
        .append(getClass())
        .append(", toString()=")
        .append(super.toString())
        .append("]");
    return builder.toString();
  }
}
