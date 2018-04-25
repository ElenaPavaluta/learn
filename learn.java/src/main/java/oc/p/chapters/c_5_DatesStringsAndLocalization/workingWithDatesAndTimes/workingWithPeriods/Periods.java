package oc.p.chapters.c_5_DatesStringsAndLocalization.workingWithDatesAndTimes.workingWithPeriods;

import java.time.*;

/**
 * static Period	of(int years, int months, int days)
 *
 * static Period	ofDays(int days)
 *
 * static Period	ofMonths(int months)
 *
 * static Period	ofWeeks(int weeks)
 *
 * static Period	ofYears(int years)
 *
 *
 * BEWARE! due to the fact that this are static methods,
 * chaining them results in only having the last chained value
 */
class Periods {
   static LocalDate date = LocalDate.now();
   static LocalTime time  = LocalTime.now();
   static LocalDateTime dateTime = LocalDateTime.now();
   static ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.systemDefault());

   static Period period;

   static void m(){
       period = Period.ofYears(1);

       date = date.plus(period).minus(period);
//       time.plus(period).minus(period);  //RE -
       dateTime.plus(period).minus(period);
       zonedDateTime.plus(period).minus(period);
   }

   static void m2(){
       period = Period.ofYears(1);
       System.out.println(period);

       period = Period.ofMonths(1);
       System.out.println(period);

       period = Period.ofWeeks(1);
       System.out.println(period);

       period = Period.ofDays(1);
       System.out.println(period);

       period = Period.of(1, 1, 45);  //P1Y1M45D
       System.out.println(period);
   }

   static void m3(){
       period = Period.of(0, 0, 0);  //P0D
       System.out.println(period);

       period = Period.of(-1, -1, -1);  //P-1Y-1M-1D
       System.out.println(period);
   }

   static void m4(){
       period = Period.of(1, 1, 2);  //P1Y1M2D

       date = date.minus(period);
       dateTime = dateTime.minus(period);
       zonedDateTime = zonedDateTime.minus(period);
   }

   static void m5(){
       period = Period.ofDays(30);
       System.out.println(period);

       period = Period.of(0, 1, 30);
       System.out.println(period);
   }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
//        m4();
        m5();
    }

}
