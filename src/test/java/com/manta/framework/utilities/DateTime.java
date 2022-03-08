package com.manta.framework.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class DateTime {

	/**
	 * To get current timestamp
	 *
	 * @return Current TimeStamp
	 */
	public static String getCurrentTimeStampString() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmssSS");
		TimeZone timeZone = TimeZone.getDefault();
		Calendar cal = Calendar.getInstance(new SimpleTimeZone(timeZone.getOffset(date.getTime()), "GMT"));
		dateFormat.setCalendar(cal);
		return dateFormat.format(date);
	}
}
