package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * Pojo class to represent single product to update cart.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"products"})
public class CartUpdateMultiple {
  @JsonProperty("products")
  private List<CartUpdateSingle> products;

  public List<CartUpdateSingle> getProducts() {
    return products;
  }

  public void setProducts(List<CartUpdateSingle> products) {
    this.products = products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CartUpdateMultiple)) return false;
    CartUpdateMultiple that = (CartUpdateMultiple) o;
    return Objects.equal(getProducts(), that.getProducts());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getProducts());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("products", products).toString();
  }
}
