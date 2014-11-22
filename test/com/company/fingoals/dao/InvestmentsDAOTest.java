package com.company.fingoals.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.TestCase;

import com.company.fingoals.dto.Investment;

public class InvestmentsDAOTest extends TestCase {
	
	public void testinsert() throws Exception {
		
		Investment investment = new Investment();
		
		Calendar cal = new GregorianCalendar(2003,5,10);
		Timestamp invDate = new Timestamp(cal.getTimeInMillis());
		investment.setInvestedDate(invDate);
		
		investment.setSymbol("AAPL");
		investment.setAmount(new BigDecimal(1000));
		
		InvestmentsDAO invDAO = new InvestmentsDAO();
		
		invDAO.insert(investment);
		
		assertTrue(true);
	}
	
	public void testFindInvestment() throws Exception {
		
		InvestmentsDAO invDAO = new InvestmentsDAO();
		
		Investment investment = invDAO.findInvestment(new BigDecimal(100));
		
		System.out.println("Symbol is : "+investment.getSymbol());
		
		assertNotNull(investment);
	}
	
	public void testDelete() throws Exception {
		
		InvestmentsDAO invDAO = new InvestmentsDAO();
		
		invDAO.delete(new BigDecimal(102));
		
		assertTrue(true);
	}
	
	public void testFindAll() throws Exception {
		
		InvestmentsDAO invDAO = new InvestmentsDAO();
		
		List<Investment> invstments = invDAO.findAll();
		
		if(invstments.size() > 0) {
			System.out.println("Investments size is : "+invstments.size());
		}
		
		assertNotNull(invstments);
	}
	
	public void testUpdate() throws Exception {
		
		InvestmentsDAO invDAO = new InvestmentsDAO();
		
		Investment investment = new Investment();
		
		investment.setInvestmentID(new BigDecimal(100));
		
		Calendar cal = new GregorianCalendar(2000,5,10);
		Timestamp ts = new Timestamp(cal.getTimeInMillis());
		investment.setInvestedDate(ts);
		
		investment.setSymbol("AAPL");
		investment.setAmount(new BigDecimal(1500));
		
		invDAO.update(investment);
		
		assertTrue(true);
						
	}
	
	public void testFindInvestments() throws Exception {
		
		InvestmentsDAO invDAO = new InvestmentsDAO();
		
		List<Investment> investments = invDAO.findInvestments(new BigDecimal(1000));
		
		if(investments.size() > 0) {
			assertEquals(2, investments.size());
		}
	}

}
