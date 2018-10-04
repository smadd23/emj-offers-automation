package com.safeway.j4u.emju.offers.repository;

import com.safeway.j4u.emju.offers.entity.OfferDetails;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface OfferDetailsRepository extends ReactiveCassandraRepository<OfferDetails, Long> {

	@Query("UPDATE offer_details SET offer_status = :status WHERE offer_id IN :offerIds")
	Mono<Boolean> saveStatusByOfferIds(@Param("status") String status, @Param("offerIds") Flux<Long> offerIds);

	@Query("UPDATE offer_details SET offer_status = :status, offer_effective_end_dt = :offerEffectiveEndDate WHERE offer_id IN :offerIds")
	Mono<Boolean> saveStatusAndOfferEffectiveEndDateByOfferIds(@Param("status") String status,
			@Param("offerEffectiveEndDate") ZonedDateTime offerEffectiveEndDate,
			@Param("offerIds") Flux<Long> offerIds);

	@Query("UPDATE offer_details SET offer_status = :status, display_effective_end_dt = :displayEffectiveEndDate WHERE offer_id IN :offerIds")
	Mono<Boolean> saveStatusAndDisplayEffectiveEndDateByOfferIds(@Param("status") String status,
			@Param("displayEffectiveEndDate") ZonedDateTime displayEffectiveEndDate,
			@Param("offerIds") Flux<Long> offerIds);

	Mono<OfferDetails> findByExternalOfferId(String externalOfferId);

	@Query("SELECT * FROM offer_details WHERE external_offer_id IN :externalOfferIds")
	Flux<OfferDetails> findOfferDetailsIdsByExternalOfferIds(@Param("externalOfferIds") Set<String> externalOfferIds);

	@Query("SELECT JSON* FROM offer_details WHERE solr_query = '{\"q\":\"*:*\",\"facet\":{\"field\":[\"offer_program_cd\", \"categories_set\", \"events_set\"]}}'")
	Mono<Optional<String>> findFacetCounts();
}
