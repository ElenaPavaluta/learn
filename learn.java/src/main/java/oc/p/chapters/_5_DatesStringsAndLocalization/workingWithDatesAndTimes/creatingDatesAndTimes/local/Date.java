package oc.p.chapters._5_DatesStringsAndLocalization.workingWithDatesAndTimes.creatingDatesAndTimes.local;

import java.time.LocalDate;
import java.time.Month;

class Date {

    static LocalDate localDate;

    static void print(){
        System.out.println(localDate);
        System.out.println();
    }

    static void m(){
        localDate = LocalDate.now();
        print();

        localDate = LocalDate.of(1982, 2, 03);
        print();

        localDate = LocalDate.of(678, Month.APRIL, 23);
        print();
    }

    static void m2(){
        localDate = LocalDate.of(-9, 1, 2);
        print();
    }

    static void m3(){
        localDate = LocalDate.of(23, -1, 1); //RE
        print();
    }

    static void m4(){
        localDate = LocalDate.of(123, Month.APRIL, 32); //RE
        print();
    }

    static void m5(){
        localDate = localDate.of(400, Month.FEBRUARY, 29);
        print();
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
//        m4();
        m5(); //0400-02-29
    }
}
