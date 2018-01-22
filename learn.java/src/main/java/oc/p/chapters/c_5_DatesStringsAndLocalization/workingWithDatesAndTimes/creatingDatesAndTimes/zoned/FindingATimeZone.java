package oc.p.chapters.c_5_DatesStringsAndLocalization.workingWithDatesAndTimes.creatingDatesAndTimes.zoned;

import java.time.ZoneId;
import java.util.function.Predicate;

class FindingATimeZone {

    static ZoneId zoneId;

    static void print() {
        System.out.println(zoneId);
        System.out.println();
    }

    static void m() {
        zoneId = ZoneId.of("US/EASTERN");  //RE: ZoneRuleException Unknown time zone
        print();
    }

    static void m2() {
        zoneId = ZoneId.of("US/Eastern");  //US/Eastern
        print();
    }

    static void m3() {
        zoneId = ZoneId.systemDefault();
        print();
    }


    static void m4() {
        Predicate<String> usa = s -> s.contains("US");
        Predicate<String> america = s -> s.contains("America");
        Predicate<String> predicate = usa.or(america);
        ZoneId.getAvailableZoneIds().stream().filter(predicate).sorted().forEach(System.out::println);
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
    }
}
