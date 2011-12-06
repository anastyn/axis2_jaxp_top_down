package com.github.anastyn;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateBinder {

public static Date parseDateTime(String s) {
		DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		DateTime dateTime = dtf.parseDateTime(s);
		return dateTime.toDate();
    }

    // crazy hack because the 'Z' formatter produces an output incompatible with the xsd:dateTime
    public static String printDateTime(Date dt) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        DateFormat tzFormatter = new SimpleDateFormat("Z");
        String timezone = tzFormatter.format(dt);
        return formatter.format(dt) + timezone.substring(0, 3) + ":"
                + timezone.substring(3);
    }

}
