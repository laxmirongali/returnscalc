package com.company.fingoals.parsers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.company.fingoals.dto.Stocks;

public class StockXmlParseReader {
	private boolean bStatus;
	private boolean bName;
	private boolean bSymbol;
	private boolean bLastPrice;
	private boolean bChange;
	private boolean bChangePercent;
	private boolean bTimeStamp;
	private boolean bMSDate;
	private boolean bMarketCap;
	private boolean bVolume;
	private boolean bChangeYTD;
	private boolean bChangePercentYTD;
	private boolean bHigh;
	private boolean bLow;
	private boolean bOpen;

	public StockXmlParseReader() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
      String s = "<StockQuote><Status>SUCCESS</Status><Name>Oracle Corp</Name><Symbol>ORCL</Symbol><LastPrice>39.565</LastPrice><Change>-1.985</Change><ChangePercent>-4.7773766546</ChangePercent><Timestamp>Fri Sep 19 12:45:01 UTC-04:00 2014</Timestamp><MSDate>41901.5312615741</MSDate><MarketCap>176257683285</MarketCap><Volume>2251041</Volume><ChangeYTD>38.26</ChangeYTD><ChangePercentYTD>3.4108729744</ChangePercentYTD><High>40.64</High><Low>39.28</Low><Open>40.56</Open></StockQuote>";

      StockXmlParseReader spr = new StockXmlParseReader();
      List<Stocks> stocksList = spr.symbolParseXml(s);
      for(Stocks stock :stocksList )
      System.out.println(stock.toString());
	}
	
	public List<Stocks> symbolParseXml(String s){
		List<Stocks> stocksList = new ArrayList<>();
		Stocks stock = null;
		Reader reader = new StringReader(s);
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try{
			XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);
			int event = xmlStreamReader.getEventType();
			while(true){
				switch(event){
				case XMLStreamConstants.START_ELEMENT:
					if(xmlStreamReader.getLocalName().equals("StockQuote")){
						stock = new Stocks();
					}else if(xmlStreamReader.getLocalName().equals("Status")){
						bStatus = true;
					}else if(xmlStreamReader.getLocalName().equals("Name")){
						bName = true;
					}else if(xmlStreamReader.getLocalName().equals("Symbol")){
						bSymbol = true;
					}else if(xmlStreamReader.getLocalName().equals("LastPrice")){
						bLastPrice = true;
					}else if(xmlStreamReader.getLocalName().equals("Change")){
						bChange = true;
					}else if(xmlStreamReader.getLocalName().equals("ChangePercent")){
						bChangePercent = true;
					}else if(xmlStreamReader.getLocalName().equals("Timestamp")){
						bTimeStamp = true;
					}else if(xmlStreamReader.getLocalName().equals("MSDate")){
						bMSDate = true;
					}else if(xmlStreamReader.getLocalName().equals("MarketCap")){
						bMarketCap = true;
					}else if(xmlStreamReader.getLocalName().equals("Volume")){
						bVolume = true;
					}else if(xmlStreamReader.getLocalName().equals("ChangeYTD")){
						bChangeYTD = true;
					}else if(xmlStreamReader.getLocalName().equals("ChangePercentYTD")){
						bChangePercentYTD = true;
					}else if(xmlStreamReader.getLocalName().equals("High")){
						bHigh = true;
					}else if(xmlStreamReader.getLocalName().equals("Low")){
						bLow = true;
					}else if(xmlStreamReader.getLocalName().equals("Open")){
						bOpen = true;
					}
					break;
				case XMLStreamConstants.CHARACTERS:
					if(bStatus){
						stock.setStatus(xmlStreamReader.getText());
						bStatus = false;
					}else if(bName){
						stock.setName(xmlStreamReader.getText());
						bName = false;
					}else if(bSymbol){
						stock.setSymbol(xmlStreamReader.getText());
						bSymbol = false;
					}else if(bLastPrice){
						stock.setLastPrice(xmlStreamReader.getText());
						bLastPrice = false;
					}else if(bChange){
						stock.setChange(xmlStreamReader.getText());
						bChange = false;
					}else if(bChangePercent){
						stock.setChangePercent(xmlStreamReader.getText());
						bChangePercent = false;
					}else if(bTimeStamp){
						stock.setTimeStamp(xmlStreamReader.getText());
						bTimeStamp = false;
					}else if(bMSDate){
						stock.setMsDate(xmlStreamReader.getText());
						bMSDate = false;
					}else if(bMarketCap){
						stock.setMarketCap(xmlStreamReader.getText());
						bMarketCap = false;
					}else if(bVolume){
						stock.setVolume(xmlStreamReader.getText());
						bVolume = false;
					}else if(bChangeYTD){
						stock.setChangeYTD(xmlStreamReader.getText());
						bChangeYTD = false;
					}else if(bChangePercentYTD){
						stock.setChangePercentYTD(xmlStreamReader.getText());
						bChangePercentYTD = false;
					}else if(bHigh){
						stock.setHigh(xmlStreamReader.getText());
						bHigh = false;
					}else if(bLow){
						stock.setLow(xmlStreamReader.getText());
						bLow = false;
					}else if(bOpen){
						stock.setOpen(xmlStreamReader.getText());
						bOpen = false;
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					if(xmlStreamReader.getLocalName().equals("StockQuote")){
						stocksList.add(stock);
					}
					break;
				}
				if(!xmlStreamReader.hasNext())
					break;
				
				event = xmlStreamReader.next();
				
			}
		}catch (XMLStreamException e){
			e.printStackTrace();
		}
		return stocksList; 
	}

}


