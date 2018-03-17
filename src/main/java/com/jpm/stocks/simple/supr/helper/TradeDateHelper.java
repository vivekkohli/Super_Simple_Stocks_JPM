package com.jpm.stocks.simple.supr.helper;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Minutes;

public class TradeDateHelper {

	// adjusts the CURRENT time by the given minutes- both forward & backward (backward
	// is what is used by the application)
	public static Date getCurrentTimeAdjustedInMinutes(int minutes) {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, minutes);
		return now.getTime();
	}

	public static boolean isWithinMinutes(Date time, int mins) {
		DateTime now = new DateTime();
		DateTime givenTime = new DateTime(time.getTime());
		Minutes diffInMinutes = Minutes.minutesBetween(givenTime, now);
		if (diffInMinutes.getMinutes() <= mins) {
			return true;
		}
		return false; 
	}
}
