package oc.p.chapters.c_5_DatesStringsAndLocalization.workingWithDatesAndTimes.creatingDatesAndTimes.local;

import java.time.LocalDateTime;

/**
 *
 * static LocalDateTime	of(int year, int month, int dayOfMonth, int hour, int minute)
 *
 * static LocalDateTime	of(int year, int month, int dayOfMonth, int hour, int minute, int second)
 *
 * static LocalDateTime	of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond)
 *
 * static LocalDateTime	of(int year, Month month, int dayOfMonth, int hour, int minute)
 *
 * static LocalDateTime	of(int year, Month month, int dayOfMonth, int hour, int minute, int second)
 *
 * static LocalDateTime	of(int year, Month month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond)
 *
 * static LocalDateTime	of(LocalDate date, LocalTime time)
 *
 */
class DateTime {

    static LocalDateTime localDateTime;
    static void print(){
        System.out.println(localDateTime);
        System.out.println();
    }

    static void m(){
        localDateTime  =LocalDateTime.now();  //2018-01-23T00:39:56.387
        print();
    }

    public static void main(String[] args) {
        m();
    }
}
