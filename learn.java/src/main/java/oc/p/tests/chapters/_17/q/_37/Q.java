package oc.p.tests.chapters._17.q._37;

import java.time.LocalDate;
import java.time.Month;

class Q {

    static void m(){
        LocalDate date = LocalDate.of(2017, Month.MARCH, 3);
        LocalDate date2 = date.plusDays(2).minusDays(1).minusDays(1);

        System.out.println(date.equals(date2));
    }

    public static void main(String[] args) {
        m();
    }
}
