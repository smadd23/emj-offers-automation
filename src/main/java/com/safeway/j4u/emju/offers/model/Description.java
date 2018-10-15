package com.safeway.j4u.emju.offers.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.Map;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Builder
public class Description {

	@ApiModelProperty(example = "Product Title")
	private String priceTitle;

	@ApiModelProperty(example = "25.34")
	private String priceValue;

	@ApiModelProperty(example = "$11.99 EACH")
	private String savingsValueText;

	@ApiModelProperty(example = "{'titleDsc1': 'Store coupon 00', 'titleDsc2' : 'Group coupon 25'}", dataType = "Map[String,String]")
	private Map<@NotNull String, @NotNull String> titleDescription;

	@ApiModelProperty(example = "{'prodDsc1': 'Always 15 to 66-ct., Depends 10 to 58-ct. or Poise 27 to 66-ct. Limit 4.', 'prodDsc2' : 'Dairy stock 3'}", dataType = "Map[String,String]")
	private Map<@NotNull String, @NotNull String> productDescription;

	@ApiModelProperty(example = "Applicable only in California")
	private String disclaimerText;

	@ApiModelProperty(example = "Lactaid ECOM100500")
	private String receiptDescriptions;
}
