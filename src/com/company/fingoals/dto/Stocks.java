package com.company.fingoals.dto;

public class Stocks {

	private String status;
	private String name;
	private String symbol;
	private String lastPrice;
	private String change;
	private String changePercent;
	private String timeStamp;
	private String msDate;
	private String marketCap;
	private String volume;
	private String changeYTD;
	private String changePercentYTD;
	private String high;
	private String low;
	private String open;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(String lastPrice) {
		this.lastPrice = lastPrice;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getChangePercent() {
		return changePercent;
	}

	public void setChangePercent(String changePercent) {
		this.changePercent = changePercent;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMsDate() {
		return msDate;
	}

	public void setMsDate(String msDate) {
		this.msDate = msDate;
	}

	public String getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getChangeYTD() {
		return changeYTD;
	}

	public void setChangeYTD(String changeYTD) {
		this.changeYTD = changeYTD;
	}

	public String getChangePercentYTD() {
		return changePercentYTD;
	}

	public void setChangePercentYTD(String changePercentYTD) {
		this.changePercentYTD = changePercentYTD;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public Stocks() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString(){
		return "STOCK QUOTE:: Status:"+this.status+" Name:"+this.name+" Symbol:"+this.symbol+
				" Last Price:"+this.lastPrice+" Change:"+this.change+" Change Percent:"+this.changePercent+
				" Time Stamp:"+this.timeStamp+" MS Date:"+this.msDate+" Market Cap:"+this.marketCap+" Volume:"+
				this.volume+" Change YTD:"+this.changeYTD+" Change Percent YTD:"+this.changePercentYTD+
				" High"+this.high+" Low:"+this.low+" Open:"+this.open;
	}
	

}


