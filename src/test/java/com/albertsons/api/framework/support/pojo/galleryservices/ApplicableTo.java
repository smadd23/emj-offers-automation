package com.albertsons.api.framework.support.pojo.galleryservices;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "banners",
        "divisions",
        "storeGroups",
        "channels",
        "terminals",
        "storeIds",
        "postalCodes",
        "upcs",
        "departments"
})
public class ApplicableTo {

    @JsonProperty("banners")
    public Banners banners;
    @JsonProperty("divisions")
    public Divisions divisions;
    @JsonProperty("storeGroups")
    public List<String> storeGroups = null;
    @JsonProperty("channels")
    public List<String> channels = null;
    @JsonProperty("terminals")
    public Object terminals;
    @JsonProperty("storeIds")
    public List<String> storeIds = null;
    @JsonProperty("postalCodes")
    public List<String> postalCodes = null;
    @JsonProperty("upcs")
    public List<Integer> upcs = null;
    @JsonProperty("departments")
    public List<String> departments = null;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("banners", banners).append("divisions", divisions).append("storeGroups", storeGroups).append("channels", channels).append("terminals", terminals).append("storeIds", storeIds).append("postalCodes", postalCodes).append("upcs", upcs).append("departments", departments).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(storeIds).append(upcs).append(terminals).append(postalCodes).append(departments).append(channels).append(storeGroups).append(divisions).append(banners).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ApplicableTo) == false) {
            return false;
        }
        ApplicableTo rhs = ((ApplicableTo) other);
        return new EqualsBuilder().append(storeIds, rhs.storeIds).append(upcs, rhs.upcs).append(terminals, rhs.terminals).append(postalCodes, rhs.postalCodes).append(departments, rhs.departments).append(channels, rhs.channels).append(storeGroups, rhs.storeGroups).append(divisions, rhs.divisions).append(banners, rhs.banners).isEquals();
    }

}