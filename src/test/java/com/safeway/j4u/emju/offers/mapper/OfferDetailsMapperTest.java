package com.safeway.j4u.emju.offers.mapper;

import static org.junit.Assert.assertEquals;

import com.safeway.j4u.emju.offers.entity.OfferDetails;
import com.safeway.j4u.emju.offers.mapper.OfferDetailsMapper;
import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.testdata.TestData;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class OfferDetailsMapperTest {
	
	@Autowired
	private OfferDetailsMapper offerDetailsMapper;
	
	@Before
	public void before() throws Exception {
		
	}
	
	@Test
	public void map()
	{
		OfferDetails sourceObject = TestData.createOfferDetails(104L);		
		
		Offer destObject = offerDetailsMapper.toOffer(sourceObject);
	}

}
