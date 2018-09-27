package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * This class contains the pojo representation of list of all DUG stores.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"dugStores"})
public class DugStoreList {

  @JsonProperty("dugStores")
  private List<DugStore> dugStores;

  public List<DugStore> getDugStores() {
    return dugStores;
  }

  public void setDugStores(List<DugStore> dugStores) {
    this.dugStores = dugStores;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof DugStoreList)) return false;
    DugStoreList that = (DugStoreList) o;
    return Objects.equal(getDugStores(), that.getDugStores());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getDugStores());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("dugStores", dugStores).toString();
  }
}
