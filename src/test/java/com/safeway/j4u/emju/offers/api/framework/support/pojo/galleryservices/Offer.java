package com.safeway.j4u.emju.offers.api.framework.support.pojo.galleryservices;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * This class contains the pojo representation of offer.
 *
 * @author mdeen04
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "offerId",
  "priceType",
  "offerPrice",
  "description",
  "status",
  "startDate",
  "endDate",
  "offerTs",
  "usageType",
  "offerPgm",
  "purchaseInd",
  "brand",
  "category",
  "minPurchaseQty",
  "maxPurchaseQty",
  "price",
  "upcs",
  "purchaseRank",
  "rankID"
})
public class Offer {

  @JsonProperty("offerId")
  private String offerId;

  @JsonProperty("priceType")
  private String priceType;

  @JsonProperty("offerPrice")
  private String offerPrice;

  @JsonProperty("description")
  private String description;

  @JsonProperty("status")
  private String status;

  @JsonProperty("startDate")
  private String startDate;

  @JsonProperty("endDate")
  private String endDate;

  @JsonProperty("offerTs")
  private String offerTs;

  @JsonProperty("usageType")
  private String usageType;

  @JsonProperty("offerPgm")
  private String offerPgm;

  @JsonProperty("purchaseInd")
  private String purchaseInd;

  @JsonProperty("brand")
  private String brand;

  @JsonProperty("category")
  private String category;

  @JsonProperty("minPurchaseQty")
  private Integer minPurchaseQty;

  @JsonProperty("maxPurchaseQty")
  private Integer maxPurchaseQty;

  @JsonProperty("price")
  private Double price;

  @JsonProperty("upcs")
  private List<String> upcs = null;

  @JsonProperty("purchaseRank")
  private String purchaseRank;

  @JsonProperty("rankID")
  private String rankID;

  @JsonProperty("offerId")
  public String getOfferId() {
    return offerId;
  }

  @JsonProperty("offerId")
  public void setOfferId(String offerId) {
    this.offerId = offerId;
  }

  @JsonProperty("priceType")
  public String getPriceType() {
    return priceType;
  }

  @JsonProperty("priceType")
  public void setPriceType(String priceType) {
    this.priceType = priceType;
  }

  @JsonProperty("offerPrice")
  public String getOfferPrice() {
    return offerPrice;
  }

  @JsonProperty("offerPrice")
  public void setOfferPrice(String offerPrice) {
    this.offerPrice = offerPrice;
  }

  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  @JsonProperty("description")
  public void setDescription(String description) {
    this.description = description;
  }

  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(String status) {
    this.status = status;
  }

  @JsonProperty("startDate")
  public String getStartDate() {
    return startDate;
  }

  @JsonProperty("startDate")
  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  @JsonProperty("endDate")
  public String getEndDate() {
    return endDate;
  }

  @JsonProperty("endDate")
  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  @JsonProperty("offerTs")
  public String getOfferTs() {
    return offerTs;
  }

  @JsonProperty("offerTs")
  public void setOfferTs(String offerTs) {
    this.offerTs = offerTs;
  }

  @JsonProperty("usageType")
  public String getUsageType() {
    return usageType;
  }

  @JsonProperty("usageType")
  public void setUsageType(String usageType) {
    this.usageType = usageType;
  }

  @JsonProperty("offerPgm")
  public String getOfferPgm() {
    return offerPgm;
  }

  @JsonProperty("offerPgm")
  public void setOfferPgm(String offerPgm) {
    this.offerPgm = offerPgm;
  }

  @JsonProperty("purchaseInd")
  public String getPurchaseInd() {
    return purchaseInd;
  }

  @JsonProperty("purchaseInd")
  public void setPurchaseInd(String purchaseInd) {
    this.purchaseInd = purchaseInd;
  }

  @JsonProperty("brand")
  public String getBrand() {
    return brand;
  }

  @JsonProperty("brand")
  public void setBrand(String brand) {
    this.brand = brand;
  }

  @JsonProperty("category")
  public String getCategory() {
    return category;
  }

  @JsonProperty("category")
  public void setCategory(String category) {
    this.category = category;
  }

  @JsonProperty("minPurchaseQty")
  public Integer getMinPurchaseQty() {
    return minPurchaseQty;
  }

  @JsonProperty("minPurchaseQty")
  public void setMinPurchaseQty(Integer minPurchaseQty) {
    this.minPurchaseQty = minPurchaseQty;
  }

  @JsonProperty("maxPurchaseQty")
  public Integer getMaxPurchaseQty() {
    return maxPurchaseQty;
  }

  @JsonProperty("maxPurchaseQty")
  public void setMaxPurchaseQty(Integer maxPurchaseQty) {
    this.maxPurchaseQty = maxPurchaseQty;
  }

  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  @JsonProperty("price")
  public void setPrice(Double price) {
    this.price = price;
  }

  @JsonProperty("upcs")
  public List<String> getUpcs() {
    return upcs;
  }

  @JsonProperty("upcs")
  public void setUpcs(List<String> upcs) {
    this.upcs = upcs;
  }

  @JsonProperty("rankID")
  public String getRankID() {
    return rankID;
  }

  @JsonProperty("rankID")
  public void setRankID(String rankID) {
    this.rankID = rankID;
  }

  @JsonProperty("purchaseRank")
  public String getPurchaseRank() {
    return purchaseRank;
  }

  @JsonProperty("purchaseRank")
  public void setPurchaseRank(String purchaseRank) {
    this.purchaseRank = purchaseRank;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((brand == null) ? 0 : brand.hashCode());
    result = prime * result + ((category == null) ? 0 : category.hashCode());
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
    result = prime * result + ((offerId == null) ? 0 : offerId.hashCode());
    result = prime * result + ((offerPgm == null) ? 0 : offerPgm.hashCode());
    result = prime * result + ((offerPrice == null) ? 0 : offerPrice.hashCode());
    result = prime * result + ((offerTs == null) ? 0 : offerTs.hashCode());
    result = prime * result + ((priceType == null) ? 0 : priceType.hashCode());
    result = prime * result + ((purchaseInd == null) ? 0 : purchaseInd.hashCode());
    result = prime * result + ((rankID == null) ? 0 : rankID.hashCode());
    result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
    result = prime * result + ((status == null) ? 0 : status.hashCode());
    result = prime * result + ((upcs == null) ? 0 : upcs.hashCode());
    result = prime * result + ((usageType == null) ? 0 : usageType.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (!(obj instanceof Offer)) return false;
    Offer other = (Offer) obj;
    if (brand == null) {
      if (other.brand != null) return false;
    } else if (!brand.equals(other.brand)) return false;
    if (category == null) {
      if (other.category != null) return false;
    } else if (!category.equals(other.category)) return false;
    if (description == null) {
      if (other.description != null) return false;
    } else if (!description.equals(other.description)) return false;
    if (endDate == null) {
      if (other.endDate != null) return false;
    } else if (!endDate.equals(other.endDate)) return false;
    if (offerId == null) {
      if (other.offerId != null) return false;
    } else if (!offerId.equals(other.offerId)) return false;
    if (offerPgm == null) {
      if (other.offerPgm != null) return false;
    } else if (!offerPgm.equals(other.offerPgm)) return false;
    if (offerPrice == null) {
      if (other.offerPrice != null) return false;
    } else if (!offerPrice.equals(other.offerPrice)) return false;
    if (offerTs == null) {
      if (other.offerTs != null) return false;
    } else if (!offerTs.equals(other.offerTs)) return false;
    if (priceType == null) {
      if (other.priceType != null) return false;
    } else if (!priceType.equals(other.priceType)) return false;
    if (purchaseInd == null) {
      if (other.purchaseInd != null) return false;
    } else if (!purchaseInd.equals(other.purchaseInd)) return false;
    if (rankID == null) {
      if (other.rankID != null) return false;
    } else if (!rankID.equals(other.rankID)) return false;
    if (startDate == null) {
      if (other.startDate != null) return false;
    } else if (!startDate.equals(other.startDate)) return false;
    if (status == null) {
      if (other.status != null) return false;
    } else if (!status.equals(other.status)) return false;
    if (upcs == null) {
      if (other.upcs != null) return false;
    } else if (!upcs.equals(other.upcs)) return false;
    if (usageType == null) {
      if (other.usageType != null) return false;
    } else if (!usageType.equals(other.usageType)) return false;
    return true;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder
        .append("Offer [offerId=")
        .append(offerId)
        .append(", priceType=")
        .append(priceType)
        .append(", offerPrice=")
        .append(offerPrice)
        .append(", description=")
        .append(description)
        .append(", status=")
        .append(status)
        .append(", startDate=")
        .append(startDate)
        .append(", endDate=")
        .append(endDate)
        .append(", offerTs=")
        .append(offerTs)
        .append(", usageType=")
        .append(usageType)
        .append(", offerPgm=")
        .append(offerPgm)
        .append(", purchaseInd=")
        .append(purchaseInd)
        .append(", brand=")
        .append(brand)
        .append(", category=")
        .append(category)
        .append(", upcs=")
        .append(upcs)
        .append(", rankID=")
        .append(rankID)
        .append("]");
    return builder.toString();
  }
}
