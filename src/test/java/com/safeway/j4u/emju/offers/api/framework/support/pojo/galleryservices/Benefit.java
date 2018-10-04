package com.safeway.j4u.emju.offers.api.framework.support.pojo.galleryservices;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "benefitValueType",
        "benefitValue",
        "isBenefitValueApplicableToBuyItems",
        "isBenefitValueApplicableToGetItems",
        "isBenefitValueRestrictedToMultiplesOfMinUnits"
})
public class Benefit {

    @JsonProperty("benefitValueType")
    public String benefitValueType;
    @JsonProperty("benefitValue")
    public Float benefitValue;
    @JsonProperty("isBenefitValueApplicableToBuyItems")
    public Boolean isBenefitValueApplicableToBuyItems;
    @JsonProperty("isBenefitValueApplicableToGetItems")
    public Boolean isBenefitValueApplicableToGetItems;
    @JsonProperty("isBenefitValueRestrictedToMultiplesOfMinUnits")
    public Boolean isBenefitValueRestrictedToMultiplesOfMinUnits;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("benefitValueType", benefitValueType).append("benefitValue", benefitValue).append("isBenefitValueApplicableToBuyItems", isBenefitValueApplicableToBuyItems).append("isBenefitValueApplicableToGetItems", isBenefitValueApplicableToGetItems).append("isBenefitValueRestrictedToMultiplesOfMinUnits", isBenefitValueRestrictedToMultiplesOfMinUnits).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(isBenefitValueApplicableToBuyItems).append(benefitValue).append(benefitValueType).append(isBenefitValueApplicableToGetItems).append(isBenefitValueRestrictedToMultiplesOfMinUnits).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Benefit) == false) {
            return false;
        }
        Benefit rhs = ((Benefit) other);
        return new EqualsBuilder().append(isBenefitValueApplicableToBuyItems, rhs.isBenefitValueApplicableToBuyItems).append(benefitValue, rhs.benefitValue).append(benefitValueType, rhs.benefitValueType).append(isBenefitValueApplicableToGetItems, rhs.isBenefitValueApplicableToGetItems).append(isBenefitValueRestrictedToMultiplesOfMinUnits, rhs.isBenefitValueRestrictedToMultiplesOfMinUnits).isEquals();
    }

}