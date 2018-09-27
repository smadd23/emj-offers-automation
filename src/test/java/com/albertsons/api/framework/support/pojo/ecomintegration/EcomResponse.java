package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ack", "products"})
public class EcomResponse {

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
    EcomResponse ecomResponse = (EcomResponse) o;
    return Objects.equal(ack, ecomResponse.ack) && Objects.equal(products, ecomResponse.products);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(ack, products);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("ack", ack).add("products", products).toString();
  }
}
