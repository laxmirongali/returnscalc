package com.company.fingoals.dto;


public class Company {

	public Company() {
		// TODO Auto-generated constructor stub
	}
	private String symbol;
	private String name;
	private String exchange;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	
	@Override
	public String toString(){
		return "Company :: Symbol:"+this.symbol+" Name:"+this.name+" Exchange:"+this.exchange;
	}

}
