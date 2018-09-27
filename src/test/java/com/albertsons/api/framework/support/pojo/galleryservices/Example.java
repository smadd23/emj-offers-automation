package com.albertsons.api.framework.support.pojo.galleryservices;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "info",
        "rules"
})
public class Example {

    @JsonProperty("info")
    public Info info;
    @JsonProperty("rules")
    public Rules rules;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("info", info).append("rules", rules).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rules).append(info).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Example) == false) {
            return false;
        }
        Example rhs = ((Example) other);
        return new EqualsBuilder().append(rules, rhs.rules).append(info, rhs.info).isEquals();
    }

}