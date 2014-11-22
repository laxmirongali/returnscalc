package com.company.fingoals.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.company.fingoals.dto.Investment;

public class InvestmentsDAO {
	
	public List<Investment> findAll() throws Exception {
		
		List<Investment> investments = new ArrayList<Investment>();
		
		Connection conn = DAOUtil.openConnection();
		
		String sql = "select * from INVESTMENTS";

		PreparedStatement stmt = conn.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		Investment investment = null;
		while(rs.next()) {
			investment = new Investment();
			investment.setInvestmentID(rs.getBigDecimal("INV_ID"));
			investment.setUserID(rs.getBigDecimal("USER_ID"));
			investment.setInvestedDate(rs.getTimestamp("INVESTED_DATE"));
			investment.setSymbol(rs.getString("SYMBOL"));
			investment.setAmount(rs.getBigDecimal("AMOUNT"));
			investments.add(investment);
		}
		
		stmt.close();
		rs.close();
		
		DAOUtil.closeConnection(conn);
		
		return investments;
	}
	
	public List<Investment> findInvestments(BigDecimal userId) throws Exception {
		
		List<Investment> investments = new ArrayList<Investment>();
		
		Connection conn = DAOUtil.openConnection();
		
		String sql = "select * from INVESTMENTS where USER_ID = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		
		Investment investment = null;
		
		stmt.setBigDecimal(1, userId);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			investment = new Investment();
			investment.setInvestmentID(rs.getBigDecimal("INV_ID"));
			investment.setUserID(rs.getBigDecimal("USER_ID"));
			investment.setInvestedDate(rs.getTimestamp("INVESTED_DATE"));
			investment.setSymbol(rs.getString("SYMBOL"));
			investment.setAmount(rs.getBigDecimal("AMOUNT"));
			investments.add(investment);
		}
		
		stmt.close();
		rs.close();
		
		DAOUtil.closeConnection(conn);
		
		return investments;
	}
	
	public void insert(Investment investment) throws Exception {
		
		Connection conn = DAOUtil.openConnection();
			
		String sql = "INSERT INTO INVESTMENTS(INV_ID,INVESTED_DATE,SYMBOL,AMOUNT,USER_ID) VALUES (S1_SEQ.NEXTVAL,?,?,?,?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setTimestamp(1, investment.getInvestedDate());
		stmt.setString(2, investment.getSymbol());
		stmt.setBigDecimal(3,investment.getAmount());
		stmt.setBigDecimal(4, investment.getUserID());
		
		stmt.executeUpdate();
		
		stmt.close();
		DAOUtil.closeConnection(conn);
	}
	
	public void update(Investment investment) throws Exception {
		
		Connection conn = DAOUtil.openConnection();
		
		String sql = "UPDATE INVESTMENTS SET INVESTED_DATE=?,SYMBOL=?,AMOUNT=?,USER_ID=? WHERE INV_ID=?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setTimestamp(1,investment.getInvestedDate());
		stmt.setString(2, investment.getSymbol());
		stmt.setBigDecimal(3, investment.getAmount());
		stmt.setBigDecimal(4, investment.getUserID());
		stmt.setBigDecimal(5, investment.getInvestmentID());
		
		stmt.executeUpdate();
		
		stmt.close();
		DAOUtil.closeConnection(conn);
	}
	
	public void delete(BigDecimal invID) throws Exception {
		
		Connection conn = DAOUtil.openConnection();
		
		String sql = "DELETE FROM INVESTMENTS WHERE INV_ID=?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setBigDecimal(1, invID);
		
		int i = stmt.executeUpdate();
		
		System.out.println("No of rows deleted : "+i);
		
		stmt.close();
		DAOUtil.closeConnection(conn);
	}
	
	public Investment findInvestment(BigDecimal invID) throws Exception {
		
		Connection conn = DAOUtil.openConnection();
		
		String sql = "SELECT * FROM INVESTMENTS WHERE INV_ID=?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setBigDecimal(1, invID);
		
		ResultSet rs = stmt.executeQuery();
		Investment investment = null;
		
		while(rs.next()) {
			investment = new Investment();
			investment.setInvestmentID(rs.getBigDecimal("INV_ID"));
			investment.setInvestedDate(rs.getTimestamp("INVESTED_DATE"));
			investment.setSymbol(rs.getString("SYMBOL"));
			investment.setAmount(rs.getBigDecimal("AMOUNT"));
			investment.setUserID(rs.getBigDecimal("USER_ID"));
		}
		
		rs.close();
		stmt.close();
		
		DAOUtil.closeConnection(conn);
		
		return investment;
	}
}
