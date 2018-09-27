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
public class CustomerFriendlyCategory {
	@XmlElement(name="ShoppingListCFCategoryId")
	private String shoppingListCFCategoryId;
	@XmlElement(name="ShoppingListCFCategoryName")
	private String shoppingListCFCategoryName;
}
