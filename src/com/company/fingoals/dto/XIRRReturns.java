package com.company.fingoals.dto;

import in.satpathy.financial.XIRR;
import in.satpathy.financial.XIRRData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class XIRRReturns {
	
	private List<Holding> holdings;
	private HoldingsGroup hg;

	public XIRRReturns() {
		// TODO Auto-generated constructor stub
	}

	public List<Holding> getHoldings() {
		return holdings;
	}

	public void setHoldings(List<Holding> holdings) {
		this.holdings = holdings;
	}

	public HoldingsGroup getHg() {
		return hg;
	}

	public void setHg(HoldingsGroup hg) {
		this.hg = hg;
	}
	
	public double getXIRR() {
		
		List<Calendar> lCal = new ArrayList<Calendar>();
		List<BigDecimal> lVal = new ArrayList<BigDecimal>();
		
		for(int i = 0 ; i < holdings.size() ; i++) {
			
			Holding holding = holdings.get(i);
			
			lCal.add(holding.getInvestedDate());
			lVal.add(holding.getInvestedPrice());
			
		}
		
		double[] dates = new double[lCal.size()+1];
		double[] values = new double[lVal.size()+1];
		
		for(int j = 0 ; j < holdings.size() ; j++) {
			
			dates[j] = XIRRData.getExcelDateValue(lCal.get(j));
			values[j] = lVal.get(j).doubleValue();
			
		}
		
		dates[holdings.size()+1] = XIRRData.getExcelDateValue(new GregorianCalendar());
		values[holdings.size()+1] = hg.getCurrentValue().negate().doubleValue();
		
		XIRRData data       = new XIRRData( holdings.size()+1, 0.3, values, dates ) ;
		double xirrValue = XIRR.xirr( data ) ;
		
		xirrValue = (xirrValue -1)*100;
		
		System.out.println("XIRR :"+xirrValue);
		
		return xirrValue;
		
		
		
		
		
	}
	
	

}
