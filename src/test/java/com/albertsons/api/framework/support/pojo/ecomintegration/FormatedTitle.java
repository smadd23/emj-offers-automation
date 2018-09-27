package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"color", "isBold", "isItalic", "isUnderline", "fontSize", "text"})
public class FormatedTitle {

  @JsonProperty("color")
  private Object color;

  @JsonProperty("isBold")
  private Object isBold;

  @JsonProperty("isItalic")
  private Object isItalic;

  @JsonProperty("isUnderline")
  private Object isUnderline;

  @JsonProperty("fontSize")
  private Object fontSize;

  @JsonProperty("text")
  private String text;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("color")
  public Object getColor() {
    return color;
  }

  @JsonProperty("color")
  public void setColor(Object color) {
    this.color = color;
  }

  @JsonProperty("isBold")
  public Object getIsBold() {
    return isBold;
  }

  @JsonProperty("isBold")
  public void setIsBold(Object isBold) {
    this.isBold = isBold;
  }

  @JsonProperty("isItalic")
  public Object getIsItalic() {
    return isItalic;
  }

  @JsonProperty("isItalic")
  public void setIsItalic(Object isItalic) {
    this.isItalic = isItalic;
  }

  @JsonProperty("isUnderline")
  public Object getIsUnderline() {
    return isUnderline;
  }

  @JsonProperty("isUnderline")
  public void setIsUnderline(Object isUnderline) {
    this.isUnderline = isUnderline;
  }

  @JsonProperty("fontSize")
  public Object getFontSize() {
    return fontSize;
  }

  @JsonProperty("fontSize")
  public void setFontSize(Object fontSize) {
    this.fontSize = fontSize;
  }

  @JsonProperty("text")
  public String getText() {
    return text;
  }

  @JsonProperty("text")
  public void setText(String text) {
    this.text = text;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof FormatedTitle)) return false;
    FormatedTitle that = (FormatedTitle) o;
    return Objects.equal(color, that.color)
        && Objects.equal(isBold, that.isBold)
        && Objects.equal(isItalic, that.isItalic)
        && Objects.equal(isUnderline, that.isUnderline)
        && Objects.equal(fontSize, that.fontSize)
        && Objects.equal(text, that.text)
        && Objects.equal(additionalProperties, that.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        color, isBold, isItalic, isUnderline, fontSize, text, additionalProperties);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("color", color)
        .add("isBold", isBold)
        .add("isItalic", isItalic)
        .add("isUnderline", isUnderline)
        .add("fontSize", fontSize)
        .add("text", text)
        .add("additionalProperties", additionalProperties)
        .toString();
  }
}
