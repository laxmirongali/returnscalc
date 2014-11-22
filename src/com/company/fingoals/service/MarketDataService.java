package com.company.fingoals.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.company.fingoals.dto.Company;
import com.company.fingoals.dto.Quote;
import com.company.fingoals.util.AppUtil;

public class MarketDataService {

	public MarketDataService() {

	}

	public List<Quote> getHistoryQuotes(String symbol,
			GregorianCalendar fromDate, GregorianCalendar toDate)
			throws Exception {

		List<Quote> quotes = new ArrayList<>();

		String completeurl = "http://ichart.finance.yahoo.com/table.csv?s="
				+ symbol;

		completeurl = completeurl + "&a=" + fromDate.get(Calendar.MONTH);
		completeurl = completeurl + "&b=" + fromDate.get(Calendar.DAY_OF_MONTH);
		completeurl = completeurl + "&c=" + fromDate.get(Calendar.YEAR);
		completeurl = completeurl + "&d=" + toDate.get(Calendar.MONTH);
		completeurl = completeurl + "&e=" + toDate.get(Calendar.DAY_OF_MONTH);
		completeurl = completeurl + "&f=" + toDate.get(Calendar.YEAR);

		System.out.println("completeurl:" + completeurl);

		System.out.println();

		URL url = new URL(completeurl);
		URLConnection yc = url.openConnection();

		BufferedReader in = new BufferedReader(new InputStreamReader(
				yc.getInputStream()));

		ArrayList<String> lineList = new ArrayList<String>();

		String inputLine;

		while ((inputLine = in.readLine()) != null) {

			lineList.add(inputLine);

		}

		in.close();

		String[] strArray;

		Quote quote = null;

		for (int i = 0; i < lineList.size(); i++) {
			if (i == 0) {
				continue;
			}
			quote = new Quote();

			strArray = lineList.get(i).split("\\,");
			quote.setDate(AppUtil.parseDate(strArray[0]));
			quote.setOpen(AppUtil.parseNumber(strArray[1]));
			quote.setHigh(AppUtil.parseNumber(strArray[2]));
			quote.setLow(AppUtil.parseNumber(strArray[3]));
			quote.setClose(AppUtil.parseNumber(strArray[4]));
			quote.setVolume(AppUtil.parseNumber(strArray[5]));
			quote.setAdjClose(AppUtil.parseNumber(strArray[6]));
			
			quotes.add(quote);

		}

		return quotes;

	}
	
	

	public Quote getQuote(String symbol) throws Exception {

		
		Quote quote = new Quote();
		String url = "http://download.finance.yahoo.com/d/quotes.csv?s="
				+ symbol;

		url = url + "&f=d1ohgpvl1sn&e=.csv";

		System.out.println();

		System.out.println("URL : " + url);

		URL url1 = new URL(url);
		URLConnection yc = url1.openConnection();

		BufferedReader in = new BufferedReader(new InputStreamReader(
				yc.getInputStream()));

		String inputLine;

		String[] strArray;
		

		
		
		while ((inputLine = in.readLine()) != null) {
			
			System.out.println(inputLine);
			strArray = inputLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			quote.setDate(AppUtil.parseDate(strArray[0], "\"MM/dd/yyyy\""));
			quote.setOpen(AppUtil.parseNumber(strArray[1]));
			quote.setHigh(AppUtil.parseNumber(strArray[2]));
			quote.setLow(AppUtil.parseNumber(strArray[3]));
			quote.setClose(AppUtil.parseNumber(strArray[4]));
			quote.setVolume(AppUtil.parseNumber(strArray[5]));
			quote.setAdjClose(AppUtil.parseNumber(strArray[6]));
			quote.setSymbol(strArray[7].replace("\"", ""));
			quote.setCompanyName(strArray[8].replace("\"", ""));
			
			
			break;

		}

		in.close();

		// System.out.printf("Last Trade Price is : ",currPrice);
		return quote;

	}
	
	public List<Company> findCompanyList(String companyName) throws Exception {

		String wsStr = null;

		wsStr = companyWSResponse(companyName);

		System.out.println("JSONP:\n" + wsStr);

		wsStr = getJsonStr(wsStr);

		System.out.println("JSon:\n" + wsStr);

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(new StringReader(
				wsStr));

		JSONObject resultSet = (JSONObject) jsonObject.get("ResultSet");

		if (resultSet == null)
			return null;

		JSONArray result = (JSONArray) resultSet.get("Result");

		System.out.println("Result size:" + result.size());
		
		if (result.size() < 1) {
			return null;
		}
		
		Iterator<?> i = result.iterator();

		List<Company> companies = new ArrayList<Company>();
		JSONObject quote = null;

		Company c = null;
		while (i.hasNext()) {
			quote = (JSONObject) i.next();
			c = new Company();

			c.setSymbol((String) quote.get("symbol"));
			c.setExchange((String) quote.get("exch"));
			c.setName((String) quote.get("name"));
			companies.add(c);

		}

		System.out.println("companies size:" + companies.size());

		return companies;
	}

	private String companyWSResponse(String companyName) throws Exception {

		String s = "http://d.yimg.com/autoc.finance.yahoo.com/autoc?query="
				+ companyName
				+ "&callback=YAHOO.Finance.SymbolSuggest.ssCallback";
		System.out.println("URL Requested:" + s);
		URL url = new URL(s);
		URLConnection yc = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				yc.getInputStream()));
		String inputLine;
		String str = "";
		while ((inputLine = in.readLine()) != null) {
			str = str + inputLine;
		}
		in.close();

		return str;
	}

	private String getJsonStr(String jsonP) {

		String json = null;
		if (!jsonP.startsWith("[") && !jsonP.startsWith("{")) {
			json = jsonP.substring(jsonP.indexOf('(') + 1);
			json = json.substring(0, json.indexOf(')'));
		}

		return json;
	}



}
