package com.company.fingoals.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Investment {
	
	private BigDecimal investmentID;
	private Timestamp investedDate;
	private String symbol;
	private BigDecimal amount;
	private BigDecimal userID;
	
	public BigDecimal getUserID() {
		return userID;
	}

	public void setUserID(BigDecimal userID) {
		this.userID = userID;
	}

	public BigDecimal getInvestmentID() {
		return investmentID;
	}

	public void setInvestmentID(BigDecimal investmentID) {
		this.investmentID = investmentID;
	}

	public Timestamp getInvestedDate() {
		return investedDate;
	}
	
	public void setInvestedDate(Timestamp investedDate) {
		this.investedDate = investedDate;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	
	public Calendar getInvestedDateCal() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(this.investedDate);
		
		return cal;
	}
	
}
