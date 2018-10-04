package com.safeway.j4u.emju.offers.api.framework.support.pojo.galleryservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "createdTs",
        "createdApplicationId",
        "createdUserId",
        "lastUpdatedApplicationId",
        "lastUpdatedUserId",
        "lastUpdatedTs"
})
public class AuditInfo {

    @JsonProperty("createdTs")
    public String createdTs;
    @JsonProperty("createdApplicationId")
    public String createdApplicationId;
    @JsonProperty("createdUserId")
    public String createdUserId;
    @JsonProperty("lastUpdatedApplicationId")
    public String lastUpdatedApplicationId;
    @JsonProperty("lastUpdatedUserId")
    public String lastUpdatedUserId;
    @JsonProperty("lastUpdatedTs")
    public String lastUpdatedTs;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("createdTs", createdTs).append("createdApplicationId", createdApplicationId).append("createdUserId", createdUserId).append("lastUpdatedApplicationId", lastUpdatedApplicationId).append("lastUpdatedUserId", lastUpdatedUserId).append("lastUpdatedTs", lastUpdatedTs).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(createdUserId).append(createdTs).append(lastUpdatedTs).append(lastUpdatedUserId).append(createdApplicationId).append(lastUpdatedApplicationId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AuditInfo) == false) {
            return false;
        }
        AuditInfo rhs = ((AuditInfo) other);
        return new EqualsBuilder().append(createdUserId, rhs.createdUserId).append(createdTs, rhs.createdTs).append(lastUpdatedTs, rhs.lastUpdatedTs).append(lastUpdatedUserId, rhs.lastUpdatedUserId).append(createdApplicationId, rhs.createdApplicationId).append(lastUpdatedApplicationId, rhs.lastUpdatedApplicationId).isEquals();
    }

}