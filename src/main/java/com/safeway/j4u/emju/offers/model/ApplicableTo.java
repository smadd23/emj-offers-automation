package com.safeway.j4u.emju.offers.model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
	private Map<String, String> banners;
	private Map<String, String> divisions;
	private Set<String> storeGroups;
	private Set<String> channels;
	private Set<String> terminals;
	private Set<String> storeIds = new HashSet<>();
	private Set<String> postalCodes = new HashSet<>();
	private Set<Integer> upcs = new HashSet<>();
	private Set<String> departments;
}
