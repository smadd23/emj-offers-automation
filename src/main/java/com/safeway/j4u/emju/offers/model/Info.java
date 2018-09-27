package com.safeway.j4u.emju.offers.model;

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
//@Validated
public class Info {
	private Id id;
	private String offerProviderName;
	private Map<String, String> categories; 
	private Map<String, String> primaryCategory;
	private Map<String, String> events;
	@NotNull
	private ProgramCodeType offerProgramCode; 
	private String offerSubProgram;
	@NotNull
	private StatusType offerStatus; 
	private Description description;
	private String productImageId;
	private String priceCode;
	private Boolean isEmployeeOffer;
	private Boolean isDefaultAllocationOffer;
	private String offerProgramType;
	private Boolean shouldReportRedemptions;
	private String promoClassId;
	private AuditInfo auditInfo; 
}
