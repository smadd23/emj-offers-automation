package com.albertsons.api.framework.support.pojo.galleryservices;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "usageLimitTypePerUser",
        "usageLimitTypePerOffer",
        "usageLimitPerUser",
        "usageLimitPerOffer"
})
public class UsageLimits {

    @JsonProperty("usageLimitTypePerUser")
    public String usageLimitTypePerUser;
    @JsonProperty("usageLimitTypePerOffer")
    public String usageLimitTypePerOffer;
    @JsonProperty("usageLimitPerUser")
    public Integer usageLimitPerUser;
    @JsonProperty("usageLimitPerOffer")
    public Integer usageLimitPerOffer;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("usageLimitTypePerUser", usageLimitTypePerUser).append("usageLimitTypePerOffer", usageLimitTypePerOffer).append("usageLimitPerUser", usageLimitPerUser).append("usageLimitPerOffer", usageLimitPerOffer).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(usageLimitPerUser).append(usageLimitTypePerOffer).append(usageLimitTypePerUser).append(usageLimitPerOffer).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UsageLimits) == false) {
            return false;
        }
        UsageLimits rhs = ((UsageLimits) other);
        return new EqualsBuilder().append(usageLimitPerUser, rhs.usageLimitPerUser).append(usageLimitTypePerOffer, rhs.usageLimitTypePerOffer).append(usageLimitTypePerUser, rhs.usageLimitTypePerUser).append(usageLimitPerOffer, rhs.usageLimitPerOffer).isEquals();
    }

}