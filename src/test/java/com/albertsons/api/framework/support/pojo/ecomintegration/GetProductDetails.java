package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.Map;

/**
 * This class contains the pojo representation of get product details.
 *
 * @author vbonk00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ack", "productDetail"})
public class GetProductDetails {
  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("productDetail")
  private ProductDetail productDetail;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("ack")
  public Boolean getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  @JsonProperty("productDetail")
  public ProductDetail getProductDetail() {
    return productDetail;
  }

  @JsonProperty("productDetail")
  public void setProductDetail(ProductDetail productDetail) {
    this.productDetail = productDetail;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof GetProductDetails)) return false;
    GetProductDetails that = (GetProductDetails) o;
    return Objects.equal(ack, that.ack)
        && Objects.equal(productDetail, that.productDetail)
        && Objects.equal(additionalProperties, that.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(ack, productDetail, additionalProperties);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("productDetail", productDetail)
        .add("additionalProperties", additionalProperties)
        .toString();
  }
}
