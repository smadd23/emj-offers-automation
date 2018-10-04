package com.safeway.j4u.emju.offers.model;

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
	private String offerProviderName;
	private Map<@NotNull String, @NotNull String> categories;
	private Map<@NotNull String, @NotNull String> primaryCategory;
	private Map<@NotNull String, @NotNull String> events;
	@NotNull
	private ProgramCodeType offerProgramCode; 
	private String offerSubProgram;
	private StatusType offerStatus; 
	private Description description;
	private String productImageId;
	private String priceCode;
	private Boolean isEmployeeOffer;
	private Boolean isDefaultAllocationOffer;
	private String offerProgramType;
	private Boolean shouldReportRedemptions;
	private String promoClassId;
	@Valid
	private AuditInfo auditInfo; 
}
