package oc.p.chapters.c_8_IO.understandingFileAndDirectories.introducingTheFileClass.workingWithAFileObject.tw;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

class Tm {

    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt);

        ZonedDateTime zdt2 = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.of("CET"));
        System.out.println(zdt2);
    }
}
