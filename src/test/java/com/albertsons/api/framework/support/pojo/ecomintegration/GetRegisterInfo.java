package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of Get Register Information .
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ack", "info"})
public class GetRegisterInfo {
  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("info")
  private RegInfo info;

  @JsonProperty("ack")
  public Boolean getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  @JsonProperty("info")
  public RegInfo getInfo() {
    return info;
  }

  @JsonProperty("info")
  public void setInfo(RegInfo info) {
    this.info = info;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof GetRegisterInfo)) return false;
    GetRegisterInfo that = (GetRegisterInfo) o;
    return Objects.equal(getAck(), that.getAck()) && Objects.equal(getInfo(), that.getInfo());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getAck(), getInfo());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("ack", ack).add("info", info).toString();
  }
}
