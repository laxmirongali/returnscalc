package com.company.fingoals.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.company.fingoals.dto.Goal;

public class GoalsDAO {

	public List<Goal> findAll() throws Exception {
		
		List<Goal> goals = new ArrayList<Goal>();
		
		Connection conn = DAOUtil.openConnection();
		
		String sql = "select * from USER_GOALS";

		PreparedStatement stmt = conn.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		Goal goal = null;
		while(rs.next()){
			
			goal = new Goal();
			goal.setGoalID(rs.getBigDecimal("GOAL_ID"));
			goal.setUserID(rs.getBigDecimal("USER_ID"));
			goal.setGoalName(rs.getString("GOAL_NAME"));
			goal.setGoalDescription(rs.getString("GOAL_DESCRIPTION"));
			goal.setGoalAmount(rs.getBigDecimal("GOAL_AMOUNT"));
			goal.setGoalDate(rs.getTimestamp("GOAL_DATE"));
			
			goals.add(goal);
		
		}
		
		stmt.close();
		rs.close();
		
		DAOUtil.closeConnection(conn);
		
		return goals;
	
	}
	
	public List<Goal> findUserGoals(BigDecimal userID) throws Exception {
		
		List<Goal> goals = new ArrayList<Goal>();
		
		Connection conn = DAOUtil.openConnection();
		
		String sql = "select * from USER_GOALS WHERE USER_ID=?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		Goal goal = null;
		
		stmt.setBigDecimal(1, userID);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			goal = new Goal();
			goal.setGoalID(rs.getBigDecimal("GOAL_ID"));
			goal.setUserID(rs.getBigDecimal("USER_ID"));
			goal.setGoalName(rs.getString("GOAL_NAME"));
			goal.setGoalDescription(rs.getString("GOAL_DESCRIPTION"));
			goal.setGoalAmount(rs.getBigDecimal("GOAL_AMOUNT"));
			goal.setGoalDate(rs.getTimestamp("GOAL_DATE"));
			goals.add(goal);
			
		}
		
		stmt.close();
		rs.close();
		
		DAOUtil.closeConnection(conn);
		
		return goals;
		
	}
	
	public void insert(Goal goal) throws Exception {
		
		Connection conn = DAOUtil.openConnection();
		
		String sql = "INSERT INTO USER_GOALS(GOAL_ID,USER_ID,GOAL_NAME,GOAL_DESCRIPTION,GOAL_AMOUNT,GOAL_DATE)VALUES(GOAL_ID_SEQ.nextval,?,?,?,?,?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setBigDecimal(1, goal.getUserID());
		stmt.setString(2, goal.getGoalName());
		stmt.setString(3, goal.getGoalDescription());
		stmt.setBigDecimal(4, goal.getGoalAmount());
		stmt.setTimestamp(5, goal.getGoalDate());
		
		stmt.executeUpdate();
		
		stmt.close();
		DAOUtil.closeConnection(conn);
		
	}
	
	public void update(Goal goal) throws Exception {
		
		Connection conn = DAOUtil.openConnection();
		
		String sql = "UPDATE USER_GOALS SET USER_ID=?,GOAL_NAME=?,GOAL_DESCRIPTION=?,GOAL_AMOUNT=?,GOAL_DATE=? WHERE GOAL_ID = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setBigDecimal(1, goal.getUserID());
		stmt.setString(2, goal.getGoalName());
		stmt.setString(3, goal.getGoalDescription());
		stmt.setBigDecimal(4, goal.getGoalAmount());
		stmt.setTimestamp(5, goal.getGoalDate());
		stmt.setBigDecimal(6, goal.getGoalID());
		
		stmt.executeUpdate();
		
		stmt.close();
		DAOUtil.closeConnection(conn);
		
	}
	
	public void delete(BigDecimal goalId) throws Exception {
		
		Connection conn = DAOUtil.openConnection();
		
		System.out.println("Big decimal value:" + goalId);
		
		String sql = "DELETE FROM USER_GOALS WHERE GOAL_ID=?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setBigDecimal(1, goalId);
		
		int i = stmt.executeUpdate();
		System.out.println("No of records deleted:" + i);
		
		stmt.close();
		DAOUtil.closeConnection(conn);
	
	}
	
	public Goal findGoal(BigDecimal goalID) throws Exception {
		
		Connection conn = DAOUtil.openConnection();
		
		String sql = "select * from USER_GOALS WHERE GOAL_ID=?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		Goal goal = null;
		
		stmt.setBigDecimal(1, goalID);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			
			goal = new Goal();
			goal.setGoalID(rs.getBigDecimal("GOAL_ID"));
			goal.setUserID(rs.getBigDecimal("USER_ID"));
			goal.setGoalName(rs.getString("GOAL_NAME"));
			goal.setGoalDescription(rs.getString("GOAL_DESCRIPTION"));
			goal.setGoalAmount(rs.getBigDecimal("GOAL_AMOUNT"));
			goal.setGoalDate(rs.getTimestamp("GOAL_DATE"));
			
		}
		
		rs.close();
		stmt.close();
		
		DAOUtil.closeConnection(conn);
		
		return goal;
		
	}

}
