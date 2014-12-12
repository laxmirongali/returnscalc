package com.company.fingoals.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.fingoals.dao.FinPlansDAO;
import com.company.fingoals.dao.InvestmentsDAO;
import com.company.fingoals.dto.FinPlan;
import com.company.fingoals.dto.Investment;
import com.company.fingoals.dto.User;
import com.company.fingoals.util.AppUtil;

/**
 * Servlet implementation class Investments
 */
@WebServlet("/investments")
public class Investments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("received HTTP service method");
		try {
			// String dispatch = request.getPathInfo();

			String dispatch = request.getParameter("dispatch");
			System.out.println("action :" + dispatch);

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
				System.out.println("Update :" + dispatch);
				update(request, response);
				return;
			}

			if ("delete".equals(dispatch)) {
				System.out.println("delete :" + dispatch);
				delete(request, response);
				return;
			}

			if ("saveUpdate".equals(dispatch)) {

				System.out.println("saveUpdate :" + dispatch);
				saveUpdate(request, response);
				return;
			}

			if ("showUserInvestments".equals(dispatch)) {
				showUserInvestments(request, response);
				return;
			}

			System.out.println("here action:" + dispatch);
			showUserInvestments(request, response);
		} catch (ServletException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
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

		request.setAttribute("investments", investments);
		request.getRequestDispatcher("/investments.jsp").forward(request,
				response);

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
		try {
			investment.setInvestmentID(AppUtil.parseNumber(invId));
			investment.setUserID(user.getUserId());
			investment.setInvestedDate(AppUtil.strToTimeStamp(invDate,
					"MM/dd/yyyy"));
			investment.setSymbol(symbol);
			investment.setAmount(AppUtil.parseNumber(amount));

			invDAO.update(investment);
		} catch (Exception e) {
			e.printStackTrace();
		}

		showUserInvestments(request, response);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		InvestmentsDAO invDAO = new InvestmentsDAO();

		String invId = request.getParameter("invId");

		BigDecimal invID = AppUtil.parseNumber(invId);

		invDAO.delete(invID);

		showUserInvestments(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		InvestmentsDAO invDAO = new InvestmentsDAO();

		Investment investment = new Investment();		

		String invId = request.getParameter("invId");
		System.out.println("Inv ID : " + invId);

		BigDecimal invID = AppUtil.parseNumber(invId);

		investment = invDAO.findInvestment(invID);

		request.setAttribute("investment", investment);

		request.getRequestDispatcher("/updateInvestment.jsp").forward(request,
				response);

	}

	private void saveAdd(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		InvestmentsDAO invDAO = new InvestmentsDAO();
		FinPlansDAO finPlanDAO = new FinPlansDAO();

		HttpSession hs = request.getSession();
		User user = (User) hs.getAttribute("user");
		
		BigDecimal invID = invDAO.getInvestmentId();

		String invDate = request.getParameter("invDate");
		String symbol = request.getParameter("symbol");
		String amount = request.getParameter("amount");

		Investment investment = new Investment();
		try {
			investment.setInvestmentID(invID);
			investment.setUserID(user.getUserId());
			investment.setInvestedDate(AppUtil.strToTimeStamp(invDate,
					"MM/dd/yyyy"));
			investment.setSymbol(symbol);
			investment.setAmount(AppUtil.parseNumber(amount));

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String> parameterNames = new ArrayList<String>();
		Enumeration<String> enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String parameterName = (String) enumeration.nextElement();
			parameterNames.add(parameterName);
		}
				
		List<String> goalnames = new ArrayList<String>();
		List<String> propertyvalues = new ArrayList<String>();
		
		
		
		for (int i = 0; i < parameterNames.size(); i++) {
			String name = parameterNames.get(i);
			if (name.startsWith("newgoal_name")) {
				goalnames.add(name);
			} else if (name.startsWith("newproperty_value")) {
				propertyvalues.add(name);
			}

		}
		
		//System.out.println("");
		
		//String pName = goalnames.get(0);
		//String pValue = propertyvalues.get(0);
		//System.out.println("pName sub string : "+pName.substring(13));
		//System.out.println("pValue sub string : "+pValue.substring(18));
		
		List<FinPlan> finPlans = new ArrayList<FinPlan>();
		FinPlan finPlan = null;

		for (int i = 0; i < goalnames.size(); i++) {
			String goalName = goalnames.get(i);
			//System.out.println("goalname : "+goalName);
			String rowNum = goalName.substring(13);
			for (int j = 0; j < goalnames.size(); j++) {
				String propertyValue = propertyvalues.get(j);
				//System.out.println("property value : "+propertyValue);
				String rowcount = propertyValue.substring(18);
				if (rowNum.equals(rowcount)){
						if(goalName.substring(13).equals("RWCNT")) {
							continue;
						}
					String goalId = request.getParameter(goalName);
					String percentage = request.getParameter(propertyValue);					
					
					System.out.println("goalId : "+goalId);
					System.out.println("percentage : "+percentage);
					
					finPlan = new FinPlan();
					try {						
						finPlan.setGoalID(AppUtil.parseNumber(goalId));
						finPlan.setInvID(invID);
						finPlan.setPercentage(AppUtil.parseNumber(percentage));

						finPlans.add(finPlan);
						break;
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			}
		}

		invDAO.insert(investment);
		
		for(int i = 0 ; i < finPlans.size() ; i++){
			finPlan = new FinPlan();
			finPlan = finPlans.get(i);
			finPlanDAO.insert(finPlan);
		}
		showUserInvestments(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		request.getRequestDispatcher("addInvestment.jsp").forward(request,
				response);

	}

}
