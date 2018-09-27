package com.albertsons.api.framework.support.pojo.ucpservices;

import com.albertsons.api.framework.support.pojo.ecomintegration.Links;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Current class is the POJO representation of Digital Receipt Detail.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "transactionNbr",
    "householdId",
    "clubCardNbr",
    "transactionTs",
    "receiptTxt",
    "links"
})
public class DigitalReceiptDetailSummary {

  @JsonProperty("transactionNbr")
  private String transactionNbr;

  @JsonProperty("householdId")
  private String householdId;

  @JsonProperty("clubCardNbr")
  private String clubCardNbr;

  @JsonProperty("transactionTs")
  private String transactionTs;

  @JsonProperty("receiptTxt")
  private DigitalReceiptText receiptTxt;

  @JsonProperty("links")
  private Links[] links;

  @JsonProperty("transactionNbr")
  public String getTransactionNbr() {
    return transactionNbr;
  }

  @JsonProperty("transactionNbr")
  public void setTransactionNbr(String transactionNbr) {
    this.transactionNbr = transactionNbr;
  }

  @JsonProperty("householdId")
  public String getHouseholdId() {
    return householdId;
  }

  @JsonProperty("householdId")
  public void setHouseholdId(String householdId) {
    this.householdId = householdId;
  }

  @JsonProperty("clubCardNbr")
  public String getClubCardNbr() {
    return clubCardNbr;
  }

  @JsonProperty("clubCardNbr")
  public void setClubCardNbr(String clubCardNbr) {
    this.clubCardNbr = clubCardNbr;
  }

  @JsonProperty("transactionTs")
  public String getTransactionTs() {
    return transactionTs;
  }

  @JsonProperty("transactionTs")
  public void setTransactionTs(String transactionTs) {
    this.transactionTs = transactionTs;
  }

  @JsonProperty("receiptTxt")
  public DigitalReceiptText getReceiptTxt() {
    return receiptTxt;
  }

  @JsonProperty("receiptTxt")
  public void setReceiptTxt(DigitalReceiptText receiptTxt) {
    this.receiptTxt = receiptTxt;
  }

  @JsonProperty("links")
  public Links[] getLinks() {
    return links;
  }

  @JsonProperty("links")
  public void setLinks(Links[] links) {
    this.links = links;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DigitalReceiptDetailSummary that = (DigitalReceiptDetailSummary) o;
    return Objects.equal(getTransactionNbr(), that.getTransactionNbr())
        && Objects.equal(getHouseholdId(), that.getHouseholdId())
        && Objects.equal(getClubCardNbr(), that.getClubCardNbr())
        && Objects.equal(getTransactionTs(), that.getTransactionTs())
        && Objects.equal(getReceiptTxt(), that.getReceiptTxt())
        && Objects.equal(getLinks(), that.getLinks());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        getTransactionNbr(),
        getHouseholdId(),
        getClubCardNbr(),
        getTransactionTs(),
        getReceiptTxt(),
        getLinks());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("transactionNbr", transactionNbr)
        .add("householdId", householdId)
        .add("clubCardNbr", clubCardNbr)
        .add("transactionTs", transactionTs)
        .add("receiptTxt", receiptTxt)
        .add("links", links)
        .toString();
  }
}
