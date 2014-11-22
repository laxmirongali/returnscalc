package com.company.fingoals.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.TestCase;

public class AppUtilTest extends TestCase {

	public void testWhichOneFirst() throws Exception {

		String d1 = "2014-10-12";
		String d2 = "1981-05-12";

		boolean result = false;

		result = AppUtil.parseDate(d1).after(AppUtil.parseDate(d2));

		assertTrue(result);

		result = AppUtil.parseDate(d1).before(AppUtil.parseDate(d2));

		assertFalse(result);

		int i = 0;

		GregorianCalendar g1 = AppUtil.parseDate(d1);
		GregorianCalendar g2 = AppUtil.parseDate(d2);

		while (g2.before(g1)) {
			i = i + 1;
			g2.add(Calendar.DATE, 1);
		}

		System.out.println("i:" + i);
		
		String bd = "1981-05-27";
		
		GregorianCalendar gbd = AppUtil.parseDate(bd);
		
		i = 0;
		
		 g1 = AppUtil.parseDate(d1);
		 g2 = AppUtil.parseDate(d2);
		
		while(!g2.after(g1)){
			if((gbd.get(Calendar.DAY_OF_MONTH)==g2.get(Calendar.DAY_OF_MONTH)) && 
					(gbd.get(Calendar.MONTH) == g2.get(Calendar.MONTH))) {
				i++;
			}
			g2.add(Calendar.DATE, 1);
		}
		
		System.out.println("No of bds:"+i);
		
		 g1 = AppUtil.parseDate(d1);
		 g2 = AppUtil.parseDate(d2);
		 
		 List<Calendar> datesList = new ArrayList<Calendar>();
		 
		 while(!g2.after(g1)){
			 if(g2.get(Calendar.DAY_OF_MONTH) == 27){
				 datesList.add((Calendar)g2.clone());
				 
			 }
			 g2.add(Calendar.DATE, 1);
		 }
		 
		 for(int j = 0 ; j < datesList.size() ; j++){
			 Calendar cal = datesList.get(j);
			 System.out.println("Dates :"+cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH));
		 }
		

	}

	public void testParseDate() throws Exception {

		String yahooDt = "2014-10-01";

		GregorianCalendar cal = AppUtil.parseDate(yahooDt);

		assertEquals(2014, cal.get(Calendar.YEAR));
		assertEquals((10 - 1), cal.get(Calendar.MONTH));
		assertEquals(1, cal.get(Calendar.DATE));

	}

	public void testParseNumber() throws Exception {

		String strNum = null;
		BigDecimal num = null;

		strNum = "100.75";
		num = AppUtil.parseNumber(strNum);
		assertEquals(100.75, num.doubleValue());
		System.out.println("Number in str1:" + num.toString());
		assertEquals(strNum, num.toString());

		strNum = "101";
		num = AppUtil.parseNumber(strNum);
		assertEquals(101, num.intValue());

		System.out.println("Number in str2:" + num.toString());
		assertEquals(strNum, num.toString());
	}
	
	public void testNumFormat() throws Exception {
		BigDecimal bd = new BigDecimal(105.2387464);
		BigDecimal num = AppUtil.numFormat(bd);
		assertNotNull(num);
	}

}
