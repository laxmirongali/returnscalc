package com.company.fingoals.parsers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.company.fingoals.dto.*;

public class CompanyParseReader {
	private static boolean bSymbol;
	private static boolean bName;
	private static boolean bExchange;

	public CompanyParseReader() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "<LookupResultList><LookupResult><Symbol>NFLX</Symbol><Name>Netflix Inc</Name><Exchange>NASDAQ</Exchange></LookupResult></LookupResultList>";
		
		CompanyParseReader c = new CompanyParseReader();
		List<Company> compList = c.parseXML(s);
		for(Company comp : compList){
			System.out.println(comp.toString());
		}
	}
	
	public List<Company> parseXML(String s){
		List<Company> compList = new ArrayList<>();
		Company comp = null;
		Reader reader = new StringReader(s);
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		
		try{
			XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);
			int event = xmlStreamReader.getEventType();
			while(true){
				switch(event){
				case XMLStreamConstants.START_ELEMENT:
					if(xmlStreamReader.getLocalName().equals("LookupResult")){
						comp = new Company();
					}else if(xmlStreamReader.getLocalName().equals("Symbol")){
						bSymbol = true;
					}else if(xmlStreamReader.getLocalName().equals("Name")){
						bName = true;
					}else if(xmlStreamReader.getLocalName().equals("Exchange")){
						bExchange = true;
					}
					break;
				case XMLStreamConstants.CHARACTERS:
					if(bSymbol){
						comp.setSymbol(xmlStreamReader.getText());
						bSymbol = false;
					}
					else if(bName){
						comp.setName(xmlStreamReader.getText());
						bName = false;
					}else if(bExchange){
						comp.setExchange(xmlStreamReader.getText());
						bExchange = false;
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					 if(xmlStreamReader.getLocalName().equals("LookupResult")){
						 compList.add(comp);
					 }
					 break;
				}
				if(!xmlStreamReader.hasNext())
            		break;
				
				event = xmlStreamReader.next();
			}

		}catch ( XMLStreamException e){
			 e.printStackTrace();
	}
		return compList;

}
	
}

