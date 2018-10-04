package com.safeway.j4u.emju.offers.api.framework.support.pojo.galleryservices;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "titleDsc1"
})
public class TitleDescription {

    @JsonProperty("titleDsc1")
    public String titleDsc1;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("titleDsc1", titleDsc1).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(titleDsc1).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TitleDescription) == false) {
            return false;
        }
        TitleDescription rhs = ((TitleDescription) other);
        return new EqualsBuilder().append(titleDsc1, rhs.titleDsc1).isEquals();
    }

}