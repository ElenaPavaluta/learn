package oc.p.chapters.c_5_DatesStringsAndLocalization.workingWithDatesAndTimes.manipulatingDatesAndTimes;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;

/**
 * plus(long amountToAdd, TemporalUnit unit)
 *
 * plus(TemporalAmount amountToAdd)
 *
 * minus(long amountToSubtract, TemporalUnit unit)
 *
 * minus(TemporalAmount amountToSubtract)
 */
class PlusMinus {

    static LocalDate date = LocalDate.now();
    static LocalTime time = LocalTime.now();
    static LocalDateTime dateTime = LocalDateTime.now();
    static ZonedDateTime zonedDateTime = ZonedDateTime.now();
    static Instant instant = Instant.now();

    static void date(){
        System.out.println(date);
        date = date.plus(1, ChronoUnit.DAYS);
        date = date.plus(Period.ofDays(1));
        System.out.println(date);

        date = date.minus(1, ChronoUnit.DAYS);
        date = date.minus(Period.ofDays(1));
        System.out.println(date);

//        date.plus(1,ChronoUnit.HOURS);  //RE: DateTimeException
    }

    static void time(){
        System.out.println(time);

        time = time.plus(Duration.ofDays(23));
//        time = time.plus(23, ChronoUnit.DAYS);  //RE: DateTimeException
        time = time.plus(3, ChronoUnit.HOURS);
        System.out.println(time);

        time = time.minus(Duration.ofDays(23));
        time = time.minus(3, ChronoUnit.HOURS);
        System.out.println(time);
    }

    static void dateTime(){
        System.out.println(dateTime);

        dateTime = dateTime.plus(Period.of(1, 1, 1));
        System.out.println(dateTime);

        dateTime = dateTime.minus(Duration.ofDays(1));
        System.out.println(dateTime);

        dateTime = dateTime.minus(2, ChronoUnit.DAYS);
    }

    static void zonedDateTime(){
        System.out.println(zonedDateTime);

        zonedDateTime = zonedDateTime.plus(Duration.ofDays(2));
        zonedDateTime = zonedDateTime.plus(Period.ofDays(2));
        System.out.println(zonedDateTime);

        zonedDateTime = zonedDateTime.plus(2, ChronoUnit.WEEKS);
        zonedDateTime = zonedDateTime.minus(1, ChronoUnit.YEARS);
        System.out.println(zonedDateTime);

        zonedDateTime = zonedDateTime.plus(Period.ofYears(2));
        zonedDateTime = zonedDateTime.minus(10, ChronoUnit.YEARS);
        System.out.println(zonedDateTime);
    }

    static void instant(){
        System.out.println(instant);

//        instant = instant.plus(Period.ofYears(10));  //RE: DateTimeException

//        instant = instant.plus(2, ChronoUnit.MONTHS);
//        instant = instant.plus(1, ChronoUnit.WEEKS);  //RE:  DateTimeException
        instant = instant.plus(1, ChronoUnit.DAYS);
        instant = instant.plus(23, ChronoUnit.HOURS);
        System.out.println(instant);

//        instant = instant.plus(Period.ofYears(1));  //DateTimeException
//        instant = instant.plus(Period.ofMonths(1));
        instant = instant.plus(Period.ofWeeks(1));
        instant = instant.plus(Period.ofDays(1));
        System.out.println(instant);

        instant = instant.plus(Duration.ofDays(1));
        System.out.println(instant);

        instant = instant.plusSeconds(10);
        instant = instant.plusMillis(10).plusNanos(10);
        System.out.println(instant);
    }

    public static void main(String[] args) {
//        date();
//        time();
//        dateTime();
        zonedDateTime();
//        instant();
    }

}
