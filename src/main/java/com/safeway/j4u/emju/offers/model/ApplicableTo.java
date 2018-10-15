package com.safeway.j4u.emju.offers.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
public class ApplicableTo {
	@ApiModelProperty(example = "{'S': '332c9360-a75e-11e6-80f5-76304dec7eb7', 'V' : '332c9360-a75e-11e6-80f5-76304dec7eb1'}", dataType = "Map[String,String]")
	private Map<@NotNull String, @NotNull String> banners;

	@ApiModelProperty(example = "{'24': 'NORCAL', '25' : 'SOCAL'}", dataType = "Map[String,String]")
	private Map<@NotNull String, @NotNull String> divisions;

	@ApiModelProperty(example = "['7642', '7643']", dataType="List[String]")
	private Set<@NotNull String> storeGroups;

	@ApiModelProperty(example = "['Channel1', 'Channel2']", dataType="Set[String]")
	private Set<@NotNull String> channels;

	@ApiModelProperty(example = "['11407', '11406', '15', '11401', '11411']", dataType="Set[String]")
	private Set<@NotNull String> terminals;

	@ApiModelProperty(example = "['908', '909', '4178', '1583']", dataType="Set[String]")
	private Set<@NotNull String> storeIds = new HashSet<>();

	@ApiModelProperty(example = "['94539', '90278']", dataType="Set[String]")
	private Set<@NotNull String> postalCodes = new HashSet<>();

	@ApiModelProperty(example = "['1234567890', '5687567890']", dataType="Set[String]")
	private Set<@NotNull Long> upcs = new HashSet<>();

	@ApiModelProperty(example = "['Dept1', 'Dept2']", dataType="Set[String]")
	private Set<@NotNull String> departments;
}
