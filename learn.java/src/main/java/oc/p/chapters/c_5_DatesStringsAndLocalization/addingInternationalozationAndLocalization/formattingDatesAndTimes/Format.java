package oc.p.chapters.c_5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.formattingDatesAndTimes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

class Format {

    static LocalDate date = LocalDate.now();
    static LocalTime time = LocalTime.now();
    static LocalDateTime dateTime = LocalDateTime.now();

    static void space(){
        System.out.println();
    }

    static void m(){
        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);
        space();
    }

    static void iso(){
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));  //2018-02-02
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(date));
        space();

        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));  //23:11:43.868
        System.out.println(DateTimeFormatter.ISO_LOCAL_TIME.format(time));
        space();

        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));  //2018-02-02T23:11:43.868
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(dateTime));
        space();
    }

    static void shortM(){
        space();
        System.out.println(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(date));
        space();

        System.out.println(time.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
        System.out.println(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(time));
        space();

        System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(dateTime));
        space();
    }

    static void mediumM(){
        space();
        System.out.println(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(date));
    }

    public static void main(String[] args) {
        m();
        iso();
        shortM();
    }


}
