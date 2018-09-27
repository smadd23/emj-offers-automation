package com.albertsons.api.framework.support.pojo.galleryservices;
import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
@JsonIgnoreType
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "24"
})
public class Divisions {

    @JsonProperty("24")
    public String _24;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("_24", _24).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(_24).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Divisions) == false) {
            return false;
        }
        Divisions rhs = ((Divisions) other);
        return new EqualsBuilder().append(_24, rhs._24).isEquals();
    }

}