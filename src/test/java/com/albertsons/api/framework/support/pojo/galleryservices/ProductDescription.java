package com.albertsons.api.framework.support.pojo.galleryservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "prodDsc1"
})
public class ProductDescription {

    @JsonProperty("prodDsc1")
    public String prodDsc1;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("prodDsc1", prodDsc1).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(prodDsc1).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductDescription) == false) {
            return false;
        }
        ProductDescription rhs = ((ProductDescription) other);
        return new EqualsBuilder().append(prodDsc1, rhs.prodDsc1).isEquals();
    }

}


