package oc.p.chapters.c_5_DatesStringsAndLocalization.workingWithDatesAndTimes.workingWithInstants;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * The Instant class represents a specific moment in time in the GMT time zone
 *
 * Instant allows you to add any unit day or smaller
 *
 *
 *  Instant	plus(long amountToAdd, TemporalUnit unit)
 *
 *  Instant	plus(TemporalAmount amountToAdd)
 *
 *  Instant	plusMillis(long millisToAdd)
 *
 *  Instant	plusNanos(long nanosToAdd
 *
 *  Instant	plusSeconds(long secondsToAdd)
 */
class Instants {

    static Instant instant;

    static void m(){
        ZonedDateTime zoneDateTime = ZonedDateTime.now();

        instant = zoneDateTime.toInstant();  //2018-01-23T10:46:02.209Z
        System.out.println(instant);
    }


    static void m2(){
        instant = Instant.now();

        instant = instant.plus(1, ChronoUnit.WEEKS); //RE
    }

    static void m3(){
        instant = Instant.now();
        instant = instant.plus(1, ChronoUnit.DAYS).minus(1, ChronoUnit.DAYS);
        System.out.println(instant);
    }

    static void m4(){
        instant = Instant.now();
        instant = instant.plusSeconds(1).minusSeconds(1);
        instant = instant.plusMillis(1).minusMillis(1);
        instant = instant.plusNanos(1).minusMillis(1);
        System.out.println(instant);
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
    }


}
