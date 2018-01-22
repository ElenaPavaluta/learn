package oc.p.chapters.c_5_DatesStringsAndLocalization.workingWithDatesAndTimes.creatingDatesAndTimes.local;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * static LocalTime	of(int hour, int minute)
 *
 * static LocalTime	of(int hour, int minute, int second)
 *
 * static LocalTime	of(int hour, int minute, int second, int nanoOfSecond)
 *
 */
class Time {

    static LocalTime localTime;

    static void print(){
        System.out.println(localTime);
        System.out.println();
    }

    static void m(){
        localTime = LocalTime.now();
        print();

        localTime = LocalTime.of(23, 23);  //23:23
        print();

        localTime = LocalTime.of(23, 23, 23); //23:23:23
        print();

        localTime = LocalTime.of(23, 23, 23, 23 ); //23:23:23.000000023
        print();
    }

    static void m2(){
        localTime = LocalTime.of(25, 23, 23, 23);  //RE: DateTimeException
        print();
    }

    static void m3(){
        localTime = LocalTime.of(23, -1, 23, 34);  //RE: DateTimeException
        print();
    }

    static void m4(){
        localTime = LocalTime.of(23, 23, 60);  //RE: DateTimeException
        print();
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
    }
}
