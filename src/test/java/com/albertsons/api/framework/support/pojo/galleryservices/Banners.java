package com.albertsons.api.framework.support.pojo.galleryservices;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "V",
        "S",
        "J",
        "C"
})
public class Banners {

    @JsonProperty("V")
    public String v;
    @JsonProperty("S")
    public String s;
    @JsonProperty("C")
    public String c;
    @JsonProperty("J")
    public String j;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("v", v).append("s", s).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(v).append(s).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Banners) == false) {
            return false;
        }
        Banners rhs = ((Banners) other);
        return new EqualsBuilder().append(v, rhs.v).append(s, rhs.s).isEquals();
    }

}