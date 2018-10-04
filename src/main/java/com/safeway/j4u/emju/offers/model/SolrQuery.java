package com.safeway.j4u.emju.offers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SolrQuery {

	private String q;
	private String paging;
}
