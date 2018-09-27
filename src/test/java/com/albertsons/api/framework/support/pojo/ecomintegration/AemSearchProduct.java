package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * This class is Pojo representation of Product Details returned by AEM Search.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ack",
    "brands",
    "aisles",
    "productsinfo",
    "totalProducts",
    "currentPage",
    "totalPages",
    "errors"
})
public class AemSearchProduct {
  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("brands")
  private List<String> brands = null;

  @JsonProperty("aisles")
  private List<String> aisles = null;

  @JsonProperty("productsinfo")
  private List<ProductsInfo> productsinfo = null;

  @JsonProperty("totalProducts")
  private Integer totalProducts;

  @JsonProperty("currentPage")
  private Integer currentPage;

  @JsonProperty("totalPages")
  private Integer totalPages;

  @JsonProperty("errors")
  private List<EcomError> errors;

  public Boolean getAck() {
    return ack;
  }

  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  public List<String> getBrands() {
    return brands;
  }

  public void setBrands(List<String> brands) {
    this.brands = brands;
  }

  public List<String> getAisles() {
    return aisles;
  }

  public void setAisles(List<String> aisles) {
    this.aisles = aisles;
  }

  public List<ProductsInfo> getProductsinfo() {
    return productsinfo;
  }

  public void setProductsinfo(List<ProductsInfo> productsinfo) {
    this.productsinfo = productsinfo;
  }

  public Integer getTotalProducts() {
    return totalProducts;
  }

  public void setTotalProducts(Integer totalProducts) {
    this.totalProducts = totalProducts;
  }

  public Integer getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
  }

  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public List<EcomError> getErrors() {
    return errors;
  }

  public void setErrors(List<EcomError> errors) {
    this.errors = errors;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof AemSearchProduct)) return false;
    AemSearchProduct that = (AemSearchProduct) o;
    return Objects.equal(getAck(), that.getAck())
        && Objects.equal(getBrands(), that.getBrands())
        && Objects.equal(getAisles(), that.getAisles())
        && Objects.equal(getProductsinfo(), that.getProductsinfo())
        && Objects.equal(getTotalProducts(), that.getTotalProducts())
        && Objects.equal(getCurrentPage(), that.getCurrentPage())
        && Objects.equal(getTotalPages(), that.getTotalPages())
        && Objects.equal(getErrors(), that.getErrors());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        getAck(),
        getBrands(),
        getAisles(),
        getProductsinfo(),
        getTotalProducts(),
        getCurrentPage(),
        getTotalPages(),
        getErrors());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("brands", brands)
        .add("aisles", aisles)
        .add("productsinfo", productsinfo)
        .add("totalProducts", totalProducts)
        .add("currentPage", currentPage)
        .add("totalPages", totalPages)
        .add("errors", errors)
        .toString();
  }
}
