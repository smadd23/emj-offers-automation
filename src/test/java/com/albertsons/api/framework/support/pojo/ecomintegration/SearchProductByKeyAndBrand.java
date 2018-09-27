package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import java.util.List;
/** Created by vkuma26 Pojo class to represent Searched Product List object. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ack", "products"})
public class SearchProductByKeyAndBrand {
  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("products")
  private List<Product> products = null;

  @JsonProperty("ack")
  public Boolean getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  @JsonProperty("products")
  public List<Product> getProducts() {
    return products;
  }

  @JsonProperty("products")
  public void setProducts(List<Product> products) {
    this.products = products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SearchProductByKeyAndBrand that = (SearchProductByKeyAndBrand) o;
    return java.util.Objects.equals(ack, that.ack)
        && java.util.Objects.equals(products, that.products);
  }

  @Override
  public int hashCode() {

    return java.util.Objects.hash(ack, products);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("ack", ack).add("products", products).toString();
  }
}
