package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * Pojo class to represent BPN product list using POST method.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ack",
    "name",
    "image",
    "message",
    "totalProducts",
    "currentPage",
    "totalPages",
    "productsinfo"
})
public class ProductsByBpn {
  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("name")
  private Object name;

  @JsonProperty("image")
  private Object image;

  @JsonProperty("message")
  private Object message;

  @JsonProperty("totalProducts")
  private Integer totalProducts;

  @JsonProperty("currentPage")
  private Integer currentPage;

  @JsonProperty("totalPages")
  private Integer totalPages;

  @JsonProperty("productsinfo")
  private List<BpnProductInfo> productsinfo = null;

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

  @JsonProperty("productsinfo")
  public List<BpnProductInfo> getProductsinfo() {
    return productsinfo;
  }

  @JsonProperty("productsinfo")
  public void setProductsinfo(List<BpnProductInfo> productsinfo) {
    this.productsinfo = productsinfo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ProductsByBpn)) return false;
    ProductsByBpn that = (ProductsByBpn) o;
    return Objects.equal(getAck(), that.getAck())
        && Objects.equal(getName(), that.getName())
        && Objects.equal(getImage(), that.getImage())
        && Objects.equal(getMessage(), that.getMessage())
        && Objects.equal(getTotalProducts(), that.getTotalProducts())
        && Objects.equal(getCurrentPage(), that.getCurrentPage())
        && Objects.equal(getTotalPages(), that.getTotalPages())
        && Objects.equal(getProductsinfo(), that.getProductsinfo());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        getAck(),
        getName(),
        getImage(),
        getMessage(),
        getTotalProducts(),
        getCurrentPage(),
        getTotalPages(),
        getProductsinfo());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("name", name)
        .add("image", image)
        .add("message", message)
        .add("totalProducts", totalProducts)
        .add("currentPage", currentPage)
        .add("totalPages", totalPages)
        .add("productsinfo", productsinfo)
        .toString();
  }
}
