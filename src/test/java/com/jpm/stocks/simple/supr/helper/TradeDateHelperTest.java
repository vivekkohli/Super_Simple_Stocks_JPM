package com.jpm.stocks.simple.supr.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Test;

public class TradeDateHelperTest {

	@Test
	public void testGetCurrentTimeAdjustedInMinutes_Future() {
		Date result=TradeDateHelper.getCurrentTimeAdjustedInMinutes(1);
		DateTime jodaResult=new DateTime(result.getTime());
		
		DateTime now = new DateTime();
		int min=now.getMinuteOfHour();
		
		assertEquals(min+1, jodaResult.getMinuteOfHour());

	}
	
	@Test
	public void testGetCurrentTimeAdjustedInMinutes_Past() {
		Date result=TradeDateHelper.getCurrentTimeAdjustedInMinutes(-1);
		DateTime jodaResult=new DateTime(result.getTime());
		
		DateTime now = new DateTime();
		int min=now.getMinuteOfHour();
		
		assertEquals(min-1, jodaResult.getMinuteOfHour());

	}
	
	@Test
	public void isWithinMinutes_Future() {
		DateTime testDate= new DateTime();
		testDate.plusMinutes(40);
		boolean result=TradeDateHelper.isWithinMinutes(testDate.toDate(), 50);
		assertTrue(result);

	}
	
	@Test
	public void isWithinMinutesd_Past() {
		DateTime testDate= new DateTime();
		testDate.minusMinutes(40);
		boolean result=TradeDateHelper.isWithinMinutes(testDate.toDate(), 50);
		assertTrue(result);

	}
	
}
