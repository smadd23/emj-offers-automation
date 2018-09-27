package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * This class contains the pojo representation of substitution List from the cart.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ack", "substitutions"})
public class SubstitutionList {

  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("substitutions")
  private List<Substitution> substitutions = null;

  @JsonProperty("ack")
  public Boolean getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  @JsonProperty("substitutions")
  public List<Substitution> getSubstitutions() {
    return substitutions;
  }

  @JsonProperty("substitutions")
  public void setSubstitutions(List<Substitution> substitutions) {
    this.substitutions = substitutions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SubstitutionList)) return false;
    SubstitutionList that = (SubstitutionList) o;
    return Objects.equal(getAck(), that.getAck())
        && Objects.equal(getSubstitutions(), that.getSubstitutions());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getAck(), getSubstitutions());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("substitutions", substitutions)
        .toString();
  }
}
