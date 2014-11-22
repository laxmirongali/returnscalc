package com.company.fingoals.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.fingoals.dao.InvestmentsDAO;
import com.company.fingoals.dto.Investment;
import com.company.fingoals.dto.User;
import com.company.fingoals.util.AppUtil;

/**
 * Servlet implementation class Investments
 */
@WebServlet("/investments")
public class Investments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("received HTTP service method");
		try {
			//String dispatch = request.getPathInfo();

			String dispatch = request.getParameter("dispatch");
			System.out.println("action :"+dispatch);
			
			if ("add".equals(dispatch)) {
				add(request, response);
				System.out.println("here action:" + dispatch);
				return;
			}
			
			if ("saveAdd".equals(dispatch)) {
				System.out.println("saveAdd action:" + dispatch);
				saveAdd(request, response);
				
				return;
			}
			
			if ("update".equals(dispatch)) {
				System.out.println("Update :"+dispatch);
				update(request, response);
				return;
			}

			if ("delete".equals(dispatch)) {
				System.out.println("delete :"+dispatch);
				delete(request, response);
				return;
			}

			if ("saveUpdate".equals(dispatch)) {
				
				System.out.println("saveUpdate :"+dispatch);
				saveUpdate(request, response);				
				return;
			}
			
			if ("showUserInvestments".equals(dispatch)) {
				showUserInvestments(request,response);
				return;
			}
			
			System.out.println("here action:" + dispatch);
			showUserInvestments(request, response);
	}catch (ServletException e) {
		throw e;
	} catch (IOException e) {
		throw e;
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}

	private void showUserInvestments(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HttpSession hs = request.getSession();
		User user = (User) hs.getAttribute("user");	
		
		InvestmentsDAO invDAO = new InvestmentsDAO();
		
		List<Investment> investments = invDAO.findInvestments(user.getUserId());
		
		request.setAttribute("investments",investments );
		request.getRequestDispatcher("/investments.jsp").forward(request, response);
		
	}

	private void saveUpdate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		InvestmentsDAO invDAO = new InvestmentsDAO();
		
		HttpSession hs = request.getSession();
		User user = (User) hs.getAttribute("user");
		
		String invId = request.getParameter("invId");
		String invDate = request.getParameter("invDate");
		String symbol = request.getParameter("symbol");
		String amount = request.getParameter("amount");
		
		Investment investment = new Investment();
		try{
			investment.setInvestmentID(AppUtil.parseNumber(invId));
			investment.setUserID(user.getUserId());
			investment.setInvestedDate(AppUtil.strToTimeStamp(invDate,"MM/dd/yyyy"));			
			investment.setSymbol(symbol);
			investment.setAmount(AppUtil.parseNumber(amount));
			
			invDAO.update(investment);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		showUserInvestments(request, response);
		
		
	}

	private void delete(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		InvestmentsDAO invDAO = new InvestmentsDAO();
		
		String invId = request.getParameter("invId");
		
		BigDecimal invID = AppUtil.parseNumber(invId);
		
		invDAO.delete(invID);
		
		showUserInvestments(request, response);
	}

	private void update(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		InvestmentsDAO invDAO = new InvestmentsDAO();
		
		Investment investment = new Investment();
		
		String invId = request.getParameter("invId");
		System.out.println("Inv ID : "+invId);
		
		BigDecimal invID = AppUtil.parseNumber(invId);
		
		investment = invDAO.findInvestment(invID);
		
		request.setAttribute("investment",investment);
		
		request.getRequestDispatcher("/updateInvestment.jsp").forward(request, response);
		
	}

	private void saveAdd(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		InvestmentsDAO invDAO = new InvestmentsDAO();
		
		HttpSession hs = request.getSession();
		User user = (User) hs.getAttribute("user");
		
		String invDate = request.getParameter("invDate");
		String symbol = request.getParameter("symbol");
		String amount = request.getParameter("amount");
		
		Investment investment = new Investment();
		try{
			investment.setUserID(user.getUserId());
			investment.setInvestedDate(AppUtil.strToTimeStamp(invDate,"MM/dd/yyyy"));			
			investment.setSymbol(symbol);
			investment.setAmount(AppUtil.parseNumber(amount));
			
			invDAO.insert(investment);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		showUserInvestments(request, response);
	}

	private void add(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		request.getRequestDispatcher("addInvestment.jsp").forward(request, response);
				
	}
	
}
