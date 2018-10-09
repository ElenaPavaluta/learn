package oc.p.chapters._5_DatesStringsAndLocalization.workingWithDatesAndTimes.workingWithInstants.tw;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

class I {

    static Instant instant;

    static void m(){
        instant = Instant.now();
        instant = ZonedDateTime.now().toInstant();
        instant = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant();
    }

    public static void main(String[] args) {
        System.out.println(args.length);
//        System.out.println(args[0]);
    }

}


