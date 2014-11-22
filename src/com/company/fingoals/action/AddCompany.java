package com.company.fingoals.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCompany
 */
@WebServlet("/addCompany")
public class AddCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCompany() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String symbol = request.getParameter("companysymbol");
		System.out.println("Company is added : " + symbol);

		HttpSession hs = request.getSession();

		List<String> symbolList = null;

		symbolList = (List<String>) hs.getAttribute("symbolList");

		if (symbolList == null) {

			symbolList = new ArrayList<String>();

		}

		if (symbol != null && symbol.length() > 0) {
			symbolList.add(symbol);
		}
		
		hs.setAttribute("symbolList", symbolList);

		request.getRequestDispatcher("companyUserProfile.jsp").forward(request,
				response);

	}

}
