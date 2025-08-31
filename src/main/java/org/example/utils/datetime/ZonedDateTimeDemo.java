package org.example.utils.datetime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZonedDateTimeDemo {
    public static void main(String[] args) {
        // 创建巴黎所在的时区
        ZoneId zoneId = ZoneId.of("Europe/Paris");

        // 获取系统默认时区
        ZoneId defaultZoneId = ZoneId.systemDefault();

        // 获取所有可用时区
        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
        allZoneIds.forEach(System.out::println);

        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.FEBRUARY, 20, 6, 30);
        // 实例化 ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(zonedDateTime);

        ZoneId otherZoneId = defaultZoneId;
        // 转换成另一个时区的 ZonedDateTime
        ZonedDateTime otherZonedDateTime = zonedDateTime.withZoneSameInstant(otherZoneId);
        System.out.println(otherZonedDateTime);

        // 转换成本地时间
        LocalDateTime otherLocalDateTime = zonedDateTime.toLocalDateTime();
        System.out.println(otherLocalDateTime);
    }
}
