package com.safeway.j4u.emju.offers.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.Map;
import javax.validation.Valid;
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
public class Info {
	private Id id;
	@ApiModelProperty(example="NextGenStoreCpns")
	private String offerProviderName;

	@ApiModelProperty(example = "{'17': 'Personal Care & Health', '18' : 'Bakery & Bread'}", dataType = "Map[String,String]")
	private Map<@NotNull String, @NotNull String> categories;

	@ApiModelProperty(example = "{'6': 'High Consumer Products', '10': 'Personal Care Products'}", dataType = "Map[String,String]")
	private Map<@NotNull String, @NotNull String> primaryCategory;

	@ApiModelProperty(example = "{'125': 'Weekly Ad Coupons', '400': 'Labour Day Deals'}", dataType = "Map[String,String]")
	private Map<@NotNull String, @NotNull String> events;

	@ApiModelProperty(example = "SC|MF|PD")
	@NotNull
	private ProgramCodeType offerProgramCode;

	@ApiModelProperty(example = "02")
	private String offerSubProgram;

	@ApiModelProperty(example = "A|D|E|L|O|P")
	private StatusType offerStatus;

	private Description description;

	@ApiModelProperty(example = "DAI2345")
	private String productImageId;

	@ApiModelProperty(example = "80", notes = "Applicable only for PD deals")
	private String priceCode;

	@ApiModelProperty(example = "false")
	private Boolean isEmployeeOffer;

	@ApiModelProperty(example = "false")
	private Boolean isDefaultAllocationOffer;

	@ApiModelProperty(example = "SPC", notes = "Applicable only for PD deals")
	private String offerProgramType;

	@ApiModelProperty(example = "false")
	private Boolean shouldReportRedemptions;

	@ApiModelProperty(example = "coupon")
	private String promoClassId;

	@Valid
	private AuditInfo auditInfo; 
}
