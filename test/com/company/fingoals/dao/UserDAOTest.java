package com.company.fingoals.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.TestCase;

import com.company.fingoals.dto.User;

public class UserDAOTest extends TestCase {

	public void testFindAll () throws Exception {
		
		UserDAO userDAO = new UserDAO();
		
		List<User> users = userDAO.findAll();
		
		if(users.size()>0){
			System.out.println("Number of users:" + users.size());
			assertTrue(true);
		} else{
			assertFalse("Users data cannot be zero", true);
		}
		
		User u = users.get(0);
		
		System.out.println(u.getFirstName() + " " + u.getLastName());
		
	}
	
	public void testInsert() throws Exception {
		
			
		User user = new User();
		
		user.setUserEmail("tom@jerry.com");
		
		Calendar cal = new GregorianCalendar(1988, 5, 6);
		Timestamp dob = new Timestamp(cal.getTimeInMillis());
		user.setDob(dob);
		
		user.setPwd("jerry");
		user.setFirstName("Tom");
		user.setLastName("Jerry");
		
		user.setAnnualSalary(new BigDecimal(12500.25));
		
		UserDAO userDAO = new UserDAO();
		
		userDAO.insert(user);
		
		assertTrue(true);		
		
	}
	
	public void testUpdate() throws Exception {
		
		User user = new User();
		
		user.setUserEmail("keeti@yahoo.com");
		user.setUserId(new BigDecimal(1002));
		
		Calendar cal = new GregorianCalendar(1991, 12, 3);
		Timestamp dob = new Timestamp(cal.getTimeInMillis());
		user.setDob(dob);
		
		user.setPwd("whocares");
		user.setFirstName("keeti");
		user.setLastName("Bill");
		
		user.setAnnualSalary(new BigDecimal(12378.25));
		
		UserDAO userDAO = new UserDAO();
		
		userDAO.update(user);
		assertTrue(true);
		
	}
	
	public void testDelete() throws Exception {
		
		
		UserDAO userDAO = new UserDAO();

		userDAO.delete(new BigDecimal(1002));
		assertTrue(true);
		
	}
	
	public void testFindUser() throws Exception {
		
		UserDAO userDAO = new UserDAO();
		
		User user = userDAO.findUser("teemp@gmail.cc","ertyy" );
		
		assertNotNull(user);
		
		user = userDAO.findUser("teehhhmp@gmail.cc","ertyy" );
		
		assertNull(user);
		
				
		
	}
	
	
}
