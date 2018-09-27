package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ack",
        "brands",
        "aisles",
        "products",
        "totalProducts",
        "currentPage",
        "totalPages"
})
public class SearchProduct {
    @JsonProperty("ack")
    private Boolean ack;

    @JsonProperty("brands")
    private List<String> brands = null;

    @JsonProperty("aisles")
    private List<String> aisles = null;

    @JsonProperty("products")
    private List<Product> products = null;

    @JsonProperty("totalProducts")
    private Integer totalProducts;

    @JsonProperty("currentPage")
    private Integer currentPage;

    @JsonProperty("totalPages")
    private Integer totalPages;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchProduct)) return false;
        SearchProduct that = (SearchProduct) o;
        return Objects.equal(getAck(), that.getAck())
                && Objects.equal(getBrands(), that.getBrands())
                && Objects.equal(getAisles(), that.getAisles())
                && Objects.equal(getProducts(), that.getProducts())
                && Objects.equal(getTotalProducts(), that.getTotalProducts())
                && Objects.equal(getCurrentPage(), that.getCurrentPage())
                && Objects.equal(getTotalPages(), that.getTotalPages());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                getAck(),
                getBrands(),
                getAisles(),
                getProducts(),
                getTotalProducts(),
                getCurrentPage(),
                getTotalPages());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("ack", ack)
                .add("brands", brands)
                .add("aisles", aisles)
                .add("products", products)
                .add("totalProducts", totalProducts)
                .add("currentPage", currentPage)
                .add("totalPages", totalPages)
                .toString();
    }
}
