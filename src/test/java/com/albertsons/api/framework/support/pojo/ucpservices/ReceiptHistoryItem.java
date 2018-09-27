package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of ReceiptHistory.
 * @author SKuna02
 */

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({
    "transactionNbr",
    "transactionTs",
    "totalAmt",
    "savingsAmt",
    "itemPurchasedCnt"
})

public class ReceiptHistoryItem {

  @JsonProperty("transactionNbr")
  private String transactionNbr;

  @JsonProperty("transactionTs")
  private String transactionTs;

  @JsonProperty("totalAmt")
  private float totalAmt;

  @JsonProperty("savingsAmt")
  private float savingsAmt;

  @JsonProperty("itemPurchasedCnt")
  private String itemPurchasedCnt;

  @JsonProperty("transactionNbr")
  public String getTransactionNbr() {
    return transactionNbr;
  }

  @JsonProperty("transactionNbr")
  public void setTransactionNbr(String transactionNbr) {
    this.transactionNbr = transactionNbr;
  }

  @JsonProperty("transactionTs")
  public String getTransactionTs() {
    return transactionTs;
  }

  @JsonProperty("transactionTs")
  public void setTransactionTs(String transactionTs) {
    this.transactionTs = transactionTs;
  }

  @JsonProperty("totalAmt")
  public float getTotalAmt() {
    return totalAmt;
  }

  @JsonProperty("totalAmt")
  public void setTotalAmt(float totalAmt) {
    this.totalAmt = totalAmt;
  }

  @JsonProperty("savingsAmt")
  public float getSavingsAmt() {
    return savingsAmt;
  }

  @JsonProperty("savingsAmt")
  public void setSavingsAmt(float savingsAmt) {
    this.savingsAmt = savingsAmt;
  }

  @JsonProperty("itemPurchasedCnt")
  public String getItemPurchasedCnt() {
    return itemPurchasedCnt;
  }

  @JsonProperty("itemPurchasedCnt")
  public void setItemPurchasedCnt(String itemPurchasedCnt) {
    this.itemPurchasedCnt = itemPurchasedCnt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReceiptHistoryItem that = (ReceiptHistoryItem) o;
    return Objects.equal(getTransactionNbr(), that.getTransactionNbr()) &&
        Objects.equal(getTransactionTs(), that.getTransactionTs()) &&
        Objects.equal(getTotalAmt(), that.getTotalAmt()) &&
        Objects.equal(getSavingsAmt(), that.getSavingsAmt()) &&
        Objects.equal(getItemPurchasedCnt(), that.getItemPurchasedCnt());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getTransactionNbr(), getTransactionTs(), getTotalAmt(), getSavingsAmt(),
        getItemPurchasedCnt());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("transactionNbr", transactionNbr)
        .add("transactionTs", transactionTs)
        .add("totalAmt", totalAmt)
        .add("savingsAmt", savingsAmt)
        .add("itemPurchasedCnt", itemPurchasedCnt)
        .toString();
  }
}
