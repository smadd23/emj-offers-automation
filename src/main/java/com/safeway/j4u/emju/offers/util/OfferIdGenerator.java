/***
 * murmur hash 2.0.
 * 
 * The murmur hash is a relatively fast hash function from
 * http://murmurhash.googlepages.com/ for platforms with efficient
 * multiplication.
 * 
 * 
 * This hashing algorithm is used to generate the hash value of random UUID.
 * 
 */
package com.safeway.j4u.emju.offers.util;

import com.google.common.hash.Hashing;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class OfferIdGenerator {

	public long generateOfferId() {

		UUID uuid = UUID.randomUUID();
		log.debug(" uuid value = " +uuid);
		long hash = Math.abs(Hashing.murmur3_128(Integer.valueOf(uuid.hashCode())).hashCode());
		log.debug(" Generated OfferId value = " + hash);
		return hash;
		
	}

}