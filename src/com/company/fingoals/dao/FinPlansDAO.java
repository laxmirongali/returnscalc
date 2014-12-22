package com.company.fingoals.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.company.fingoals.dto.FinPlan;

public class FinPlansDAO {
	
	public void insert(FinPlan finPlan) throws Exception {
		
		Connection conn = DAOUtil.openConnection();
		
		String sql = "INSERT INTO FIN_PLAN(GOAL_ID,INV_ID,INV_PERCENTAGE)VALUES(?,?,?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setBigDecimal(1, finPlan.getGoalID());
		stmt.setBigDecimal(2, finPlan.getInvID());
		stmt.setBigDecimal(3, finPlan.getPercentage());
		
		stmt.executeUpdate();
		
		stmt.close();
		DAOUtil.closeConnection(conn);
		
	}
		

}
