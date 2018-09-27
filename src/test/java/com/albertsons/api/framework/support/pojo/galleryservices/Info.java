package com.albertsons.api.framework.support.pojo.galleryservices;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "offerProviderName",
        "categories",
        "primaryCategory",
        "events",
        "offerProgramCode",
        "offerSubProgram",
        "offerStatus",
        "description",
        "productImageId",
        "priceCode",
        "isEmployeeOffer",
        "isDefaultAllocationOffer",
        "offerProgramType",
        "shouldReportRedemptions",
        "promoClassId",
        "auditInfo"
})
public class Info {

    @JsonProperty("id")
    public Id id;
    @JsonProperty("offerProviderName")
    public String offerProviderName;
    @JsonProperty("categories")
    public Categories categories;
    @JsonProperty("primaryCategory")
    public PrimaryCategory primaryCategory;
    @JsonProperty("events")
    public Events events;
    @JsonProperty("offerProgramCode")
    public String offerProgramCode;
    @JsonProperty("offerSubProgram")
    public String offerSubProgram;
    @JsonProperty("offerStatus")
    public String offerStatus;
    @JsonProperty("description")
    public Description description;
    @JsonProperty("productImageId")
    public String productImageId;
    @JsonProperty("priceCode")
    public String priceCode;
    @JsonProperty("isEmployeeOffer")
    public Boolean isEmployeeOffer;
    @JsonProperty("isDefaultAllocationOffer")
    public Boolean isDefaultAllocationOffer;
    @JsonProperty("offerProgramType")
    public String offerProgramType;
    @JsonProperty("shouldReportRedemptions")
    public Boolean shouldReportRedemptions;
    @JsonProperty("promoClassId")
    public String promoClassId;
    @JsonProperty("auditInfo")
    public AuditInfo auditInfo;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("offerProviderName", offerProviderName).append("categories", categories).append("primaryCategory", primaryCategory).append("events", events).append("offerProgramCode", offerProgramCode).append("offerSubProgram", offerSubProgram).append("offerStatus", offerStatus).append("description", description).append("productImageId", productImageId).append("priceCode", priceCode).append("isEmployeeOffer", isEmployeeOffer).append("isDefaultAllocationOffer", isDefaultAllocationOffer).append("offerProgramType", offerProgramType).append("shouldReportRedemptions", shouldReportRedemptions).append("promoClassId", promoClassId).append("auditInfo", auditInfo).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(offerSubProgram).append(primaryCategory).append(events).append(offerProgramType).append(offerStatus).append(shouldReportRedemptions).append(offerProviderName).append(id).append(isDefaultAllocationOffer).append(promoClassId).append(productImageId).append(description).append(isEmployeeOffer).append(categories).append(offerProgramCode).append(auditInfo).append(priceCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Info) == false) {
            return false;
        }
        Info rhs = ((Info) other);
        return new EqualsBuilder().append(offerSubProgram, rhs.offerSubProgram).append(primaryCategory, rhs.primaryCategory).append(events, rhs.events).append(offerProgramType, rhs.offerProgramType).append(offerStatus, rhs.offerStatus).append(shouldReportRedemptions, rhs.shouldReportRedemptions).append(offerProviderName, rhs.offerProviderName).append(id, rhs.id).append(isDefaultAllocationOffer, rhs.isDefaultAllocationOffer).append(promoClassId, rhs.promoClassId).append(productImageId, rhs.productImageId).append(description, rhs.description).append(isEmployeeOffer, rhs.isEmployeeOffer).append(categories, rhs.categories).append(offerProgramCode, rhs.offerProgramCode).append(auditInfo, rhs.auditInfo).append(priceCode, rhs.priceCode).isEquals();
    }

}