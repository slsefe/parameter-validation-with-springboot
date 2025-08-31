package org.example.utils.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        String timeStr = "2020-04-01 14:30:00";

        // 根据格式创建格式化类
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 从字符串解析得到会议时间
        LocalDateTime meetingTime = LocalDateTime.parse(timeStr, formatter);

        LocalDateTime now = LocalDateTime.now();
        if (now.isAfter(meetingTime)) {
            LocalDateTime tomorrow = now.plusDays(1);
            int newDayOfYear = tomorrow.getDayOfYear();
            meetingTime = meetingTime.withDayOfYear(newDayOfYear);

            // 格式化新会议时间
            String showTimeStr = formatter.format(meetingTime);
            System.out.println(showTimeStr);
        } else {
            System.out.println("会议还没开始呢");
        }
    }
}
