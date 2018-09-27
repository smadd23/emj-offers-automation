package com.albertsons.api.framework.support.pojo.ucpservices;

import com.albertsons.api.framework.support.pojo.ecomintegration.Links;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * Current class is the POJO representation of Digital Receipt Summary.
 * @author SKuna02
 */
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"receiptHistoryItems", "links"})
public class DigitalReceiptSummary {

  @JsonProperty("receiptHistoryItems")
  private List<ReceiptHistoryItem> receiptHistoryItems = null;

  @JsonProperty("links")
  private Links[] links;

  @JsonProperty("receiptHistoryItems")
  public List<ReceiptHistoryItem> getReceiptHistoryItems() {
    return receiptHistoryItems;
  }

  @JsonProperty("receiptHistoryItems")
  public void setReceiptHistoryItems(List<ReceiptHistoryItem> receiptHistoryItems) {
    this.receiptHistoryItems = receiptHistoryItems;
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
    DigitalReceiptSummary that = (DigitalReceiptSummary) o;
    return Objects.equal(getReceiptHistoryItems(), that.getReceiptHistoryItems())
        && Objects.equal(getLinks(), that.getLinks());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getReceiptHistoryItems(), getLinks());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("receiptHistoryItems", receiptHistoryItems)
        .add("links", links)
        .toString();
  }
}
