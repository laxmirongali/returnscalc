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

import com.company.fingoals.dao.GoalsDAO;
import com.company.fingoals.dto.Goal;
import com.company.fingoals.dto.User;
import com.company.fingoals.util.AppUtil;

/**
 * Servlet implementation class Goals
 */
@WebServlet("/goals")
public class Goals extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Goals() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		

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
				saveAdd(request, response);
				System.out.println("saveAdd action:" + dispatch);
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
			
			if ("showUesrGoals".equals(dispatch)) {
				showUserGoals(request,response);
				return;
			}
			
			System.out.println("here action:" + dispatch);
			showUserGoals(request, response);
			
		} catch (ServletException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	private void showUserGoals(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HttpSession hs = request.getSession();
		User user = (User) hs.getAttribute("user");				
		
		GoalsDAO goalsDAO = new GoalsDAO();
	
		List<Goal> goals = goalsDAO.findUserGoals(user.getUserId());

		hs.setAttribute("goals", goals);
		request.getRequestDispatcher("goals.jsp").forward(request, response);
	}

	private void saveUpdate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		GoalsDAO goalsDAO = new GoalsDAO();

		HttpSession hs = request.getSession();
		User user = (User) hs.getAttribute("user");
		
		String goalId = request.getParameter("goalId");
		String goalName = request.getParameter("goalname");
		String goalDesc = request.getParameter("goaldesc");
		String goalAmount = request.getParameter("goalamount");
		String goalDate = request.getParameter("goaldate");
		
		Goal goal = new Goal();
		try {
			goal.setUserID(user.getUserId());
			goal.setGoalID(AppUtil.parseNumber(goalId));
			goal.setGoalName(goalName);
			goal.setGoalDescription(goalDesc);
			goal.setGoalAmount(AppUtil.parseNumber(goalAmount));
			goal.setGoalDate(AppUtil.strToTimeStamp(goalDate, "MM/dd/yyyy"));
			
			goalsDAO.update(goal);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		
		
		showUserGoals(request,response);

	}

	private void saveAdd(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		GoalsDAO goalsDAO = new GoalsDAO();
		
		HttpSession hs = request.getSession();
		User user = (User) hs.getAttribute("user");
				
		String goalName = request.getParameter("goalname");
		String goalDesc = request.getParameter("goaldesc");
		String goalAmount = request.getParameter("goalamount");
		String goalDate = request.getParameter("goaldate");
		
		Goal goal = new Goal();
		try {
			goal.setUserID(user.getUserId());
			goal.setGoalName(goalName);
			goal.setGoalDescription(goalDesc);
			goal.setGoalAmount(AppUtil.parseNumber(goalAmount));
			goal.setGoalDate(AppUtil.strToTimeStamp(goalDate, "MM/dd/yyyy"));
			
			goalsDAO.insert(goal);
		} catch (Exception e) {			
			e.printStackTrace();
		}
				
		showUserGoals(request,response);
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		GoalsDAO goalsDAO = new GoalsDAO();
		
		String goalId = request.getParameter("goalId");
		System.out.println("GoalID :"+goalId);
				
		
		BigDecimal goal_id =  AppUtil.parseNumber(goalId);
		
		goalsDAO.delete(goal_id);
		
		showUserGoals(request,response);
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		GoalsDAO goalsDAO = new GoalsDAO();
		
		Goal goal = new Goal();
		
		String goalId = request.getParameter("goalId");
		
		System.out.println("GoalID :"+goalId);
		
		BigDecimal goal_id =  AppUtil.parseNumber(goalId);
				
		goal = goalsDAO.findGoal(goal_id);
		
		System.out.println("Goal name :"+goal.getGoalName());
		
		request.setAttribute("goal",goal);
		
		request.getRequestDispatcher("/update.jsp").forward(request, response);				

	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//GoalsDAO goalsDAO = new GoalsDAO();


		//request.setAttribute("goal", goal);
		request.getRequestDispatcher("/addgoal.jsp").forward(request, response);

	}

	/*private void showAll(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		GoalsDAO goalsDAO = new GoalsDAO();

		List<Goal> goals = goalsDAO.findAll();

		request.setAttribute("goals", goals);
		request.getRequestDispatcher("/goals.jsp").forward(request, response);

	}*/

}
