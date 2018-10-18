package oc.p.tests.chapters._17.q._17;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;

class Q {

    static void m(){
        Period p = Period.ofDays(1);
        Duration d = Duration.ofDays(1);

        System.out.println(p);
        System.out.println(d);
    }

    static void m2(){
        Period p = Period.of(1, 2, 3);
        Duration d = Duration.ofMinutes(34);

        System.out.println(p);
        System.out.println(d);

        d = Duration.ofHours(4);
        System.out.println(d);

        d = Duration.of(3, ChronoUnit.SECONDS);
        System.out.println(d);

        d = Duration.of(3, ChronoUnit.MILLIS);
        System.out.println(d);

        d = Duration.of(3, ChronoUnit.MICROS);
        System.out.println(d);

        d = Duration.of(3, ChronoUnit.NANOS);
        System.out.println(d);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
