package oc.p.tests.chapters._17.q._9;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;

class Q {

    static void m() {
        Locale.setDefault(Locale.US);
        LocalDate localDate = LocalDate.of(2017, 2, 12);
//        LocalTime localTime = LocalTime.of(2, 0);
        LocalTime localTime = LocalTime.of(3, 0);
        ZoneId id = ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, localTime, id);
        System.out.println(zonedDateTime);
    }

    public static void main(String[] args) {
        m();
    }
}
