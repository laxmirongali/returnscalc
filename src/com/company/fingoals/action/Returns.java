package com.company.fingoals.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.fingoals.dto.HoldingsGroup;
import com.company.fingoals.dto.ReturnsCalculatorData;
import com.company.fingoals.service.ReturnsCalculator;
import com.company.fingoals.util.AppUtil;

/**
 * Servlet implementation class Returns
 */
@WebServlet("/returns")
public class Returns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Returns() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String symbol = request.getParameter("symbol");
		String fromDate = request.getParameter("fromdate");
		String toDate = request.getParameter("todate");
		String amount = request.getParameter("amount");
		String day =  request.getParameter("day");
		System.out.println("it came here:" + request.getParameter("fromdate"));
		
		ReturnsCalculatorData rcd = new ReturnsCalculatorData();
		
		rcd.setSymbol(symbol);
		try {
			rcd.setFromDate(AppUtil.parseDate(fromDate, "MM/dd/yyyy"));
			rcd.setToDate(AppUtil.parseDate(toDate, "MM/dd/yyyy"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			rcd.setAmount(AppUtil.parseNumber(amount));
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		rcd.setDayOfTheMonth(Integer.parseInt(day));
		
		ReturnsCalculator rc = new ReturnsCalculator();
		
		rc.setReturnsCalculatorData(rcd);
		
		try {
			
			HoldingsGroup hg = rc.calculateReturn();
			
			request.setAttribute("hg",hg);
			
			request.getRequestDispatcher("holdingsGroupReturns.jsp").forward(request,response);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
