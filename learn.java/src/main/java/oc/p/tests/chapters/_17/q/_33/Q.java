package oc.p.tests.chapters._17.q._33;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

class Q {

    static void m(){
        LocalDate xmas  = LocalDate.of(2017, 12, 25);
        LocalDate blackF = LocalDate.of(2017, 11, 24);

        Long shoppingDaysLeft = ChronoUnit.DAYS.between(blackF, xmas);
        Long shoppingDaysLeft2 = blackF.until(xmas, ChronoUnit.DAYS);


        System.out.println(shoppingDaysLeft);
    }

    public static void main(String[] args) {
        m();
    }
}
