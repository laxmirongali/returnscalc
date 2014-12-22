package com.company.fingoals.dto;

import java.math.BigDecimal;

public class FinPlan {

	private BigDecimal goalID;
	private BigDecimal invID;
	private BigDecimal percentage;

	public BigDecimal getGoalID() {
		return goalID;
	}

	public void setGoalID(BigDecimal goalID) {
		this.goalID = goalID;
	}

	public BigDecimal getInvID() {
		return invID;
	}

	public void setInvID(BigDecimal invID) {
		this.invID = invID;
	}

	public BigDecimal getPercentage() {
		return percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

}
