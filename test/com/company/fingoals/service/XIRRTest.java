package com.company.fingoals.service;

import in.satpathy.financial.XIRR;
import in.satpathy.financial.XIRRData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.TestCase;

public class XIRRTest extends TestCase {

	public XIRRTest() {
		// TODO Auto-generated constructor stub
	}
	
	public void testXIRR() throws Exception {
		
		List<Calendar> lCal = new ArrayList<Calendar>();
		List<BigDecimal> lVal = new ArrayList<BigDecimal>();
		
		lCal.add(new GregorianCalendar(2008,0,3));
		lVal.add(new BigDecimal(55.87));
		
		lCal.add(new GregorianCalendar(2010,9,22));
		lVal.add(new BigDecimal(102.99));
		
		lCal.add(new GregorianCalendar(2011,9,23));
		lVal.add(new BigDecimal(104.83));
		
		lCal.add(new GregorianCalendar(2012,9,24));
		lVal.add(new BigDecimal(105.22));
		
		lCal.add(new GregorianCalendar(2014,9,28));
		lVal.add(new BigDecimal(-500));
		
		double[] dates = new double[lCal.size()];
		double[] values = new double[lVal.size()];
		
		for(int i = 0 ; i < lCal.size() ; i++) {
			dates[i] = XIRRData.getExcelDateValue(lCal.get(i));
			values[i] = lVal.get(i).doubleValue();
		}
		
		XIRRData data       = new XIRRData( 5, 0.3, values, dates ) ;
		double xirrValue = XIRR.xirr( data ) ;
		
		xirrValue = (xirrValue -1)*100;
		
		System.out.println("XIRR :"+xirrValue);
		assertTrue(true);
		
	}

}
