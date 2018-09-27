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
@JsonPropertyOrder({"name", "planNumber", "enrollmentDate"})
public class LoyaltyPartner {

  @JsonProperty("name")
  private String name;

  @JsonProperty("planNumber")
  private String planNumber;

  @JsonProperty("enrollmentDate")
  private String enrollmentDate;

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("planNumber")
  public String getPlanNumber() {
    return planNumber;
  }

  @JsonProperty("planNumber")
  public void setPlanNumber(String planNumber) {
    this.planNumber = planNumber;
  }

  @JsonProperty("enrollmentDate")
  public String getEnrollmentDate() {
    return enrollmentDate;
  }

  @JsonProperty("enrollmentDate")
  public void setEnrollmentDate(String enrollmentDate) {
    this.enrollmentDate = enrollmentDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LoyaltyPartner that = (LoyaltyPartner) o;
    return Objects.equals(name, that.name)
        && Objects.equals(planNumber, that.planNumber)
        && Objects.equals(enrollmentDate, that.enrollmentDate);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name, planNumber, enrollmentDate);
  }

  @Override
  public String toString() {
    return "LoyaltyPartner{"
        + "name='"
        + name
        + '\''
        + ", planNumber='"
        + planNumber
        + '\''
        + ", enrollmentDate='"
        + enrollmentDate
        + '\''
        + '}';
  }
}
