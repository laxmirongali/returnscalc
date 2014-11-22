package com.company.fingoals.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.TestCase;

import com.company.fingoals.dto.HoldingsGroup;
//import com.company.fingoals.dto.Holding;
import com.company.fingoals.dto.ReturnsCalculatorData;

public class ReturnsCalculaterTest extends TestCase {

	public void testCalculateReturn() throws Exception {

		ReturnsCalculatorData data = new ReturnsCalculatorData();
		
		ReturnsCalculator calc = new ReturnsCalculator();
		
		//Holding holding = new Holding();
		
		//List<Holding> holdings = new ArrayList<Holding>();
		
		//HoldingsGroup hg = new HoldingsGroup();
		
		
		data.setSymbol("AAPL");
		
		data.setFromDate(new GregorianCalendar(2014, 0, 1) );
		
		data.setAmount(new BigDecimal(1000));
		
		data.setDayOfTheMonth(15);
		
		data.setToDate(new GregorianCalendar(2014,4,20));
		
		calc.setReturnsCalculatorData(data);
		
		HoldingsGroup hdg = calc.calculateReturn();

		assertNotNull("This method is incomplete", hdg);
	}
	
	public void testDayOfTheMonthDates() throws Exception{
		
		ReturnsCalculatorData data = new ReturnsCalculatorData(); 
		
		ReturnsCalculator calc = new ReturnsCalculator();
		
		data.setFromDate(new GregorianCalendar(2012, 0, 1));
		data.setToDate(new GregorianCalendar(2013,11,10));
		data.setDayOfTheMonth(5);
		
		calc.setReturnsCalculatorData(data);
		
		List<Calendar> dates = calc.dayOfTheMonthDates();
		
		assertEquals(24, dates.size());
		
		Calendar cal = dates.get(0);
		
		assertNotNull("First object cannot be null",cal);
		
		Calendar expCal = new GregorianCalendar(2012,0,5);
		
		assertEquals(expCal,cal);
		expCal = new GregorianCalendar(2012,0,6);
		
		assertNotSame(expCal,cal);
		
		cal = dates.get(11);
		
		assertNotNull("Twelth object cannot be null",cal);
		
		expCal = new GregorianCalendar(2012,11,5);
		
		assertEquals(expCal,cal);
		expCal = new GregorianCalendar(2012,0,6);
		
		assertNotSame(expCal,cal);
	}
	
	

}
