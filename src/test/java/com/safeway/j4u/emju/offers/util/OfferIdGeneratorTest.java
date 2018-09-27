package com.safeway.j4u.emju.offers.util;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.hash.Hashing;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class OfferIdGeneratorTest {

	@Autowired
	private OfferIdGenerator offerIdGenerator;

	@Test
	public void testgenerateOfferId() {
		String uuid  = "820c567a-7fc8-4046-a084-f93dc93f8224";
		long offerId = offerIdGenerator.generateOfferId();
		assertEquals("Hashing.murmur3_128(0)", Hashing.murmur3_128().toString());
	}

}