package com.company.fingoals.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.TestCase;

import com.company.fingoals.dto.Holding;
import com.company.fingoals.dto.HoldingsGroup;

public class HoldingsGroupTest extends TestCase {

	public HoldingsGroupTest() {
		// TODO Auto-generated constructor stub
	}
	
	public void testGetTotalQuantity() throws Exception {
		HoldingsGroup hg = new HoldingsGroup();
		Holding holding = new Holding();
		
		List<Holding> holdings = new ArrayList<Holding>();
		
		holding.setQuantity(new BigDecimal(10));
		holdings.add(holding);
		
		holding = new Holding();
		holding.setQuantity(new BigDecimal(15));
		holdings.add(holding);
		
		holding = new Holding();
		holding.setQuantity(new BigDecimal(12));
		holdings.add(holding);
		
		hg.setHoldings(holdings);
		
		BigDecimal quantity = hg.getTotalQuantity();
		
		BigDecimal bd = new BigDecimal(37);
		
		assertEquals(bd, quantity);
		
		
	}
	
	public void testGetTotalInvestedAmount() throws Exception {
		HoldingsGroup hg = new HoldingsGroup();
		Holding holding = new Holding();
		
		List<Holding> holdings = new ArrayList<Holding>();
		
		holding.setInvestedPrice(new BigDecimal(100));
		holding.setQuantity(new BigDecimal(10));
		holdings.add(holding);
		
		holding = new Holding();
		holding.setInvestedPrice(new BigDecimal(100));
		holding.setQuantity(new BigDecimal(10));
		holdings.add(holding);
		
		holding = new Holding();
		holding.setInvestedPrice(new BigDecimal(100));
		holding.setQuantity(new BigDecimal(10));
		holdings.add(holding);
		
		hg.setHoldings(holdings);
		
		BigDecimal totInveAmount = hg.getTotalInvestedAmount();
		
		BigDecimal bd = new BigDecimal(3000);
		bd = bd.setScale(2);
		
		assertEquals(bd, totInveAmount);
	}
	
	public void testGetCurrentValue() throws Exception {
		HoldingsGroup hg = new HoldingsGroup();
		Holding holding = new Holding();
		
		List<Holding> holdings = new ArrayList<Holding>();
		
		holding.setCurrentPrice(new BigDecimal(110));
		holdings.add(holding);
		
		holding = new Holding();
		holding.setCurrentPrice(new BigDecimal(110));
		holdings.add(holding);
		
		holding = new Holding();
		holding.setCurrentPrice(new BigDecimal(110));
		holdings.add(holding);
		
		hg.setHoldings(holdings);
		
		BigDecimal currValue = hg.getCurrentPrice();
		
		BigDecimal bd = new BigDecimal(110);
		bd = bd.setScale(2);
		
		assertEquals(bd, currValue);
	}
	
	public void testGetOverallGain() throws Exception {
		HoldingsGroup hg = new HoldingsGroup();
		Holding holding = new Holding();
		
		List<Holding> holdings = new ArrayList<Holding>();
		
		holding.setQuantity(new BigDecimal(10));
		holding.setInvestedPrice(new BigDecimal(100));
		holding.setCurrentPrice(new BigDecimal(110));
		holdings.add(holding);
		
		holding = new Holding();
		holding.setQuantity(new BigDecimal(10));
		holding.setInvestedPrice(new BigDecimal(100));
		holding.setCurrentPrice(new BigDecimal(110));
		holdings.add(holding);
		
		holding = new Holding();
		holding.setQuantity(new BigDecimal(10));
		holding.setInvestedPrice(new BigDecimal(100));
		holding.setCurrentPrice(new BigDecimal(110));
		holdings.add(holding);
		
		hg.setHoldings(holdings);
		
		BigDecimal overallGain = hg.getOverallGain();
		
		BigDecimal bd = new BigDecimal(300);
		bd = bd.setScale(2);
		
		assertEquals(bd, overallGain);
	}
	
	public void testOverallGainPercent() throws Exception {
		HoldingsGroup hg = new HoldingsGroup();
		Holding holding = new Holding();
		
		List<Holding> holdings = new ArrayList<Holding>();
		
		holding.setQuantity(new BigDecimal(10));
		holding.setInvestedPrice(new BigDecimal(100));
		holding.setCurrentPrice(new BigDecimal(110));
		holdings.add(holding);
		
		holding = new Holding();
		holding.setQuantity(new BigDecimal(10));
		holding.setInvestedPrice(new BigDecimal(100));
		holding.setCurrentPrice(new BigDecimal(110));
		holdings.add(holding);
		
		holding = new Holding();
		holding.setQuantity(new BigDecimal(10));
		holding.setInvestedPrice(new BigDecimal(100));
		holding.setCurrentPrice(new BigDecimal(110));
		holdings.add(holding);
		
		hg.setHoldings(holdings);
		
		BigDecimal overallGainPercent = hg.getOverallGainPercent();
		
		BigDecimal bd = new BigDecimal(10);
		bd = bd.setScale(2);
		
		assertEquals(bd, overallGainPercent);
	}
	
	public void testGetXIRR() throws Exception {
		HoldingsGroup hg = new HoldingsGroup();
		Holding holding = new Holding();
		
		List<Holding> holdings = new ArrayList<Holding>();
		
		holding.setInvestedDate(new GregorianCalendar(2008,0,3));
		holding.setInvestedPrice(new BigDecimal(55.87));
		//holding.setQuantity(new BigDecimal(10));
		holding.setCurrentPrice(new BigDecimal(110));
		holdings.add(holding);
		
		holding = new Holding();
		holding.setInvestedDate(new GregorianCalendar(2010,9,22));
		holding.setInvestedPrice(new BigDecimal(102.99));
		/*holding.setQuantity(new BigDecimal(10));
		holding.setCurrentPrice(new BigDecimal(110));*/
		holdings.add(holding);
		
		holding = new Holding();
		holding.setInvestedDate(new GregorianCalendar(2011,9,23));
		holding.setInvestedPrice(new BigDecimal(104.83));
		//holding.setQuantity(new BigDecimal(10));
		//holding.setCurrentPrice(new BigDecimal(110));
		holdings.add(holding);
		
		holding = new Holding();
		holding.setInvestedDate(new GregorianCalendar(2012,9,24));
		holding.setInvestedPrice(new BigDecimal(105.22));
		//holding.setQuantity(new BigDecimal(10));
		//holding.setCurrentPrice(new BigDecimal(110));
		holdings.add(holding);
		
		holding = new Holding();
		holding.setInvestedDate(new GregorianCalendar(2014,9,28));
		holding.setInvestedPrice(new BigDecimal(-500));
		//holding.setQuantity(new BigDecimal(10));
		//holding.setCurrentPrice(new BigDecimal(110));
		holdings.add(holding);
		//where are you adding holdings list to group -hg?
		//do u agree?
		hg.setHoldings(holdings);
	
		double xirr = hg.getXIRR();
		System.out.println("XIRR :" +xirr);
		assertNotNull(xirr);
	}
	
	

}
