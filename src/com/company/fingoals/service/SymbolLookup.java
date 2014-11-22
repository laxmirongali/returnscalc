package com.company.fingoals.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.company.fingoals.dto.Company;

public class SymbolLookup {

	public SymbolLookup() {
	}

	public List<Company> lookup(String companyName) throws Exception {

		String wsStr = null;

		wsStr = symbolUrlConnection(companyName);

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

	private String symbolUrlConnection(String companyName) throws Exception {

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
