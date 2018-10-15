package com.safeway.j4u.emju.offers.mapper;

import com.safeway.j4u.emju.offers.entity.OfferDetails;
import com.safeway.j4u.emju.offers.helpers.OfferHelper;
import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.model.ProgramCodeType;
import com.safeway.j4u.emju.offers.model.StatusType;
import java.util.HashSet;
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
public class OfferDetailsMapperComponentTest {

	@Autowired
	private OfferDetailsToOfferMapper offerDetailsToOfferMapper;

	@Before
	public void before() throws Exception {

	}

	@Test
	public void map()
	{
		OfferDetails sourceObject = OfferHelper.createOfferDetails("2510N0817H05_825555", 1044L,
				ProgramCodeType.MF, StatusType.P, "2018-09-01T00:00:01.235-07:00",
				"2018-11-01T00:00:01.235-07:00", "AB", new HashSet<Integer>() {
					{
						add(94086);
						add(63043);
					}
				}, new HashSet<String>() {
					{
						add("100100");
						add("200200");
						add("300300");
					}
				});
		
		Offer destObject = offerDetailsToOfferMapper.toOffer(sourceObject);
	}

}
