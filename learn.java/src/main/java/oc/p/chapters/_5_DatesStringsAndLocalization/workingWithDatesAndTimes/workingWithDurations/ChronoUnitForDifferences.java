package oc.p.chapters._5_DatesStringsAndLocalization.workingWithDatesAndTimes.workingWithDurations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class ChronoUnitForDifferences {

    static LocalTime time = LocalTime.of(1, 1, 1, 1);
    static LocalTime time2 = LocalTime.of(6, 30);
    static LocalDate date = LocalDate.of(1908, 12, 4);

    static void m() {
        System.out.println(ChronoUnit.HOURS.between(time, time2));
        System.out.println(ChronoUnit.MINUTES.between(time, time2));
        System.out.println(ChronoUnit.SECONDS.between(time, time2));
        System.out.println(ChronoUnit.MILLIS.between(time, time2));
        System.out.println(ChronoUnit.NANOS.between(time, time2));

//        System.out.println(ChronoUnit.HOURS.between(time, date));  //RE
    }

    public static void main(String[] args) {
        m();
    }
}
