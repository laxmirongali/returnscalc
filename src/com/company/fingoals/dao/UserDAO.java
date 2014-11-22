package com.company.fingoals.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.company.fingoals.dto.User;

public class UserDAO {

	public List<User> findAll() throws Exception {

		List<User> users = new ArrayList<>();

		Connection conn = DAOUtil.openConnection();
		
		String sql = "select * from FG_USER";

		PreparedStatement stmt = conn.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		User user = null;
		while(rs.next()){
			
			user = new User();
			user.setUserId(rs.getBigDecimal("USER_ID"));
			user.setUserEmail(rs.getString("USER_EMAIL"));
			user.setAnnualSalary(rs.getBigDecimal("ANNUAL_SALARY"));
			user.setDob(rs.getTimestamp("DOB"));
			user.setPwd(rs.getString("PWD"));
			user.setFirstName(rs.getString("FIRST_NAME"));
			user.setLastName(rs.getString("LAST_NAME"));
			
			users.add(user);
			
		}
		
		stmt.close();
		rs.close();
		
		DAOUtil.closeConnection(conn);
		
		return users;
	}
	
	public void insert(User user) throws Exception {
		
		Connection conn = DAOUtil.openConnection();
		
		String sql = "INSERT INTO FG_USER(USER_ID,USER_EMAIL,ANNUAL_SALARY,DOB,PWD,FIRST_NAME,LAST_NAME) VALUES(user_id_seq.nextval,?,?,?,?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, user.getUserEmail());
		stmt.setBigDecimal(2, user.getAnnualSalary());
		stmt.setTimestamp(3, user.getDob());
		stmt.setString(4, user.getPwd());
		stmt.setString(5, user.getFirstName());
		stmt.setString(6, user.getLastName());
		
		stmt.executeUpdate();
		
		stmt.close();
		DAOUtil.closeConnection(conn);
		
		
	}
	
	public void update(User user) throws Exception {
		
		Connection conn = DAOUtil.openConnection();
		
		String sql = "UPDATE FG_USER SET USER_EMAIL=?,ANNUAL_SALARY=?,DOB=?,PWD=?,FIRST_NAME=?,LAST_NAME=? WHERE USER_ID=?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1,user.getUserEmail());
		stmt.setBigDecimal(2, user.getAnnualSalary());
		stmt.setTimestamp(3, user.getDob());
		stmt.setString(4, user.getPwd());
		stmt.setString(5, user.getFirstName());
		stmt.setString(6, user.getLastName());
		stmt.setBigDecimal(7, user.getUserId());
		
		stmt.executeUpdate();
		
		stmt.close();
		DAOUtil.closeConnection(conn);
		
	}
	
	public void delete(BigDecimal userId) throws Exception {
		
		Connection conn = DAOUtil.openConnection();
		
		System.out.println("Big decimal value:" + userId);
		
		String sql = "DELETE FROM FG_USER WHERE USER_ID=?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setBigDecimal(1, userId);
		
		int i = stmt.executeUpdate();
		System.out.println("No of records deleted:" + i);
		
		stmt.close();
		DAOUtil.closeConnection(conn);
		
	}
	
	public User findUser(String userEmail, String pwd) throws Exception {
		
		

		Connection conn = DAOUtil.openConnection();
		
		String sql = "select * from FG_USER WHERE USER_EMAIL=? AND PWD=?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		User user = null;
		
		stmt.setString(1, userEmail);
		stmt.setString(2, pwd);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()){
			
			user = new User();
			user.setUserId(rs.getBigDecimal("USER_ID"));
			user.setUserEmail(rs.getString("USER_EMAIL"));
			user.setAnnualSalary(rs.getBigDecimal("ANNUAL_SALARY"));
			user.setDob(rs.getTimestamp("DOB"));
			user.setPwd(rs.getString("PWD"));
			user.setFirstName(rs.getString("FIRST_NAME"));
			user.setLastName(rs.getString("LAST_NAME"));
			
		}
		
		rs.close();
		stmt.close();
		
		DAOUtil.closeConnection(conn);
		
		return user;
	}

}
