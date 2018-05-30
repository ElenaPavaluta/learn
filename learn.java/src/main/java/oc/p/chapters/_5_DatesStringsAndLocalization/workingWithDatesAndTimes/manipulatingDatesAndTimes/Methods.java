package oc.p.chapters._5_DatesStringsAndLocalization.workingWithDatesAndTimes.manipulatingDatesAndTimes;

import java.time.*;

/**
 * Leap years are years that are a multiple of 4 or 400 but not other multiples of 100.
 */
class Methods {

    static LocalDate localDate = LocalDate.now();
    static LocalTime localTime = LocalTime.now();
    static LocalDateTime localDateTime = LocalDateTime.now();
    static ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.systemDefault());

    static void m() {
        localDate = localDate.plusYears(1).minusYears(1);
        localDate = localDate.plusMonths(1).minusMonths(1);
        localDate = localDate.plusWeeks(1).minusWeeks(1);
        localDate = localDate.plusDays(1).minusDays(1);

        System.out.println(localDate);
        System.out.println();

//        localDate = localDate.plusHours(2);  //compilerError: the method does not exists for the LocalDate
    }

    static void m2() {
        localTime = localTime.plusHours(1).minusHours(1);
        localTime = localTime.plusMinutes(1).minusMinutes(1);
        localTime = localTime.plusSeconds(1).minusSeconds(1);
        localTime = localTime.plusNanos(1).minusNanos(1);

        System.out.println(localTime);
        System.out.println();

//        localTime = localTime.plusDays(2)  //compilerError: the method does not exists for the LocalTime
    }

    static void m3() {
        localDateTime = localDateTime.plusYears(1).minusYears(1);
        localDateTime = localDateTime.plusMonths(1).minusMonths(1);
        localDateTime = localDateTime.plusWeeks(1).minusWeeks(1);
        localDateTime = localDateTime.plusDays(1).minusDays(1);
        localDateTime = localDateTime.plusHours(1).minusHours(1);
        localDateTime = localDateTime.plusMinutes(1).minusMinutes(1);
        localDateTime = localDateTime.plusSeconds(1).minusSeconds(1);
        localDateTime = localDateTime.plusNanos(1).minusNanos(1);

        System.out.println(localDateTime);
        System.out.println();
    }

    static void m4() {
        zonedDateTime = zonedDateTime.plusYears(1).minusYears(1);
        zonedDateTime = zonedDateTime.plusMonths(1).minusMonths(1);
        zonedDateTime = zonedDateTime.plusWeeks(1).minusWeeks(1);
        zonedDateTime = zonedDateTime.plusDays(1).minusDays(1);
        zonedDateTime = zonedDateTime.plusHours(1).minusHours(1);
        zonedDateTime = zonedDateTime.plusMinutes(1).minusMinutes(1);
        zonedDateTime = zonedDateTime.plusSeconds(1).minusSeconds(1);
        zonedDateTime = zonedDateTime.plusNanos(1).minusNanos(1);

        System.out.println(zonedDateTime);
    }

    static void m5() {
        m();
        m2();
        m3();
        m4();
    }

    static void m6() {
        System.out.println(localDateTime.plusYears(-300));
        System.out.println(localTime.plusMinutes(Integer.MAX_VALUE));

    }

    public static void main(String[] args) {
        m5();
        m6();
    }

}
