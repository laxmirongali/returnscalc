package com.company.fingoals.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AppUtil {

	public static GregorianCalendar parseDate(String strDate, String dtFormat)
			throws Exception {

		GregorianCalendar cal = null;

		try {
			DateFormat df = new SimpleDateFormat(dtFormat);
			Date date = df.parse(strDate);
			cal = new GregorianCalendar();
			cal.setTime(date);
		} catch (Exception e) {
			return null;
		}

		return cal;

	}

	public static GregorianCalendar parseDate(String strDate) throws Exception {

		String defaultFormat = "yyyy-MM-dd";
		return AppUtil.parseDate(strDate, defaultFormat);

	}

	public static BigDecimal parseNumber(String strNum) throws Exception {

		try {
			return new BigDecimal(strNum);
		} catch (Exception e) {
			return null;
		}

	}

	public static String dateString(Calendar date) {
		String st;

		try {
			st = String.valueOf(date.get(Calendar.YEAR)) + "-"
					+ String.valueOf(date.get(Calendar.MONTH) + 1) + "-"
					+ String.valueOf(date.get(Calendar.DAY_OF_MONTH));
			return st;
		} catch (Exception e) {
			return null;
		}

	}

	public static String dateMMddyyyy(Calendar date) {
		String st;

		try {
			st = String.valueOf(date.get(Calendar.MONTH) + 1) + "/"
					+ String.valueOf(date.get(Calendar.DAY_OF_MONTH)) + "/"
					+ String.valueOf(date.get(Calendar.YEAR));
			return st;
		} catch (Exception e) {
			return null;
		}
	}

	public static BigDecimal numFormat(BigDecimal num) {
		BigDecimal bd = num;
		try {
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			return bd;
		} catch (Exception e) {
			return null;
		}
	}

	public static String timeStmpToStr(Timestamp t) {
		return timeStmpToStrWithFormat(t, "MM/dd/yyyy");
	}

	public static String timeStmpToStrWithFormat(Timestamp t, String format) {
		if (t == null) {
			return "";
		}
		String s = new SimpleDateFormat(format).format(t);
		return s;
	}

	public static Timestamp strToTimeStamp(String str, String format)
			throws Exception {

		Calendar c = AppUtil.parseDate(str, format);

		Timestamp t = new Timestamp(c.getTimeInMillis());

		return t;
	}

}
