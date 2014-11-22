package com.company.fingoals.dto;

import in.satpathy.financial.XIRR;
import in.satpathy.financial.XIRRData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.company.fingoals.util.AppUtil;

public class Holding {

	private String symbol;
	private String companyName;
	private Calendar investedDate;
	private BigDecimal investedPrice;
	private BigDecimal quantity;
	private BigDecimal currentPrice;

	public Holding() {
		// TODO Auto-generated constructor stub
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Calendar getInvestedDate() {
		return investedDate;
	}

	public void setInvestedDate(Calendar purchasedDate) {
		this.investedDate = purchasedDate;
	}

	public BigDecimal getInvestedPrice() {
		return investedPrice;
	}
	public void setInvestedPrice(BigDecimal purchasedPrice) {
		this.investedPrice = purchasedPrice;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public BigDecimal getInvestedValue() {
		BigDecimal investedValue = getQuantity().multiply(getInvestedPrice());
		return investedValue;
	}
	
	public BigDecimal getCurrentValue() {
		BigDecimal currentValue = getQuantity().multiply(getCurrentPrice());
		return currentValue;
	}


	public BigDecimal getReturn() throws Exception {
		
		/*double d1 = currentPrice.doubleValue();
		double d2 = purchasedPrice.doubleValue();
		double d3;
		d3 = ((d1-d2)/d2)*100;
		
		return new BigDecimal(d3);*/
		
		BigDecimal bd = getCurrentValue().add(getInvestedValue().negate());
		//bd = bd.setScale(2);
		
		return bd;
	}
	
	public BigDecimal getReturnPercentage() throws Exception {
		
		BigDecimal num = new BigDecimal(100);
		BigDecimal bd = ((currentPrice.add(investedPrice.negate())).divide(investedPrice,2)).multiply(num);
		//bd = bd.setScale(2);
		
		return bd;
		
	}
	
	public double getXIRR() {
		List<Calendar> lCal = new ArrayList<Calendar>();
		List<BigDecimal> lVal = new ArrayList<BigDecimal>();
		//1
		lCal.add(getInvestedDate());
		lVal.add(getInvestedPrice());
		//2
		lCal.add(new GregorianCalendar());
		lVal.add(getCurrentPrice().negate());
		
		double[] dates = new double[lCal.size()];
		double[] values = new double[lVal.size()];
		
		for(int i = 0 ; i < dates.length ; i++) {
			dates[i] = XIRRData.getExcelDateValue(lCal.get(i));
			values[i] = lVal.get(i).doubleValue();
		}
		
		XIRRData data       = new XIRRData( lCal.size(), 0.3, values, dates ) ;
		double xirrValue = XIRR.xirr( data ) ;
		
		xirrValue = (xirrValue -1)*100;
		
		return xirrValue;
		
	}
	
	public String getDateString() {
		return AppUtil.dateMMddyyyy(investedDate);
	}

}
