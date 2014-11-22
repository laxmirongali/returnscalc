package com.company.fingoals.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.fingoals.dto.Quote;
import com.company.fingoals.service.MarketDataService;

/**
 * Servlet implementation class CompanyStockValue
 */
@WebServlet("/CompanyStockValue")
public class CompanyStockValue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyStockValue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
    	String name = request.getParameter("symbol");

    	MarketDataService mds = new MarketDataService();
    	try{
    		
    		Quote quote = mds.getQuote(name);
    		
    		request.setAttribute("quote",quote );
    		
    		request.getRequestDispatcher("currentStockPrice.jsp").forward(request, response);
    		
    	}catch  (Exception e) {
    		e.printStackTrace();
    	}
    	
	}
	
	
	/*protected String symbolUrlConnection(String urlStr) throws Exception {
		
		String s = "http://dev.markitondemand.com/Api/v2/Quote?symbol="+urlStr;
		System.out.println("URL Requested:" + s);
		URL url = new URL(s);
		URLConnection yc = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine;
		String symbolxml = "";
		 while ((inputLine = in.readLine()) != null) {
			 symbolxml = symbolxml + inputLine;
		 }
		 in.close();
		 
		 return symbolxml;
	}*/

}
