package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * Pojo class to represent club card specials object.
 *
 * <p>Created by vbonk00.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "ack",
  "totalProducts",
  "currentPage",
  "totalPages",
  "brands",
  "aisles",
  "productsinfo"
})
public class ClubCardSpecials {

  @JsonProperty("ack")
  private Boolean ack;

  @JsonProperty("totalProducts")
  private Integer totalProducts;

  @JsonProperty("currentPage")
  private Integer currentPage;

  @JsonProperty("totalPages")
  private Integer totalPages;

  @JsonProperty("brands")
  private Object brands;

  @JsonProperty("aisles")
  private Object aisles;

  @JsonProperty("productsinfo")
  private List<ProductsInfo> productsInfo = null;

  @JsonProperty("ack")
  public Boolean getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(Boolean ack) {
    this.ack = ack;
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

  @JsonProperty("brands")
  public Object getBrands() {
    return brands;
  }

  @JsonProperty("brands")
  public void setBrands(Object brands) {
    this.brands = brands;
  }

  @JsonProperty("aisles")
  public Object getAisles() {
    return aisles;
  }

  @JsonProperty("aisles")
  public void setAisles(Object aisles) {
    this.aisles = aisles;
  }

  @JsonProperty("productsinfo")
  public List<ProductsInfo> getProductsInfo() {
    return productsInfo;
  }

  @JsonProperty("productsinfo")
  public void setProductsInfo(List<ProductsInfo> productsInfo) {
    this.productsInfo = productsInfo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClubCardSpecials that = (ClubCardSpecials) o;
    return Objects.equal(ack, that.ack)
        && Objects.equal(totalProducts, that.totalProducts)
        && Objects.equal(currentPage, that.currentPage)
        && Objects.equal(totalPages, that.totalPages)
        && Objects.equal(brands, that.brands)
        && Objects.equal(aisles, that.aisles)
        && Objects.equal(productsInfo, that.productsInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        ack, totalProducts, currentPage, totalPages, brands, aisles, productsInfo);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("totalProducts", totalProducts)
        .add("currentPage", currentPage)
        .add("totalPages", totalPages)
        .add("brands", brands)
        .add("aisles", aisles)
        .add("productsInfo", productsInfo)
        .toString();
  }
}
