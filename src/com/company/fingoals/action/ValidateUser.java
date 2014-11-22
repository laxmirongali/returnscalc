package com.company.fingoals.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.fingoals.dao.UserDAO;
import com.company.fingoals.dto.User;

/**
 * Servlet implementation class ValidateUser
 */
@WebServlet("/validateUser")
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		
		UserDAO userDAO = new UserDAO();
		
		try {
			User user = userDAO.findUser(email,pwd);
			System.out.println("User Name : "+user.getFirstName());
			
			if(user != null){
				
				//request.setAttribute("user", user);
				HttpSession hs = request.getSession();
				hs.setAttribute("user", user);
				
				System.out.println("before forwarding to comprof");
				request.getRequestDispatcher("companyUserProfile.jsp").forward(request, response);
				return;
				
			} else {
				
				request.setAttribute("message","Invalid user name or password");
				System.out.println("before forwarding to login page");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
		
	}

}
