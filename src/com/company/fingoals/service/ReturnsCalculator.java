package com.company.fingoals.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.company.fingoals.dto.Holding;
import com.company.fingoals.dto.HoldingsGroup;
import com.company.fingoals.dto.Quote;
import com.company.fingoals.dto.ReturnsCalculatorData;

public class ReturnsCalculator {
	private ReturnsCalculatorData returnsCalculatorData;

	public ReturnsCalculatorData getReturnsCalculatorData() {
		return returnsCalculatorData;
	}

	public void setReturnsCalculatorData(
			ReturnsCalculatorData returnsCalculatorData) {
		this.returnsCalculatorData = returnsCalculatorData;
	}

	public HoldingsGroup calculateReturn() throws Exception {

		MarketDataService mds = new MarketDataService();

		List<Quote> quotes;

		quotes = mds.getHistoryQuotes(returnsCalculatorData.getSymbol(),
				returnsCalculatorData.getFromDate(),
				returnsCalculatorData.getToDate());

		Quote quote = null;

		List<Calendar> investedDates = dayOfTheMonthDates();

		List<Quote> investedQuotes = getInvestedQuotes(quotes, investedDates);

		/*
		 * for (int j = 0; j < investedQuotes.size(); j++) { quote =
		 * investedQuotes.get(j);
		 * 
		 * System.out.println("Quotes :" + quote.getDateString() + "/ " +
		 * quote.getOpen() + "/ " + quote.getHigh() + "/ " + quote.getLow() +
		 * "/ " + quote.getClose() + "/ " + quote.getVolume() + "/ " +
		 * quote.getAdjClose()); }
		 */

		Holding holding = null;

		List<Holding> holdings = new ArrayList<Holding>();

		Quote q = mds.getQuote(returnsCalculatorData.getSymbol());
		BigDecimal currPrice = q.getAdjClose();
		String companyName = q.getCompanyName();

		for (int k = 0; k < investedQuotes.size(); k++) {
			quote = investedQuotes.get(k);

			holding = new Holding();

			holding.setInvestedDate(quote.getDate());
			holding.setInvestedPrice(quote.getAdjClose());
			holding.setSymbol(returnsCalculatorData.getSymbol());
			holding.setQuantity(returnsCalculatorData.getAmount().divide(
					quote.getAdjClose(), 3, BigDecimal.ROUND_HALF_UP));
			holding.setCurrentPrice(currPrice);
			holding.getReturn();
			holding.getReturnPercentage();
			holding.setCompanyName(companyName);

			holdings.add(holding);

		}

		/*
		 * for (int l = 0; l < holdings.size(); l++) { holding =
		 * holdings.get(l);
		 * 
		 * System.out.println("Holdings : " + holding.getSymbol() + "/ " +
		 * holding.getDateString() + "/ " + holding.getPurchasedPrice() + "/ " +
		 * holding.getQuantity() + "/ " + holding.getCurrentPrice() + "/ " +
		 * holding.getReturn() + "/ " + holding.getReturnPercentage()); }
		 */

		HoldingsGroup hg = new HoldingsGroup();

		hg.setHoldings(holdings);

		return hg;
	}

	private List<Quote> getInvestedQuotes(List<Quote> quotes,
			List<Calendar> investedDates) {
		Quote quote;
		List<Quote> investedQuotes = new ArrayList<Quote>();

		for (int d = 0; d < investedDates.size(); d++) {

			Calendar investCal = investedDates.get(d);

			for (int j = 0; j < quotes.size(); j++) {

				quote = quotes.get(j);
				Calendar quoteCal = quote.getDate();

				// if invested date is equal to historical quote date
				if (investCal.compareTo(quoteCal) == 0) {
					investedQuotes.add(quote);
					break;
				}

				// if invested date is after historical quote date
				if (investCal.compareTo(quoteCal) > 0) {
					if (j != 0) {
						investedQuotes.add(quotes.get(j - 1));
					}
					break;
				}

			}

		}

		return investedQuotes;
	}

	public List<Calendar> dayOfTheMonthDates() {
		GregorianCalendar g1 = returnsCalculatorData.getFromDate();
		GregorianCalendar g2 = returnsCalculatorData.getToDate();

		List<Calendar> dayOfTheMonthDates = new ArrayList<>();

		while (!g1.after(g2)) {
			if (g1.get(Calendar.DAY_OF_MONTH) == returnsCalculatorData
					.getDayOfTheMonth()) {
				dayOfTheMonthDates.add((Calendar) g1.clone());
			}
			g1.add(Calendar.DATE, 1);
		}
		return dayOfTheMonthDates;
	}

}
