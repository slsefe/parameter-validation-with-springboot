package org.example.utils.datetime;

import java.time.LocalDateTime;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        // 指定当前会议时间为2020年4月1日下午2点半
        LocalDateTime meetingTime = LocalDateTime.of(2020, 4, 1, 14, 30, 0);
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();

        // 比较判断会议是否已经开始
        if (now.isAfter(meetingTime)) {
            // 若会议已经开始，则计算明天是哪一天, 然后修改会议时间为明天同一时间，并打印新会议时间
            LocalDateTime tomorrow = now.plusDays(1);
            int newDayOfYear = tomorrow.getDayOfYear();

            meetingTime = meetingTime.withDayOfYear(newDayOfYear);
            System.out.println(meetingTime);
        } else {
            // 若会议还没开始，则打印说明
            System.out.println("会议还没开始呢");
        }
    }
}
