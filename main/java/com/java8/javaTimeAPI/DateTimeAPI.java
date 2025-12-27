package com.java8.javaTimeAPI;

import java.time.*;

public class DateTimeAPI {
    public static void main(String[] args) {
//        LocalDate localDate = LocalDate.now();
        LocalDate localDate = LocalDate.of(2004, Month.NOVEMBER,19);
        System.out.println(localDate);

        Instant i = Instant.now();
        System.out.println(i);

        LocalTime localTime = LocalTime.now(ZoneId.of("Japan"));

        for(String s : ZoneId.getAvailableZoneIds()){
            System.out.println(s);
        }

//        LocalTime localTime = LocalTime.of(12,35,10,999);
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

    }
}
