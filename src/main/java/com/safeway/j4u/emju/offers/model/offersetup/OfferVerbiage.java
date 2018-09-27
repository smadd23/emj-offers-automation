package com.safeway.j4u.emju.offers.model.offersetup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlAccessorType(XmlAccessType.NONE)
public class OfferVerbiage {
	@XmlElement(name="TitleLine1Description")
	private String titleLine1Description;
	@XmlElement(name="TitleLine2Description")
	private String titleLine2Description;
	@XmlElement(name="ProductLine1Description")
	private String productLine1Description;
	@XmlElement(name="SavingsValueText")
	private String savingsValueText;
	@XmlElement(name="PriceTitle1Text")
	private String priceTitle1Text;
	@XmlElement(name="PriceValue1Text")
	private String priceValue1Text;
	@XmlElement(name="DisclaimerText")
	private String disclaimerText;
}
