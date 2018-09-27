package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "image",
  "title",
  "titleComment",
  "subTitle",
  "offerType",
  "description",
  "buttonTitle",
  "id"
})
public class Promo {

  @JsonProperty("image")
  private String image;

  @JsonProperty("title")
  private String title;

  @JsonProperty("titleComment")
  private Object titleComment;

  @JsonProperty("subTitle")
  private String subTitle;

  @JsonProperty("offerType")
  private Object offerType;

  @JsonProperty("description")
  private String description;

  @JsonProperty("buttonTitle")
  private String buttonTitle;

  @JsonProperty("id")
  private String id;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("image")
  public String getImage() {
    return image;
  }

  @JsonProperty("image")
  public void setImage(String image) {
    this.image = image;
  }

  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  @JsonProperty("title")
  public void setTitle(String title) {
    this.title = title;
  }

  @JsonProperty("titleComment")
  public Object getTitleComment() {
    return titleComment;
  }

  @JsonProperty("titleComment")
  public void setTitleComment(Object titleComment) {
    this.titleComment = titleComment;
  }

  @JsonProperty("subTitle")
  public String getSubTitle() {
    return subTitle;
  }

  @JsonProperty("subTitle")
  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
  }

  @JsonProperty("offerType")
  public Object getOfferType() {
    return offerType;
  }

  @JsonProperty("offerType")
  public void setOfferType(Object offerType) {
    this.offerType = offerType;
  }

  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  @JsonProperty("description")
  public void setDescription(String description) {
    this.description = description;
  }

  @JsonProperty("buttonTitle")
  public String getButtonTitle() {
    return buttonTitle;
  }

  @JsonProperty("buttonTitle")
  public void setButtonTitle(String buttonTitle) {
    this.buttonTitle = buttonTitle;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }
}
