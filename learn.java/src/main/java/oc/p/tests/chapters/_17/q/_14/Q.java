package oc.p.tests.chapters._17.q._14;

import org.apache.derby.client.am.DateTime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Q {

    static void m(){
        LocalTime localTime = LocalTime.now();

        System.out.println(DateTimeFormatter.ofPattern("hh:mm").format(localTime));
        System.out.println(DateTimeFormatter.ofPattern("HH:mm").format(localTime));
    }

    public static void main(String[] args) {
        m();
    }
}
