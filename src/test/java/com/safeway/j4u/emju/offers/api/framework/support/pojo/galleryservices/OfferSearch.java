package com.safeway.j4u.emju.offers.api.framework.support.pojo.galleryservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "info",
    "rules"
})
public class OfferSearch {

    @JsonProperty("info")
    private Info info;
    @JsonProperty("rules")
    private Rules rules;

    @JsonProperty("info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("rules")
    public Rules getRules() {
        return rules;
    }

    @JsonProperty("rules")
    public void setRules(Rules rules) {
        this.rules = rules;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("info", info).append("rules", rules).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rules).append(info).toHashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferSearch that = (OfferSearch) o;
        return Objects.equal(info, that.info) &&
            Objects.equal(rules, that.rules);
    }
}
