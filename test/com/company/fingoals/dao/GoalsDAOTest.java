package com.company.fingoals.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.TestCase;

import com.company.fingoals.dto.Goal;

public class GoalsDAOTest extends TestCase{

	public void testFindAll () throws Exception {
		
		GoalsDAO goalsDAO = new GoalsDAO();
		
		List<Goal> goals = goalsDAO.findAll();
		
		if(goals.size() > 0) {
			
			System.out.println("Number of Goals : "+goals.size());
			
			assertTrue(true);
			
		} else{
			assertFalse("Goals list cannot be zero", true);
		}
		
		Goal goal = goals.get(0);
		
		System.out.println(goal.getGoalName());
	
	}
	
	public void testInsert() throws Exception {
		
		Goal goal = new Goal();
		
		goal.setUserID(new BigDecimal(1000));
		goal.setGoalName("Retirement");
		goal.setGoalDescription("Save money for Retirement");
		goal.setGoalAmount(new BigDecimal(1000000));
		
		Calendar cal = new GregorianCalendar(2040, 0, 6);
		Timestamp goalDate = new Timestamp(cal.getTimeInMillis());
		goal.setGoalDate(goalDate);
		
		GoalsDAO gDAO = new GoalsDAO();
		
		gDAO.insert(goal);
		
		assertTrue(true);
	}
	
	public void testUpdate() throws Exception {
		
		Goal goal = new Goal();
		
		goal.setGoalID(new BigDecimal(102));
		goal.setUserID(new BigDecimal(1001));
		goal.setGoalName("House");
		goal.setGoalDescription("To buy a house");
		goal.setGoalAmount(new BigDecimal(350000));
		
		Calendar cal = new GregorianCalendar(2019, 0, 6);
		Timestamp goalDate = new Timestamp(cal.getTimeInMillis());
		goal.setGoalDate(goalDate);
		
		GoalsDAO gDAO = new GoalsDAO();
		
		gDAO.update(goal);
		
		assertTrue(true);
	}
	
	public void testDelete() throws Exception {
		
		GoalsDAO goalsDAO = new GoalsDAO();
		
		goalsDAO.delete(new BigDecimal(101));
		assertTrue(true);
	}
	
	public void testFindUser() throws Exception {
		
		GoalsDAO goalsDAO = new GoalsDAO();
		
		
		List<Goal> goals = new ArrayList<Goal>();
		
		goals = goalsDAO.findUserGoals(new BigDecimal(1000));
		
		System.out.println("NO of Goals :"+goals.size());
		
		assertNotNull(goals);
		
		
	}
}
