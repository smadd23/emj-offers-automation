package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of service type.
 *
 * @author vbonk00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"Name", "Descripton", "Ordinal"})
public class ServiceType {

  @JsonProperty("Name")
  private String name;

  @JsonProperty("Descripton")
  private String descripton;

  @JsonProperty("Ordinal")
  private Integer ordinal;

  @JsonProperty("Name")
  public String getName() {
    return name;
  }

  @JsonProperty("Name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("Descripton")
  public String getDescripton() {
    return descripton;
  }

  @JsonProperty("Descripton")
  public void setDescripton(String descripton) {
    this.descripton = descripton;
  }

  @JsonProperty("Ordinal")
  public Integer getOrdinal() {
    return ordinal;
  }

  @JsonProperty("Ordinal")
  public void setOrdinal(Integer ordinal) {
    this.ordinal = ordinal;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ServiceType that = (ServiceType) o;
    return Objects.equal(name, that.name)
        && Objects.equal(descripton, that.descripton)
        && Objects.equal(ordinal, that.ordinal);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name, descripton, ordinal);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .add("descripton", descripton)
        .add("ordinal", ordinal)
        .toString();
  }
}
