package com.safeway.j4u.emju.offers.api.framework.support.pojo.galleryservices;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "startDate",
        "endDate",
        "applicableTo",
        "qualification",
        "benefit",
        "usageLimits"
})
public class Rules {

    @JsonProperty("startDate")
    public StartDate startDate;
    @JsonProperty("endDate")
    public EndDate endDate;
    @JsonProperty("applicableTo")
    public ApplicableTo applicableTo;
    @JsonProperty("qualification")
    public Qualification qualification;
    @JsonProperty("benefit")
    public Benefit benefit;
    @JsonProperty("usageLimits")
    public UsageLimits usageLimits;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("startDate", startDate).append("endDate", endDate).append("applicableTo", applicableTo).append("qualification", qualification).append("benefit", benefit).append("usageLimits", usageLimits).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(startDate).append(qualification).append(usageLimits).append(benefit).append(applicableTo).append(endDate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Rules) == false) {
            return false;
        }
        Rules rhs = ((Rules) other);
        return new EqualsBuilder().append(startDate, rhs.startDate).append(qualification, rhs.qualification).append(usageLimits, rhs.usageLimits).append(benefit, rhs.benefit).append(applicableTo, rhs.applicableTo).append(endDate, rhs.endDate).isEquals();
    }

}