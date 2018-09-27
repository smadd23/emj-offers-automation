package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Current class is the POJO representation of Digital Receipt text.
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "logo",
    "barcode",
    "formattedReceiptText"
})
public class DigitalReceiptText {

  @JsonProperty("logo")
  private String logo;

  @JsonProperty("barcode")
  private String barcode;

  @JsonProperty("formattedReceiptText")
  private String formattedReceiptText;

  @JsonProperty("logo")
  public String getLogo() {
    return logo;
  }

  @JsonProperty("logo")
  public void setLogo(String logo) {
    this.logo = logo;
  }

  @JsonProperty("barcode")
  public String getBarcode() {
    return barcode;
  }

  @JsonProperty("barcode")
  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  @JsonProperty("formattedReceiptText")
  public String getFormattedReceiptText() {
    return formattedReceiptText;
  }

  @JsonProperty("formattedReceiptText")
  public void setFormattedReceiptText(String formattedReceiptText) {
    this.formattedReceiptText = formattedReceiptText;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DigitalReceiptText that = (DigitalReceiptText) o;
    return Objects.equal(getLogo(), that.getLogo())
        && Objects.equal(getBarcode(), that.getBarcode())
        && Objects
            .equal(getFormattedReceiptText(), that.getFormattedReceiptText());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getLogo(), getBarcode(), getFormattedReceiptText());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("logo", logo)
        .add("barcode", barcode)
        .add("formattedReceiptText", formattedReceiptText)
        .toString();
  }
}
