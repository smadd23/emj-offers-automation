package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"rel", "href"})
public class Links {

  @JsonProperty("rel")
  private String rel;

  @JsonProperty("href")
  private String href;

  @JsonProperty("rel")
  public String getRel() {
    return rel;
  }

  @JsonProperty("rel")
  public void setRel(String rel) {
    this.rel = rel;
  }

  @JsonProperty("href")
  public String getHref() {
    return href;
  }

  @JsonProperty("href")
  public void setHref(String href) {
    this.href = href;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Links that = (Links) o;
    return Objects.equal(href, that.href) && Objects.equal(rel, that.rel);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(rel, href);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("rel", rel).add("href", href).toString();
  }
}
