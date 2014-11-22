package com.company.fingoals.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.fingoals.dto.Company;
import com.company.fingoals.service.MarketDataService;

/**
 * Servlet implementation class CompanyLinks
 */
@WebServlet("/CompanyLinks")
public class CompanyLinks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyLinks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		String name = request.getParameter("companyname");
		
		try {
			
			MarketDataService mds = new MarketDataService();
			List<Company> companyList =  mds.findCompanyList(name);
			request.setAttribute("clist", companyList);
			
			request.getRequestDispatcher("companyUserProfile.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

