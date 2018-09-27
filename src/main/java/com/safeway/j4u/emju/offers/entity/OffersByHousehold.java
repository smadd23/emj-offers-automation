package com.safeway.j4u.emju.offers.entity;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Builder
@Table("offers_by_household")
public class OffersByHousehold {

	@PrimaryKey("household_id")
	private Long householdId;
	@Column("offers_info_")
	private Map<String, String> offersInfo;

}
