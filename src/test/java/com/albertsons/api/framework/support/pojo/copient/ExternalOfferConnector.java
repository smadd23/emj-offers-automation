package com.albertsons.api.framework.support.pojo.copient;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class contains the pojo representation of External Offer Connecter.
 *
 * @author nisla10
 */
@XmlRootElement(name = "ExternalOfferConnector")
public class ExternalOfferConnector {
 
  private Offers Offers;
  private Errors Errors;

  @XmlElement(name = "Offer")
  public Offers getOffers() {
    return Offers;
  }

  public void setOffers(Offers Offers) {
    this.Offers = Offers;
  }

  @XmlElement(name = "Error")
  public Errors getErrors() {
    return Errors;
  }

  public void setErrors(Errors Errors) {
    this.Errors = Errors;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ExternalOfferConnector that = (ExternalOfferConnector) o;
    return Objects.equal(Offers, that.Offers) &&
            Objects.equal(Errors, that.Errors);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(Offers, Errors);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
            .add("Offers", Offers)
            .add("Errors", Errors)
            .toString();
  }
}
