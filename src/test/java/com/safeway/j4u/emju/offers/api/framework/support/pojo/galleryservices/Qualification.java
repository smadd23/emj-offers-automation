package com.safeway.j4u.emju.offers.api.framework.support.pojo.galleryservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "qualificationUnitType",
        "qualificationUnitSubType",
        "minProdPurchaseUnits",
        "maxProdPurchaseUnits",
        "minOrderTotalAmount",
        "minRewardPoints",
        "minGetProdPurchaseUnits",
        "isBuyXGetYOffer"
})
public class Qualification {

    @JsonProperty("qualificationUnitType")
    public String qualificationUnitType;
    @JsonProperty("qualificationUnitSubType")
    public String qualificationUnitSubType;
    @JsonProperty("minProdPurchaseUnits")
    public Integer minProdPurchaseUnits;
    @JsonProperty("maxProdPurchaseUnits")
    public Integer maxProdPurchaseUnits;
    @JsonProperty("minOrderTotalAmount")
    public Float minOrderTotalAmount;
    @JsonProperty("minRewardPoints")
    public Integer minRewardPoints;
    @JsonProperty("minGetProdPurchaseUnits")
    public Integer minGetProdPurchaseUnits;
    @JsonProperty("isBuyXGetYOffer")
    public Boolean isBuyXGetYOffer;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("qualificationUnitType", qualificationUnitType).append("qualificationUnitSubType", qualificationUnitSubType).append("minProdPurchaseUnits", minProdPurchaseUnits).append("maxProdPurchaseUnits", maxProdPurchaseUnits).append("minOrderTotalAmount", minOrderTotalAmount).append("minRewardPoints", minRewardPoints).append("minGetProdPurchaseUnits", minGetProdPurchaseUnits).append("isBuyXGetYOffer", isBuyXGetYOffer).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(minProdPurchaseUnits).append(minOrderTotalAmount).append(maxProdPurchaseUnits).append(minGetProdPurchaseUnits).append(qualificationUnitSubType).append(qualificationUnitType).append(minRewardPoints).append(isBuyXGetYOffer).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Qualification) == false) {
            return false;
        }
        Qualification rhs = ((Qualification) other);
        return new EqualsBuilder().append(minProdPurchaseUnits, rhs.minProdPurchaseUnits).append(minOrderTotalAmount, rhs.minOrderTotalAmount).append(maxProdPurchaseUnits, rhs.maxProdPurchaseUnits).append(minGetProdPurchaseUnits, rhs.minGetProdPurchaseUnits).append(qualificationUnitSubType, rhs.qualificationUnitSubType).append(qualificationUnitType, rhs.qualificationUnitType).append(minRewardPoints, rhs.minRewardPoints).append(isBuyXGetYOffer, rhs.isBuyXGetYOffer).isEquals();
    }

}