package com.company.fingoals.dto;

import in.satpathy.financial.XIRR;
import in.satpathy.financial.XIRRData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class HoldingsGroup {

	private List<Holding> holdings;

	public HoldingsGroup() {
		// TODO Auto-generated constructor stub
	}

	public List<Holding> getHoldings() {
		return holdings;
	}

	public void setHoldings(List<Holding> holdings) {
		this.holdings = holdings;
	}

	public BigDecimal getTotalQuantity() {

		BigDecimal totalQuantity = new BigDecimal(0);

		for (int i = 0; i < holdings.size(); i++) {
			Holding holding = holdings.get(i);
			totalQuantity = totalQuantity.add(holding.getQuantity());
		}

		return totalQuantity;
	}

	public BigDecimal getTotalInvestedAmount() {

		BigDecimal totalInvestedAmount = new BigDecimal(0);

		for (int i = 0; i < holdings.size(); i++) {
			Holding holding = holdings.get(i);
			totalInvestedAmount = totalInvestedAmount.add(holding
					.getInvestedPrice().multiply(holding.getQuantity()));

		}

		// totalInvestedAmount = totalInvestedAmount.setScale(2);
		return totalInvestedAmount;
	}

	public String getCompanyName() {

		Holding holding = holdings.get(0);

		String cName = holding.getCompanyName();

		return cName;
	}

	public BigDecimal getCurrentPrice() {

		Holding holding = holdings.get(0);

		BigDecimal currentPrice = holding.getCurrentPrice();
		// currentValue = currentValue.setScale(2);

		return currentPrice;
	}

	public BigDecimal getCurrentValue() {

		BigDecimal currentValue = getCurrentPrice()
				.multiply(getTotalQuantity());

		return currentValue;
	}

	public BigDecimal getOverallGain() {

		BigDecimal bd = (getCurrentPrice().multiply(getTotalQuantity()))
				.add(getTotalInvestedAmount().negate());
		// bd = bd.setScale(2);

		return bd;

	}

	public BigDecimal getOverallGainPercent() {

		BigDecimal num = new BigDecimal(100);

		BigDecimal bd = (getOverallGain().divide(getTotalInvestedAmount(), 2))
				.multiply(num);
		// bd = bd.setScale(2);

		return bd;
	}

	public double getXIRR() {
		List<Calendar> lCal = new ArrayList<Calendar>();
		List<BigDecimal> lVal = new ArrayList<BigDecimal>();

		double mycp = 0;

		for (int i = 0; i < holdings.size(); i++) {

			Holding holding = holdings.get(i);

			if (i == 0) {
				mycp = holding.getCurrentPrice().doubleValue();
			}
			lCal.add(holding.getInvestedDate());
			lVal.add(holding.getInvestedPrice());

		}

		double[] dates = new double[lCal.size() + 1];
		double[] values = new double[lVal.size() + 1];

		for (int j = 0; j < holdings.size(); j++) {

			dates[j] = XIRRData.getExcelDateValue(lCal.get(j));
			values[j] = lVal.get(j).doubleValue();

		}
		// arrays are zero bound
		dates[holdings.size()] = XIRRData
				.getExcelDateValue(new GregorianCalendar());

		mycp = -(holdings.size() * mycp);
		System.out.println("mycp:" + mycp);
		values[holdings.size()] = mycp;

		XIRRData data = new XIRRData(holdings.size() + 1, 0.3, values, dates);
		double xirrValue = XIRR.xirr(data);

		xirrValue = (xirrValue - 1) * 100;

		System.out.println("XIRR :" + xirrValue);

		return xirrValue;

	}

}
