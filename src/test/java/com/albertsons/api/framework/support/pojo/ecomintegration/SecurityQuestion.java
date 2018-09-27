package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of security questions.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"q1", "q2", "q3", "q4", "q5"})
public class SecurityQuestion {

  @JsonProperty("q1")
  private String q1;

  @JsonProperty("q2")
  private String q2;

  @JsonProperty("q3")
  private String q3;

  @JsonProperty("q4")
  private String q4;

  @JsonProperty("q5")
  private String q5;

  @JsonProperty("q1")
  public String getQ1() {
    return q1;
  }

  @JsonProperty("q1")
  public void setQ1(String q1) {
    this.q1 = q1;
  }

  @JsonProperty("q2")
  public String getQ2() {
    return q2;
  }

  @JsonProperty("q2")
  public void setQ2(String q2) {
    this.q2 = q2;
  }

  @JsonProperty("q3")
  public String getQ3() {
    return q3;
  }

  @JsonProperty("q3")
  public void setQ3(String q3) {
    this.q3 = q3;
  }

  @JsonProperty("q4")
  public String getQ4() {
    return q4;
  }

  @JsonProperty("q4")
  public void setQ4(String q4) {
    this.q4 = q4;
  }

  @JsonProperty("q5")
  public String getQ5() {
    return q5;
  }

  @JsonProperty("q5")
  public void setQ5(String q5) {
    this.q5 = q5;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SecurityQuestion)) return false;
    SecurityQuestion that = (SecurityQuestion) o;
    return Objects.equal(getQ1(), that.getQ1())
        && Objects.equal(getQ2(), that.getQ2())
        && Objects.equal(getQ3(), that.getQ3())
        && Objects.equal(getQ4(), that.getQ4())
        && Objects.equal(getQ5(), that.getQ5());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getQ1(), getQ2(), getQ3(), getQ4(), getQ5());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("q1", q1)
        .add("q2", q2)
        .add("q3", q3)
        .add("q4", q4)
        .add("q5", q5)
        .toString();
  }
}
