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
@JsonPropertyOrder({
  "infoLabel",
  "title",
  "formatedTitle",
  "subTitle",
  "formatedSubTitle",
  "description",
  "formatedDescription",
  "image",
  "image2",
  "buttonTitle"
})
public class PromoInterstitial {

  @JsonProperty("infoLabel")
  private Object infoLabel;

  @JsonProperty("title")
  private String title;

  @JsonProperty("formatedTitle")
  private FormatedTitle formatedTitle;

  @JsonProperty("subTitle")
  private String subTitle;

  @JsonProperty("formatedSubTitle")
  private Object formatedSubTitle;

  @JsonProperty("description")
  private Object description;

  @JsonProperty("formatedDescription")
  private Object formatedDescription;

  @JsonProperty("image")
  private Object image;

  @JsonProperty("image2")
  private Object image2;

  @JsonProperty("buttonTitle")
  private Object buttonTitle;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("infoLabel")
  public Object getInfoLabel() {
    return infoLabel;
  }

  @JsonProperty("infoLabel")
  public void setInfoLabel(Object infoLabel) {
    this.infoLabel = infoLabel;
  }

  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  @JsonProperty("title")
  public void setTitle(String title) {
    this.title = title;
  }

  @JsonProperty("formatedTitle")
  public FormatedTitle getFormatedTitle() {
    return formatedTitle;
  }

  @JsonProperty("formatedTitle")
  public void setFormatedTitle(FormatedTitle formatedTitle) {
    this.formatedTitle = formatedTitle;
  }

  @JsonProperty("subTitle")
  public String getSubTitle() {
    return subTitle;
  }

  @JsonProperty("subTitle")
  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
  }

  @JsonProperty("formatedSubTitle")
  public Object getFormatedSubTitle() {
    return formatedSubTitle;
  }

  @JsonProperty("formatedSubTitle")
  public void setFormatedSubTitle(Object formatedSubTitle) {
    this.formatedSubTitle = formatedSubTitle;
  }

  @JsonProperty("description")
  public Object getDescription() {
    return description;
  }

  @JsonProperty("description")
  public void setDescription(Object description) {
    this.description = description;
  }

  @JsonProperty("formatedDescription")
  public Object getFormatedDescription() {
    return formatedDescription;
  }

  @JsonProperty("formatedDescription")
  public void setFormatedDescription(Object formatedDescription) {
    this.formatedDescription = formatedDescription;
  }

  @JsonProperty("image")
  public Object getImage() {
    return image;
  }

  @JsonProperty("image")
  public void setImage(Object image) {
    this.image = image;
  }

  @JsonProperty("image2")
  public Object getImage2() {
    return image2;
  }

  @JsonProperty("image2")
  public void setImage2(Object image2) {
    this.image2 = image2;
  }

  @JsonProperty("buttonTitle")
  public Object getButtonTitle() {
    return buttonTitle;
  }

  @JsonProperty("buttonTitle")
  public void setButtonTitle(Object buttonTitle) {
    this.buttonTitle = buttonTitle;
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
    if (!(o instanceof PromoInterstitial)) return false;
    PromoInterstitial that = (PromoInterstitial) o;
    return Objects.equal(infoLabel, that.infoLabel)
        && Objects.equal(title, that.title)
        && Objects.equal(formatedTitle, that.formatedTitle)
        && Objects.equal(subTitle, that.subTitle)
        && Objects.equal(formatedSubTitle, that.formatedSubTitle)
        && Objects.equal(description, that.description)
        && Objects.equal(formatedDescription, that.formatedDescription)
        && Objects.equal(image, that.image)
        && Objects.equal(image2, that.image2)
        && Objects.equal(buttonTitle, that.buttonTitle)
        && Objects.equal(additionalProperties, that.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        infoLabel,
        title,
        formatedTitle,
        subTitle,
        formatedSubTitle,
        description,
        formatedDescription,
        image,
        image2,
        buttonTitle,
        additionalProperties);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("infoLabel", infoLabel)
        .add("title", title)
        .add("formatedTitle", formatedTitle)
        .add("subTitle", subTitle)
        .add("formatedSubTitle", formatedSubTitle)
        .add("description", description)
        .add("formatedDescription", formatedDescription)
        .add("image", image)
        .add("image2", image2)
        .add("buttonTitle", buttonTitle)
        .add("additionalProperties", additionalProperties)
        .toString();
  }
}
