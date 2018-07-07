package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAPropertyFileResourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

class ReadProps {

    static void readProps(Locale locale){
        ResourceBundle rb = ResourceBundle.getBundle("ZOO", locale);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));
    }

    public static void main(String[] args) {
        Locale us = new Locale("en", "US");
//        Locale fr = Locale.FRANCE;
        Locale fr = new Locale("fr", "FR");
        readProps(us);
        readProps(fr);
    }
}
