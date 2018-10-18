package oc.p.tests.chapters._17.q.rmb;

import utils.javaClass.hierrarchy.methods.alphabet.D;
import utils.print.Print;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;

class DurationAndPeriodToString {

    static void m(){
        Period p = Period.of(1, 2, 3);
        System.out.println(p);

        p = Period.ofYears(1);
        System.out.println(p);

        p = Period.ofMonths(13);
        System.out.println(p);

        p = Period.ofWeeks(7);
        System.out.println(p);

        p = Period.ofDays(1);
        System.out.println(p);
    }

    static void m2(){
        Duration d = Duration.ofDays(5);
        System.out.println(d);

        d = Duration.ofHours(3);
        System.out.println(d);

        d = Duration.ofMinutes(3);
        System.out.println(d);

        d = Duration.ofSeconds(1);
        System.out.println(d);

        d = Duration.ofMillis(6);
        System.out.println(d);

        d = Duration.of(5, ChronoUnit.MICROS);
        System.out.println(d);

        d = Duration.ofNanos(23);
        System.out.println(d);

    }

    public static void main(String[] args) {
        m();
        Print.Delimitators.equal();
        m2();
    }
}
