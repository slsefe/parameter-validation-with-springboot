package org.example.utils.datetime;

import java.time.LocalDate;
import java.time.Period;

public class PeriodDemo {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(2020, 5, 1);
        LocalDate otherLocalDate = LocalDate.of(2020, 6, 1);
        // 由日期计算时间段
        Period period = Period.between(localDate, otherLocalDate);
        System.out.println(period);

        // 指定时间段
        Period period1 = Period.of(1, 2, 3);
        System.out.println(period1);

        // 获取时间段天数
        int days = period1.getDays();
        System.out.println(days);

        // 对时间段增加天数
        Period newPeriod = period1.plusDays(3);
        System.out.println(newPeriod);

        // 日期增加一个时间段
        LocalDate nowLocalDate = LocalDate.now();
        LocalDate newLocalDate = nowLocalDate.plus(newPeriod);
        System.out.println(newLocalDate);
    }
}
