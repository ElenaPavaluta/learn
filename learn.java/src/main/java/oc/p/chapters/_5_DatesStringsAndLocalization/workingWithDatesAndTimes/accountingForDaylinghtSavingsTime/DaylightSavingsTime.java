package oc.p.chapters._5_DatesStringsAndLocalization.workingWithDatesAndTimes.accountingForDaylinghtSavingsTime;

import java.time.*;

class DaylightSavingsTime {

    static void m() {
        LocalDate localDate = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime localTime = LocalTime.of(1, 30);
        ZoneId zoneId = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, localTime, zoneId);
        System.out.println(zonedDateTime);  //2016-03-13T01:30-05:00[US/Eastern]
        zonedDateTime = zonedDateTime.plusHours(1);
        System.out.println(zonedDateTime);  //2016-03-13T03:30-04:00[US/Eastern]
    }

    static void m2() {
        LocalDate localDate = LocalDate.of(2016, Month.NOVEMBER, 6);
        LocalTime localTime = LocalTime.of(1, 30);
        ZoneId zoneId = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, localTime, zoneId);
        System.out.println(zonedDateTime);  //2016-11-06T01:30-04:00[US/Eastern]
        zonedDateTime = zonedDateTime.plusHours(1);  //2016-11-06T01:30-05:00[US/Eastern]
        System.out.println(zonedDateTime);

    }

    public static void main(String[] args) {
//        m();
        m2();
    }

}
