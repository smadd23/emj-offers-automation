package com.safeway.j4u.emju.offers.model;

import static com.safeway.j4u.emju.offers.util.OffersConstants.ISO_OFFSET_DATE_TIME;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.ZonedDateTime;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Builder
@ToString
public class AuditInfo {

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO_OFFSET_DATE_TIME)
	private ZonedDateTime createdTs;
	private String createdApplicationId;
	private String createdUserId;
	private String lastUpdatedApplicationId;
	private String lastUpdatedUserId;
	// @NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO_OFFSET_DATE_TIME)
	private ZonedDateTime lastUpdatedTs;
}
