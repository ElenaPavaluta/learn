package oc.p.tests.chapters._17.q.rmb;

import utils.print.Print;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

class TimeFormat {

    static LocalDate localDate = LocalDate.now();
    static LocalTime localTime = LocalTime.now();
    static LocalDateTime localDateTime = LocalDateTime.now();
    static ZonedDateTime zonedDateTime = ZonedDateTime.now();
    static Instant instant = Instant.now();


    static void def() {
        System.out.println(localDate);  //2018-10-17
        System.out.println(localTime);  //10:13:03.234
        System.out.println(localDateTime);  //2018-10-17T10:13:03.234
        System.out.println(zonedDateTime);  //2018-10-17T10:13:03.234+02:00[Zone]
        System.out.println(instant);  //2018-10-17T8:13:03.234Z
    }

    static void formatISO() {
        System.out.println(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));  //2018-10-17
        System.out.println(localTime.format(DateTimeFormatter.ISO_LOCAL_TIME));  //10:32:32.789
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));  //2018-10-17T10:32:32.789
        System.out.println(zonedDateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));  //2018-10-17T10:32:32.789+02:00[]
        System.out.println(DateTimeFormatter.ISO_INSTANT.format(instant));  //2018-10-17T10:32:32.789
    }

    static void formatShort() {
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(localDate));  //10/17/18
        System.out.println(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(localTime));  //10:40 AM
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(localDateTime));  //10/17/18 10:40 AM
    }

    static void formatMedium() {
        System.out.println(localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));  // Oct 17, 2018
        System.out.println(localTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));  //10:40.234 AM
        System.out.println(localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));  //Oct 17, 2018 10:40:234 AM
    }

    static void localDateOfPattern() {
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("yy_MM_dd")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("yyy_MM_dd")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("yyyy_MM_dd")));
        Print.Delimitators.equal();
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("YYYY_MM_dd")));
//        System.out.println(localDate.format(DateTimeFormatter.localDateOfPattern("YYYY_MM_DD")));
    }

    static void localTimeOfPattern() {
        /**
         * Beware
         * nn RE
         * N prints something else
         * A prints somethig else
         */
        System.out.println(localTime.format(DateTimeFormatter.ofPattern("hh:mm_ss:n a")));
        System.out.println(localTime.format(DateTimeFormatter.ofPattern("HH:mm_ss:n a")));
        System.out.println(localTime.format(DateTimeFormatter.ofPattern("HH:mm_SS:n a")));
        System.out.println(localTime.format(DateTimeFormatter.ofPattern("HH:mm_SS:n a")));
    }

    static void localDateTimeOfPattern(){
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("DDD")));
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("A")));  //don't know what is this
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("N")));  //same here
    }

    public static void main(String[] args) {
//        def();
//        formatISO();
//        formatShort();
//        formatMedium();
//        localDateOfPattern();
//        localTimeOfPattern();
        localDateTimeOfPattern();
    }
}
