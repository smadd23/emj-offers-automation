package com.safeway.j4u.emju.offers.model;

import static com.safeway.j4u.emju.offers.util.OffersConstants.ISO_OFFSET_DATE_TIME;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(example = "2018-08-17T00:00:45.000-07:00", value="yyyy-MM-dd'T'HH:mm:ss.SSS[xxx]")
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO_OFFSET_DATE_TIME)
	private ZonedDateTime displayEffectiveEndDate;

	@ApiModelProperty(example = "2018-08-17T00:00:45.000-07:00", value="yyyy-MM-dd'T'HH:mm:ss.SSS[xxx]")
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO_OFFSET_DATE_TIME)
	private ZonedDateTime offerEffectiveEndDate;

	@ApiModelProperty(example = "2018-08-17T00:00:45.000-07:00", value="yyyy-MM-dd'T'HH:mm:ss.SSS[xxx]")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO_OFFSET_DATE_TIME)
	private ZonedDateTime offerTestEffectiveEndDate;
}
