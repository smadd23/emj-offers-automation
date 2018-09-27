package com.albertsons.api.framework.support.pojo.galleryservices;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "125"
})
public class Events {

    @JsonProperty("125")
    public String _125;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("_125", _125).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(_125).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Events) == false) {
            return false;
        }
        Events rhs = ((Events) other);
        return new EqualsBuilder().append(_125, rhs._125).isEquals();
    }

}