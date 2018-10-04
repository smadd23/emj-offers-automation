package com.safeway.j4u.emju.offers.api.framework.support.pojo.galleryservices;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "priceTitle",
        "priceValue",
        "savingsValueText",
        "titleDescription",
        "productDescription",
        "disclaimerText",
        "receiptDescriptions"
})
public class Description {

    @JsonProperty("priceTitle")
    public String priceTitle;
    @JsonProperty("priceValue")
    public String priceValue;
    @JsonProperty("savingsValueText")
    public String savingsValueText;
    @JsonProperty("titleDescription")
    public TitleDescription titleDescription;
    @JsonProperty("productDescription")
    public ProductDescription productDescription;
    @JsonProperty("disclaimerText")
    public String disclaimerText;
    @JsonProperty("receiptDescriptions")
    public String receiptDescriptions;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("priceTitle", priceTitle).append("priceValue", priceValue).append("savingsValueText", savingsValueText).append("titleDescription", titleDescription).append("productDescription", productDescription).append("disclaimerText", disclaimerText).append("receiptDescriptions", receiptDescriptions).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(disclaimerText).append(savingsValueText).append(receiptDescriptions).append(productDescription).append(titleDescription).append(priceTitle).append(priceValue).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Description) == false) {
            return false;
        }
        Description rhs = ((Description) other);
        return new EqualsBuilder().append(disclaimerText, rhs.disclaimerText).append(savingsValueText, rhs.savingsValueText).append(receiptDescriptions, rhs.receiptDescriptions).append(productDescription, rhs.productDescription).append(titleDescription, rhs.titleDescription).append(priceTitle, rhs.priceTitle).append(priceValue, rhs.priceValue).isEquals();
    }

}