package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of how recommended during user creation.
 *
 * @author vkuma26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"1", "2", "3", "4", "5", "6", "7", "8", "9"})
public class HowRecommended {

  @JsonProperty("1")
  private String _1;

  @JsonProperty("2")
  private String _2;

  @JsonProperty("3")
  private String _3;

  @JsonProperty("4")
  private String _4;

  @JsonProperty("5")
  private String _5;

  @JsonProperty("6")
  private String _6;

  @JsonProperty("7")
  private String _7;

  @JsonProperty("8")
  private String _8;

  @JsonProperty("9")
  private String _9;

  @JsonProperty("1")
  public String get1() {
    return _1;
  }

  @JsonProperty("1")
  public void set1(String _1) {
    this._1 = _1;
  }

  @JsonProperty("2")
  public String get2() {
    return _2;
  }

  @JsonProperty("2")
  public void set2(String _2) {
    this._2 = _2;
  }

  @JsonProperty("3")
  public String get3() {
    return _3;
  }

  @JsonProperty("3")
  public void set3(String _3) {
    this._3 = _3;
  }

  @JsonProperty("4")
  public String get4() {
    return _4;
  }

  @JsonProperty("4")
  public void set4(String _4) {
    this._4 = _4;
  }

  @JsonProperty("5")
  public String get5() {
    return _5;
  }

  @JsonProperty("5")
  public void set5(String _5) {
    this._5 = _5;
  }

  @JsonProperty("6")
  public String get6() {
    return _6;
  }

  @JsonProperty("6")
  public void set6(String _6) {
    this._6 = _6;
  }

  @JsonProperty("7")
  public String get7() {
    return _7;
  }

  @JsonProperty("7")
  public void set7(String _7) {
    this._7 = _7;
  }

  @JsonProperty("8")
  public String get8() {
    return _8;
  }

  @JsonProperty("8")
  public void set8(String _8) {
    this._8 = _8;
  }

  @JsonProperty("9")
  public String get9() {
    return _9;
  }

  @JsonProperty("9")
  public void set9(String _9) {
    this._9 = _9;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof HowRecommended)) return false;
    HowRecommended that = (HowRecommended) o;
    return Objects.equal(_1, that._1)
        && Objects.equal(_2, that._2)
        && Objects.equal(_3, that._3)
        && Objects.equal(_4, that._4)
        && Objects.equal(_5, that._5)
        && Objects.equal(_6, that._6)
        && Objects.equal(_7, that._7)
        && Objects.equal(_8, that._8)
        && Objects.equal(_9, that._9);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(_1, _2, _3, _4, _5, _6, _7, _8, _9);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("_1", _1)
        .add("_2", _2)
        .add("_3", _3)
        .add("_4", _4)
        .add("_5", _5)
        .add("_6", _6)
        .add("_7", _7)
        .add("_8", _8)
        .add("_9", _9)
        .toString();
  }
}
