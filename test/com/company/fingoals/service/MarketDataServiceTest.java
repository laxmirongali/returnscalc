package com.company.fingoals.service;

import java.math.BigDecimal;

import com.company.fingoals.dto.Quote;

import junit.framework.TestCase;

public class MarketDataServiceTest extends TestCase {

	public void testGetLastTradePrice() throws Exception {

		MarketDataService mds = new MarketDataService();

		Quote q = mds.getQuote("NFLX");
		BigDecimal currPrice = q.getAdjClose();

		assertNotNull("Value cannot be null ", currPrice);
		System.out.println(q.getSymbol());
		assertNotNull(q.getSymbol());
		System.out.println(q.getCompanyName());
		assertNotNull(q.getCompanyName());
		

	}

}
