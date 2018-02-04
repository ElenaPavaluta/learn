package oc.p.chapters.c_5_DatesStringsAndLocalization.workingWithDatesAndTimes.workingWithDurations;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * static Duration	of(long amount, TemporalUnit unit)
 *
 * static Duration	ofDays(long days)
 *
 * static Duration	ofMinutes(long minutes)
 *
 * static Duration	ofSeconds(long seconds)
 *
 * static Duration	ofHours(long hours)
 *
 * static Duration	ofMillis(long millis)
 *
 * static Duration	ofNanos(long nanos)
 */
class Durations {

    static Duration duration;

    static void m() {
        duration = Duration.ofDays(367);
        print();

        duration = Duration.ofHours(3);
        print();

        duration = Duration.ofMinutes(61); //PT1H1M;
        print();

        duration = Duration.ofSeconds(61); //PT1M1S;
        print();

        duration = Duration.ofMillis(1); //PT001S
        print();

        duration = Duration.ofNanos(1);  //PT000000001S
        print();
    }


    static void m2() {
        duration = Duration.of(1, ChronoUnit.DAYS);  //PT24H
        print();

        duration = Duration.of(1, ChronoUnit.HOURS);  //PT1H
        print();

        duration = Duration.of(1, ChronoUnit.HALF_DAYS);  //  PT12H
        print();

        duration = Duration.of(1, ChronoUnit.MINUTES);  //PT1M
        print();

        duration = Duration.of(1, ChronoUnit.SECONDS);  //PT1S;
        print();

        duration = Duration.of(1, ChronoUnit.MILLIS);  //PT001S
        print();

        duration = Duration.of(1, ChronoUnit.NANOS);  //PT000000001S
        print();
    }

    static void m3(){
        duration = Duration.of(1, ChronoUnit.HOURS);

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        date = date.plus(duration).minus(duration);  //RE
//        time = time.plus(duration).minus(duration);
        localDateTime = localDateTime.plus(duration).minus(duration);
        zonedDateTime = zonedDateTime.plus(duration).minus(duration);
    }

    private static void print() {
        System.out.println(duration);
    }


    public static void main(String[] args) {
//        m();
//        m2();
        m3();

    }


}
