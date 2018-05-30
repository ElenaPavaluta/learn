package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.formattingDatesAndTimes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * yyyy
 * y represents the year.
 * yy outputs a two-digit year and
 * yyyy outputs a four-digit year.
 * YYYY - seems to be a difference for parsing: don't know yet, but for parsing use y instead of Y
 *
 * MMMM
 * M represents the month.
 * M outputs 1,
 * MM outputs 01,
 * MMM outputs Jan,
 * MMMM outputs January.
 *
 * dd
 * d represents the day in the month.
 * dd means to include the leading zero for a single-digit day.
 * DD represents day of year
 *
 * hh
 * h represents the hour.
 * hh to include the leading zero if you’re outputting a single-digit hour.
 * HH 24 hour format
 *
 * mm
 * date represents the minute omitting the leading zero if present.
 * mm is more common and represents the minutes using two digits.
 *
 * ss
 * seconds
 *
 * a
 * AM/PM
 *
 * n  for nanoseconds
 *
 * ns/ nss
 * A/N nono of day
 *
 * , if you want to output a comma (this also appears after the year).
 * : if you want to output a colon
 */
class Custom {

    static LocalDateTime dateTime = LocalDateTime.now();

    static void m() {
        String pattern = "YYYY MMMM DD, HH:mm:SS.N A";
        System.out.println(DateTimeFormatter.ofPattern(pattern).format(dateTime));

        pattern = pattern.replace('A', 'a');
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern(pattern)));

        pattern = pattern.replace("YYYY", "yyyy");
        System.out.println(DateTimeFormatter.ofPattern(pattern).format(dateTime));

//        pattern = pattern.replace("MMMM", "mmmm");  //RE: IllegalArgumentException: to many ms: M is used for month and date is used for minutes
//        System.out.println(dateTime.format(DateTimeFormatter.ofPattern(pattern)));

        pattern = pattern.replace('D', 'd');
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern(pattern)));

        pattern = pattern.replace("HH", "hh");
        System.out.println(DateTimeFormatter.ofPattern(pattern).format(dateTime));

        pattern = pattern.replace('S', 's');
        System.out.println(DateTimeFormatter.ofPattern(pattern).format(dateTime));

        pattern = pattern.replace("N", "n");
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern(pattern)));

        pattern = pattern.replace("n", "ns");
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern(pattern)));

        pattern = pattern.replace("ns", "nss");
        System.out.println(DateTimeFormatter.ofPattern(pattern).format(dateTime));
    }


    public static void main(String[] args) {
        m();
    }
}
