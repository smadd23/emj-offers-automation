package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import java.util.List;

/**
 * This class contains the pojo representation of promotion items.
 *
 * @author vbonk00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "ack",
  "name",
  "image",
  "message",
  "products",
  "totalProducts",
  "currentPage",
  "totalPages"
})
public class PromotionItems {

  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("name")
  private Object name;

  @JsonProperty("image")
  private Object image;

  @JsonProperty("message")
  private Object message;

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

  @JsonProperty("name")
  public Object getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(Object name) {
    this.name = name;
  }

  @JsonProperty("image")
  public Object getImage() {
    return image;
  }

  @JsonProperty("image")
  public void setImage(Object image) {
    this.image = image;
  }

  @JsonProperty("message")
  public Object getMessage() {
    return message;
  }

  @JsonProperty("message")
  public void setMessage(Object message) {
    this.message = message;
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
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PromotionItems that = (PromotionItems) o;
    return com.google.common.base.Objects.equal(ack, that.ack)
        && com.google.common.base.Objects.equal(name, that.name)
        && com.google.common.base.Objects.equal(image, that.image)
        && com.google.common.base.Objects.equal(message, that.message)
        && com.google.common.base.Objects.equal(products, that.products)
        && com.google.common.base.Objects.equal(totalProducts, that.totalProducts)
        && com.google.common.base.Objects.equal(currentPage, that.currentPage)
        && com.google.common.base.Objects.equal(totalPages, that.totalPages);
  }

  @Override
  public int hashCode() {
    return com.google.common.base.Objects.hashCode(
        ack, name, image, message, products, totalProducts, currentPage, totalPages);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("name", name)
        .add("image", image)
        .add("message", message)
        .add("products", products)
        .add("totalProducts", totalProducts)
        .add("currentPage", currentPage)
        .add("totalPages", totalPages)
        .toString();
  }
}
