package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation ecom message.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ack", "message"})
public class EcomMessage {

  @JsonProperty("ack")
  private String ack;

  @JsonProperty("message")
  private String message;

  @JsonProperty("ack")
  public String getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(String ack) {
    this.ack = ack;
  }

  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  @JsonProperty("message")
  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof EcomMessage)) return false;
    EcomMessage that = (EcomMessage) o;
    return Objects.equal(getAck(), that.getAck()) && Objects.equal(getMessage(), that.getMessage());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getAck(), getMessage());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("ack", ack).add("message", message).toString();
  }
}
