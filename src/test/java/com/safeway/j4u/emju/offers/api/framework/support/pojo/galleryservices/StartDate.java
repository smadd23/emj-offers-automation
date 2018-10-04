package com.safeway.j4u.emju.offers.api.framework.support.pojo.galleryservices;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "displayEffectiveStartDate",
        "offerEffectiveStartDate",
        "offerTestEffectiveStartDate"
})
public class StartDate {

    @JsonProperty("displayEffectiveStartDate")
    public String displayEffectiveStartDate;
    @JsonProperty("offerEffectiveStartDate")
    public String offerEffectiveStartDate;
    @JsonProperty("offerTestEffectiveStartDate")
    public String offerTestEffectiveStartDate;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("displayEffectiveStartDate", displayEffectiveStartDate).append("offerEffectiveStartDate", offerEffectiveStartDate).append("offerTestEffectiveStartDate", offerTestEffectiveStartDate).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(offerTestEffectiveStartDate).append(offerEffectiveStartDate).append(displayEffectiveStartDate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StartDate) == false) {
            return false;
        }
        StartDate rhs = ((StartDate) other);
        return new EqualsBuilder().append(offerTestEffectiveStartDate, rhs.offerTestEffectiveStartDate).append(offerEffectiveStartDate, rhs.offerEffectiveStartDate).append(displayEffectiveStartDate, rhs.displayEffectiveStartDate).isEquals();
    }

}