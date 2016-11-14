package com.github.anastyn;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
* Marshalling and unmarshalling dates.
**/
public class DateBinder {

    /**
     * Convert xsd:dateTime string to a date instance.
     * @param dateString xsd:dateTime string
     * @return the date instance
     */
    public static Date parseDateTime(String dateString) {
		DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		DateTime dateTime = dtf.parseDateTime(dateString);
		return dateTime.toDate();
    }

    /**
     * Convert a date instance to xsd:dateTime string.
     * @param date date to convert
     * @return the string representation of the input date.
     */
    public static String printDateTime(Date date) {
        // a hack, the 'Z' formatter produces an output incompatible with the xsd:dateTime
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        DateFormat tzFormatter = new SimpleDateFormat("Z");
        String timezone = tzFormatter.format(date);
        return formatter.format(date) + timezone.substring(0, 3) + ":"
                + timezone.substring(3);
    }

}
