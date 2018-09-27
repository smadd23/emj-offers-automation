package com.albertsons.api.framework.support.pojo.galleryservices;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "17"
})
public class Categories {

    @JsonProperty("17")
    public String _17;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("_17", _17).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(_17).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Categories) == false) {
            return false;
        }
        Categories rhs = ((Categories) other);
        return new EqualsBuilder().append(_17, rhs._17).isEquals();
    }

}