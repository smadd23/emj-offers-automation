package com.safeway.j4u.emju.offers.api.framework.support.pojo.galleryservices;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "offerId",
        "externalOfferId",
        "aggregatorOfferId"
})
public class Id {

    @JsonProperty("offerId")
    public Integer offerId;
    @JsonProperty("externalOfferId")
    public String externalOfferId;
    @JsonProperty("aggregatorOfferId")
    public String aggregatorOfferId;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("offerId", offerId).append("externalOfferId", externalOfferId).append("aggregatorOfferId", aggregatorOfferId).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(externalOfferId).append(aggregatorOfferId).append(offerId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Id) == false) {
            return false;
        }
        Id rhs = ((Id) other);
        return new EqualsBuilder().append(externalOfferId, rhs.externalOfferId).append(aggregatorOfferId, rhs.aggregatorOfferId).append(offerId, rhs.offerId).isEquals();
    }

}