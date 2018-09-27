package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * This class contains the pojo representation of product details by self.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ack", "products", "totalProducts", "currentPage", "totalPages"})
public class ProductsByShelf {
  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("products")
  private List<Product> products = null;

  @JsonProperty("totalProducts")
  private Integer totalProducts;

  @JsonProperty("currentPage")
  private Integer currentPage;

  @JsonProperty("totalPages")
  private Integer totalPages;

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

  @JsonProperty("totalProducts")
  public Integer getTotalProducts() {
    return totalProducts;
  }

  @JsonProperty("totalProducts")
  public void setTotalProducts(Integer totalProducts) {
    this.totalProducts = totalProducts;
  }

  @JsonProperty("currentPage")
  public Integer getCurrentPage() {
    return currentPage;
  }

  @JsonProperty("currentPage")
  public void setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
  }

  @JsonProperty("totalPages")
  public Integer getTotalPages() {
    return totalPages;
  }

  @JsonProperty("totalPages")
  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ProductsByShelf)) return false;
    ProductsByShelf that = (ProductsByShelf) o;
    return Objects.equal(getAck(), that.getAck())
        && Objects.equal(getProducts(), that.getProducts())
        && Objects.equal(getTotalProducts(), that.getTotalProducts())
        && Objects.equal(getCurrentPage(), that.getCurrentPage())
        && Objects.equal(getTotalPages(), that.getTotalPages());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        getAck(), getProducts(), getTotalProducts(), getCurrentPage(), getTotalPages());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("products", products)
        .add("totalProducts", totalProducts)
        .add("currentPage", currentPage)
        .add("totalPages", totalPages)
        .toString();
  }
}
