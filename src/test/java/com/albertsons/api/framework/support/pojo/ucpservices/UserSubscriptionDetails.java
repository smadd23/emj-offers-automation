package com.albertsons.api.framework.support.pojo.ucpservices;

import com.albertsons.api.framework.support.pojo.ecomintegration.Links;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * This class contains the pojo representation of Subscription Details.
 *
 * @author vkuma26
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "unMailableReasonCode",
    "mailable",
    "createDate",
    "isRegistered",
    "customerId",
    "emailId",
    "subscriptionDetails",
    "links"
})
public class UserSubscriptionDetails {

  @JsonProperty("unMailableReasonCode")
  private String unMailableReasonCode;

  @JsonProperty("mailable")
  private String mailable;

  @JsonProperty("createDate")
  private String createDate;

  @JsonProperty("isRegistered")
  private String isRegistered;

  @JsonProperty("customerId")
  private String customerId;

  @JsonProperty("emailId")
  private String emailId;

  @JsonProperty("subscriptionDetails")
  private List<SubscriptionDetail> subscriptionDetails = null;

  @JsonProperty("links")
  private Links[] links = null;

  @JsonProperty("unMailableReasonCode")
  public String getUnMailableReasonCode() {
    return unMailableReasonCode;
  }

  @JsonProperty("unMailableReasonCode")
  public void setUnMailableReasonCode(String unMailableReasonCode) {
    this.unMailableReasonCode = unMailableReasonCode;
  }

  @JsonProperty("mailable")
  public String getMailable() {
    return mailable;
  }

  @JsonProperty("mailable")
  public void setMailable(String mailable) {
    this.mailable = mailable;
  }

  @JsonProperty("createDate")
  public String getCreateDate() {
    return createDate;
  }

  @JsonProperty("createDate")
  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  @JsonProperty("isRegistered")
  public String getIsRegistered() {
    return isRegistered;
  }

  @JsonProperty("isRegistered")
  public void setIsRegistered(String isRegistered) {
    this.isRegistered = isRegistered;
  }

  @JsonProperty("customerId")
  public String getCustomerId() {
    return customerId;
  }

  @JsonProperty("customerId")
  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  @JsonProperty("emailId")
  public String getEmailId() {
    return emailId;
  }

  @JsonProperty("emailId")
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  @JsonProperty("subscriptionDetails")
  public List<SubscriptionDetail> getSubscriptionDetails() {
    return subscriptionDetails;
  }

  @JsonProperty("subscriptionDetails")
  public void setSubscriptionDetails(List<SubscriptionDetail> subscriptionDetails) {
    this.subscriptionDetails = subscriptionDetails;
  }

  @JsonProperty("links")
  public Links[] getLinks() {
    return links;
  }

  @JsonProperty("links")
  public void setLinks(Links[] links) {
    this.links = links;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserSubscriptionDetails that = (UserSubscriptionDetails) o;
    return Objects.equals(unMailableReasonCode, that.unMailableReasonCode)
        && Objects.equals(mailable, that.mailable)
        && Objects.equals(createDate, that.createDate)
        && Objects.equals(isRegistered, that.isRegistered)
        && Objects.equals(customerId, that.customerId)
        && Objects.equals(emailId, that.emailId)
        && Objects.equals(subscriptionDetails, that.subscriptionDetails)
        && Arrays.equals(links, that.links);
  }

  @Override
  public int hashCode() {

    int result =
        Objects.hash(
            unMailableReasonCode,
            mailable,
            createDate,
            isRegistered,
            customerId,
            emailId,
            subscriptionDetails);
    result = 31 * result + Arrays.hashCode(links);
    return result;
  }

  @Override
  public String toString() {
    return "UserSubscriptionDetails{"
        + "unMailableReasonCode='"
        + unMailableReasonCode
        + '\''
        + ", mailable='"
        + mailable
        + '\''
        + ", createDate='"
        + createDate
        + '\''
        + ", isRegistered='"
        + isRegistered
        + '\''
        + ", customerId='"
        + customerId
        + '\''
        + ", emailId='"
        + emailId
        + '\''
        + ", subscriptionDetails="
        + subscriptionDetails
        + ", links="
        + Arrays.toString(links)
        + '}';
  }
}
