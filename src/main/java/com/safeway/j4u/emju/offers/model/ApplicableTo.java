package com.safeway.j4u.emju.offers.model;

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
	private Map<@NotNull String, @NotNull String> banners;
	private Map<@NotNull String, @NotNull String> divisions;

	private Set<@NotNull String> storeGroups;
	private Set<@NotNull String> channels;
	private Set<@NotNull String> terminals;
	private Set<@NotNull String> storeIds = new HashSet<>();
	private Set<@NotNull String> postalCodes = new HashSet<>();
	private Set<@NotNull Long> upcs = new HashSet<>();
	private Set<@NotNull String> departments;
}
