package oc.p.chapters.c_5_DatesStringsAndLocalization.workingWithDatesAndTimes.creatingDatesAndTimes.zoned;

import java.time.*;

/**
 * static ZonedDateTime	now(ZoneId zone)
 *
 * static ZonedDateTime	of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond, ZoneId zone)
 *
 * static ZonedDateTime	of(LocalDate date, LocalTime time, ZoneId zone)
 *
 * static ZonedDateTime	of(LocalDateTime localDateTime, ZoneId zone)
 *
 *
 * The time zone offset can be listed in different ways: +02:00, GMT+2, and UTC+2
 */
class DateTime {


    static ZonedDateTime zonedDateTime;
    static ZoneId zoneId = ZoneId.systemDefault();

    static void print(){
        System.out.println(zonedDateTime);
        System.out.println();
    }

    static void m(){
        zonedDateTime = ZonedDateTime.now(zoneId);  //2018-01-23T01:29:25.330+02:00[Europe/Athens]
        print();

        zonedDateTime = ZonedDateTime.of(400, 02, 29, 23, 23, 23, 23, zoneId);
        print();

        zonedDateTime = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), zoneId);
        print();

        zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);
        print();
    }

    public static void main(String[] args) {
        m();
    }
}
