package oc.p.chapters.c_6_ExceptionsAndAssertions.reviewingExceptions.exceptionsOnTheOcp.unchecked.java.lang;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class Oca {

    static void arithmeticException(){
        System.out.println(1/0); //ArithmeticException
    }

    static void arrayIndexOutOfBoundsException(){
        int[] ar = {1, 3};
        System.out.println(ar[2]);
    }

    static void classCastException(){
        Object[] ar = {LocalDateTime.now()};
        LocalDate date = (LocalDate)ar[0];
        date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    static void illegalArgumentException(){
        class A{
            void m(int i){
                if(i<0) throw new IllegalArgumentException();
            }
        }

        new A().m(-9);
    }

    static void nullPointerException(){
        ZonedDateTime zoned = null;
        zoned = zoned.plusHours(1);
    }

    static void numberFormatException(){
        Integer.parseInt("bla");
    }

    public static void main(String[] args) {
//        arithmeticException();
//        arrayIndexOutOfBoundsException();
//        classCastException();
//        illegalArgumentException();
//        nullPointerException();
        numberFormatException();
    }



}
