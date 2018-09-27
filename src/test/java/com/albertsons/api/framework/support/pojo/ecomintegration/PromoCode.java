package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of a single promo code details.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"code", "description"})
public class PromoCode {
  @JsonProperty("code")
  private String code;

  @JsonProperty("description")
  private String description;

  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  @JsonProperty("code")
  public void setCode(String code) {
    this.code = code;
  }

  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  @JsonProperty("description")
  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PromoCode)) return false;
    PromoCode promoCode = (PromoCode) o;
    return Objects.equal(getCode(), promoCode.getCode())
        && Objects.equal(getDescription(), promoCode.getDescription());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getCode(), getDescription());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("code", code)
        .add("description", description)
        .toString();
  }
}
