package com.company.fingoals.dto;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

public class ReturnsCalculatorData {

	private String symbol;
	private GregorianCalendar fromDate;
	private BigDecimal amount;
	private GregorianCalendar toDate;
	private int dayOfTheMonth;

	public int getDayOfTheMonth() {
		return dayOfTheMonth;
	}

	public void setDayOfTheMonth(int dayOfTheMonth) {
		this.dayOfTheMonth = dayOfTheMonth;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public GregorianCalendar getFromDate() {
		return fromDate;
	}

	public void setFromDate(GregorianCalendar fromDate) {
		this.fromDate = fromDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public GregorianCalendar getToDate() {
		return toDate;
	}

	public void setToDate(GregorianCalendar toDate) {
		this.toDate = toDate;
	}

}
