package oc.p.chapters.c_5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.formattingDatesAndTimes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * parse(CharSequence text, DateTimeFormatter formatter)
 *
 * parse(CharSequence text)
 *
 *  2007-12-03
 *
 *  10:15
 *
 *  2007-12-03T10:15:30
 *
 *  2007-12-03T10:15:30+01:00[Europe/Paris]
 *
 *  2007-12-03T10:15:30.00Z
 */
class Parsing {

    //Beware: Y and y don't do the same thing for parsing; use y for parsing


    static void date(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d  MM  yyyy");

        String date = "16  08  2016";

        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println(localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));


//        localDate = LocalDate.parse("32  12  2017", formatter);  //RE - DateTimeException

//        localDate = LocalDate.parse("23  -01  2018", formatter);  //DateTimeException

//        localDate = LocalDate.parse("23  12  -2134", formatter);  //DateTimeException
    }

    static void time(){
        String pattern = "H mm s n";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        LocalTime time = LocalTime.parse("12 34 34 45", formatter);
        System.out.println(time);

//        time = LocalTime.parse("12 34", formatter);  ///DateTimeException

//        time = LocalTime.parse("12 64 34 34", formatter);

//        time = LocalTime.parse("25 34 34 34", formatter);
    }

    public static void main(String[] args) {
//        date();
        time();
    }
}
