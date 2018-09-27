package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

/**
 * This class contains the pojo representation of Subscription Details.
 *
 * @author vkuma26
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "subscriptionCode",
    "createSourceCode",
    "createSourceName",
    "lastUpdateSourceCode",
    "lastUpdateSourceName",
    "createDate",
    "lastUpdateDate",
    "subscriptionStatusCode",
    "subscriptionStatusName",
    "oldSubscriptionStatusCode"
})
public class SubscriptionDetail {

  @JsonProperty("subscriptionCode")
  private String subscriptionCode;

  @JsonProperty("createSourceCode")
  private String createSourceCode;

  @JsonProperty("createSourceName")
  private String createSourceName;

  @JsonProperty("lastUpdateSourceCode")
  private String lastUpdateSourceCode;

  @JsonProperty("lastUpdateSourceName")
  private String lastUpdateSourceName;

  @JsonProperty("createDate")
  private String createDate;

  @JsonProperty("lastUpdateDate")
  private String lastUpdateDate;

  @JsonProperty("subscriptionStatusCode")
  private String subscriptionStatusCode;

  @JsonProperty("subscriptionStatusName")
  private String subscriptionStatusName;

  @JsonProperty("oldSubscriptionStatusCode")
  private String oldSubscriptionStatusCode;

  @JsonProperty("subscriptionCode")
  public String getSubscriptionCode() {
    return subscriptionCode;
  }

  @JsonProperty("subscriptionCode")
  public void setSubscriptionCode(String subscriptionCode) {
    this.subscriptionCode = subscriptionCode;
  }

  @JsonProperty("createSourceCode")
  public String getCreateSourceCode() {
    return createSourceCode;
  }

  @JsonProperty("createSourceCode")
  public void setCreateSourceCode(String createSourceCode) {
    this.createSourceCode = createSourceCode;
  }

  @JsonProperty("createSourceName")
  public String getCreateSourceName() {
    return createSourceName;
  }

  @JsonProperty("createSourceName")
  public void setCreateSourceName(String createSourceName) {
    this.createSourceName = createSourceName;
  }

  @JsonProperty("lastUpdateSourceCode")
  public String getLastUpdateSourceCode() {
    return lastUpdateSourceCode;
  }

  @JsonProperty("lastUpdateSourceCode")
  public void setLastUpdateSourceCode(String lastUpdateSourceCode) {
    this.lastUpdateSourceCode = lastUpdateSourceCode;
  }

  @JsonProperty("lastUpdateSourceName")
  public String getLastUpdateSourceName() {
    return lastUpdateSourceName;
  }

  @JsonProperty("lastUpdateSourceName")
  public void setLastUpdateSourceName(String lastUpdateSourceName) {
    this.lastUpdateSourceName = lastUpdateSourceName;
  }

  @JsonProperty("createDate")
  public String getCreateDate() {
    return createDate;
  }

  @JsonProperty("createDate")
  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  @JsonProperty("lastUpdateDate")
  public String getLastUpdateDate() {
    return lastUpdateDate;
  }

  @JsonProperty("lastUpdateDate")
  public void setLastUpdateDate(String lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }

  @JsonProperty("subscriptionStatusCode")
  public String getSubscriptionStatusCode() {
    return subscriptionStatusCode;
  }

  @JsonProperty("subscriptionStatusCode")
  public void setSubscriptionStatusCode(String subscriptionStatusCode) {
    this.subscriptionStatusCode = subscriptionStatusCode;
  }

  @JsonProperty("subscriptionStatusName")
  public String getSubscriptionStatusName() {
    return subscriptionStatusName;
  }

  @JsonProperty("subscriptionStatusName")
  public void setSubscriptionStatusName(String subscriptionStatusName) {
    this.subscriptionStatusName = subscriptionStatusName;
  }

  @JsonProperty("oldSubscriptionStatusCode")
  public String getOldSubscriptionStatusCode() {
    return oldSubscriptionStatusCode;
  }

  @JsonProperty("oldSubscriptionStatusCode")
  public void setOldSubscriptionStatusCode(String oldSubscriptionStatusCode) {
    this.oldSubscriptionStatusCode = oldSubscriptionStatusCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SubscriptionDetail that = (SubscriptionDetail) o;
    return Objects.equals(subscriptionCode, that.subscriptionCode)
        && Objects.equals(createSourceCode, that.createSourceCode)
        && Objects.equals(createSourceName, that.createSourceName)
        && Objects.equals(lastUpdateSourceCode, that.lastUpdateSourceCode)
        && Objects.equals(lastUpdateSourceName, that.lastUpdateSourceName)
        && Objects.equals(createDate, that.createDate)
        && Objects.equals(lastUpdateDate, that.lastUpdateDate)
        && Objects.equals(subscriptionStatusCode, that.subscriptionStatusCode)
        && Objects.equals(subscriptionStatusName, that.subscriptionStatusName)
        && Objects.equals(oldSubscriptionStatusCode, that.oldSubscriptionStatusCode);
  }

  @Override
  public int hashCode() {

    return Objects.hash(
        subscriptionCode,
        createSourceCode,
        createSourceName,
        lastUpdateSourceCode,
        lastUpdateSourceName,
        createDate,
        lastUpdateDate,
        subscriptionStatusCode,
        subscriptionStatusName,
        oldSubscriptionStatusCode);
  }

  @Override
  public String toString() {
    return "SubscriptionDetail{"
        + "subscriptionCode='"
        + subscriptionCode
        + '\''
        + ", createSourceCode='"
        + createSourceCode
        + '\''
        + ", createSourceName='"
        + createSourceName
        + '\''
        + ", lastUpdateSourceCode='"
        + lastUpdateSourceCode
        + '\''
        + ", lastUpdateSourceName='"
        + lastUpdateSourceName
        + '\''
        + ", createDate='"
        + createDate
        + '\''
        + ", lastUpdateDate='"
        + lastUpdateDate
        + '\''
        + ", subscriptionStatusCode='"
        + subscriptionStatusCode
        + '\''
        + ", subscriptionStatusName='"
        + subscriptionStatusName
        + '\''
        + ", oldSubscriptionStatusCode='"
        + oldSubscriptionStatusCode
        + '\''
        + '}';
  }
}
