package com.company.fingoals.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.fingoals.dto.HoldingsGroup;
import com.company.fingoals.dto.ReturnsCalculatorData;
import com.company.fingoals.service.ReturnsCalculator;
import com.company.fingoals.util.AppUtil;

/**
 * Servlet implementation class GetReturns
 */
@WebServlet("/getReturns")
public class GetReturns extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetReturns() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Values are here");

		HttpSession hs = request.getSession();

		List<String> symbolList = (List<String>) hs.getAttribute("symbolList");

		ReturnsCalculatorData rcd = null;
		List<ReturnsCalculatorData> rcdList = new ArrayList<ReturnsCalculatorData>();

		ReturnsCalculator rc = null;
		List<HoldingsGroup> hgList = new ArrayList<HoldingsGroup>();

		try {
			for (int i = 0; i < symbolList.size(); i++) {
				rcd = new ReturnsCalculatorData();
				rcd.setSymbol(symbolList.get(i));
				rcd.setFromDate(AppUtil.parseDate(
						request.getParameter("fromdate" + i), "MM/dd/yyyy"));
				rcd.setToDate(AppUtil.parseDate(
						request.getParameter("todate" + i), "MM/dd/yyyy"));
				rcd.setAmount(AppUtil.parseNumber(request.getParameter("amount"
						+ i)));
				System.out
						.println("day is :" + request.getParameter("day" + i));
				rcd.setDayOfTheMonth(new Integer(request
						.getParameter("day" + i)));
				rcdList.add(rcd);

			}

			for (int j = 0; j < rcdList.size(); j++) {

				rcd = rcdList.get(j);
				rc = new ReturnsCalculator();
				rc.setReturnsCalculatorData(rcd);
				HoldingsGroup hg = rc.calculateReturn();
				hgList.add(hg);

			}
			
			request.setAttribute("hgList", hgList);
			request.getRequestDispatcher("getReturns.jsp").forward(request,response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
