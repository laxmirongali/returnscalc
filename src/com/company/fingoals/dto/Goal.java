package com.company.fingoals.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Goal {

	private BigDecimal goalID;
	private BigDecimal userID;
	private String goalName;
	private String goalDescription;
	private BigDecimal goalAmount;
	private Timestamp goalDate;
	
	
	public BigDecimal getGoalID() {
		return goalID;
	}
	public void setGoalID(BigDecimal goalID) {
		this.goalID = goalID;
	}
	public BigDecimal getUserID() {
		return userID;
	}
	public void setUserID(BigDecimal userID) {
		this.userID = userID;
	}
	public String getGoalName() {
		return goalName;
	}
	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}
	public String getGoalDescription() {
		return goalDescription;
	}
	public void setGoalDescription(String goalDescription) {
		this.goalDescription = goalDescription;
	}
	public BigDecimal getGoalAmount() {
		return goalAmount;
	}
	public void setGoalAmount(BigDecimal goalAmount) {
		this.goalAmount = goalAmount;
	}
	public Timestamp getGoalDate() {
		return goalDate;
	}
	public void setGoalDate(Timestamp goalDate) {
		this.goalDate = goalDate;
	}
	
	
	public Calendar getGoalDateCalendar() {
		Calendar c = new GregorianCalendar();
		c.setTime(this.goalDate);
		return c; 
	}
	

}
