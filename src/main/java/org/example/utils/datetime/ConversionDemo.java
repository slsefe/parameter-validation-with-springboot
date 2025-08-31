package org.example.utils.datetime;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * 新老日期时间API之间的转换
 */
public class ConversionDemo {
    public static void main(String[] args) {
        // Instant <-> Date
        Instant instant = Instant.now();
        Date date = Date.from(instant);
        Instant instant1 = date.toInstant();
        System.out.println(instant);
        System.out.println(instant1);

        // ZonedDateTime <-> GregorianCalendar
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        GregorianCalendar calendar = GregorianCalendar.from(zonedDateTime);
        ZonedDateTime zonedDateTime1 = calendar.toZonedDateTime();
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime1);
    }
}
