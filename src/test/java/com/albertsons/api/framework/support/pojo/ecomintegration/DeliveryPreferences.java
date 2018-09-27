package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;

/**
 * This class contains the pojo representation of delivery preferences.
 *
 * @author vbonk00
 */
@JsonIgnoreProperties("ack")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "ack",
  "AddressModel",
  "DriveUpAndGoIsEnabled",
  "UnattendedDeliveryIsEnabled",
  "DeliveryPreference",
  "dugStores"
})
public class DeliveryPreferences {

  @JsonProperty("ack")
  private Boolean ack = false;

  @JsonProperty("AddressModel")
  private AddressModel addressModel;

  @JsonProperty("DriveUpAndGoIsEnabled")
  private Boolean driveUpAndGoIsEnabled = false;

  @JsonProperty("UnattendedDeliveryIsEnabled")
  private Boolean unattendedDeliveryIsEnabled = false;

  @JsonProperty("DeliveryPreference")
  private String deliveryPreference = "";

  @JsonProperty("dugStores")
  private List<DugStore> dugStores = null;

  @JsonProperty("ack")
  public Boolean getAck() {
    return ack;
  }

  @JsonProperty("ack")
  public void setAck(Boolean ack) {
    this.ack = ack;
  }

  @JsonProperty("AddressModel")
  public AddressModel getAddressModel() {
    return addressModel;
  }

  @JsonProperty("AddressModel")
  public void setAddressModel(AddressModel addressModel) {
    this.addressModel = addressModel;
  }

  @JsonProperty("DriveUpAndGoIsEnabled")
  public Boolean getDriveUpAndGoIsEnabled() {
    return driveUpAndGoIsEnabled;
  }

  @JsonProperty("DriveUpAndGoIsEnabled")
  public void setDriveUpAndGoIsEnabled(Boolean driveUpAndGoIsEnabled) {
    this.driveUpAndGoIsEnabled = driveUpAndGoIsEnabled;
  }

  @JsonProperty("UnattendedDeliveryIsEnabled")
  public Boolean getUnattendedDeliveryIsEnabled() {
    return unattendedDeliveryIsEnabled;
  }

  @JsonProperty("UnattendedDeliveryIsEnabled")
  public void setUnattendedDeliveryIsEnabled(Boolean unattendedDeliveryIsEnabled) {
    this.unattendedDeliveryIsEnabled = unattendedDeliveryIsEnabled;
  }

  @JsonProperty("DeliveryPreference")
  public String getDeliveryPreference() {
    return deliveryPreference;
  }

  @JsonProperty("DeliveryPreference")
  public void setDeliveryPreference(String deliveryPreference) {
    this.deliveryPreference = deliveryPreference;
  }

  @JsonProperty("dugStores")
  public List<DugStore> getDugStores() {
    return dugStores;
  }

  @JsonProperty("dugStores")
  public void setDugStores(List<DugStore> dugStores) {
    this.dugStores = dugStores;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DeliveryPreferences that = (DeliveryPreferences) o;
    return Objects.equal(ack, that.ack)
        && Objects.equal(addressModel, that.addressModel)
        && Objects.equal(driveUpAndGoIsEnabled, that.driveUpAndGoIsEnabled)
        && Objects.equal(unattendedDeliveryIsEnabled, that.unattendedDeliveryIsEnabled)
        && Objects.equal(deliveryPreference, that.deliveryPreference)
        && Objects.equal(dugStores, that.dugStores);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        ack,
        addressModel,
        driveUpAndGoIsEnabled,
        unattendedDeliveryIsEnabled,
        deliveryPreference,
        dugStores);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ack", ack)
        .add("addressModel", addressModel)
        .add("driveUpAndGoIsEnabled", driveUpAndGoIsEnabled)
        .add("unattendedDeliveryIsEnabled", unattendedDeliveryIsEnabled)
        .add("deliveryPreference", deliveryPreference)
        .add("dugStores", dugStores)
        .toString();
  }
}
