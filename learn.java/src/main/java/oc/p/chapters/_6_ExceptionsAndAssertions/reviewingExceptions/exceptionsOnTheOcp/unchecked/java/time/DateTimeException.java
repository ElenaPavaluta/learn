package oc.p.chapters._6_ExceptionsAndAssertions.reviewingExceptions.exceptionsOnTheOcp.unchecked.java.time;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

class DateTimeException {

    static void m() {
        String pattern = "YYYY MM dd";

        String date = "1897 13 33";
        TemporalAccessor ta = DateTimeFormatter.ofPattern(pattern).parse(date);  // legal and it's producing a result
        System.out.println(ta + "\n");

        date = date + 'a';
        ta  = DateTimeFormatter.ofPattern(pattern).parse(date);  //throws DateTimeException
    }

    public static void main(String[] args) {
        m();
    }
}
