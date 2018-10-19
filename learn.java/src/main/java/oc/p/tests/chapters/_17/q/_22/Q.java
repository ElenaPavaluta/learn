package oc.p.tests.chapters._17.q._22;

import sun.util.resources.LocaleData;

import java.time.*;
import java.util.Locale;

class Q {

    static void m(){
        LocalDate ld = LocalDate.of(2017, Month.MAY, 10);
        LocalTime lt = LocalTime.of(5, 40);
        LocalDateTime ldt = LocalDateTime.of(ld, lt);
        Duration d = Duration.ofDays(1);
        LocalDateTime res = ldt.minus(d);
        System.out.println(res);
    }

    public static void main(String[] args) {
        m();
    }
}
