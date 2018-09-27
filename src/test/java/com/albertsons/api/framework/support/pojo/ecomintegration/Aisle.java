package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import java.util.Objects;

/**
 * Pojo class to represent Aisle object.
 *
 * <p>Created by vbonk00.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "parentAisleId", "name", "image", "hasProducts"})
public class Aisle {

  @JsonProperty("id")
  private String id;

  @JsonProperty("parentAisleId")
  private Object parentAisleId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("image")
  private String image;

  @JsonProperty("hasProducts")
  private Boolean hasProducts;

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("parentAisleId")
  public Object getParentAisleId() {
    return parentAisleId;
  }

  @JsonProperty("parentAisleId")
  public void setParentAisleId(Object parentAisleId) {
    this.parentAisleId = parentAisleId;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("image")
  public String getImage() {
    return image;
  }

  @JsonProperty("image")
  public void setImage(String image) {
    this.image = image;
  }

  @JsonProperty("hasProducts")
  public Boolean getHasProducts() {
    return hasProducts;
  }

  @JsonProperty("hasProducts")
  public void setHasProducts(Boolean hasProducts) {
    this.hasProducts = hasProducts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Aisle aisle = (Aisle) o;
    return Objects.equals(id, aisle.id)
        && Objects.equals(parentAisleId, aisle.parentAisleId)
        && Objects.equals(name, aisle.name)
        && Objects.equals(image, aisle.image)
        && Objects.equals(hasProducts, aisle.hasProducts);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, parentAisleId, name, image, hasProducts);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("parentAisleId", parentAisleId)
        .add("name", name)
        .add("image", image)
        .add("hasProducts", hasProducts)
        .toString();
  }
}
