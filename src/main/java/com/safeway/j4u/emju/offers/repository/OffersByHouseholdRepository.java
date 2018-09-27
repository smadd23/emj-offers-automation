package com.safeway.j4u.emju.offers.repository;

import com.safeway.j4u.emju.offers.entity.OffersByHousehold;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface OffersByHouseholdRepository extends ReactiveCassandraRepository<OffersByHousehold, Long> {
	
}
