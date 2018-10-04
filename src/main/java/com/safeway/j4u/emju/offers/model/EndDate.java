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
@ToString
@EqualsAndHashCode
@Builder(toBuilder=true)
@Data
public class EndDate {
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO_OFFSET_DATE_TIME)
	private ZonedDateTime displayEffectiveEndDate;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO_OFFSET_DATE_TIME)
	private ZonedDateTime offerEffectiveEndDate;
	// @NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO_OFFSET_DATE_TIME)
	private ZonedDateTime offerTestEffectiveEndDate;
}
