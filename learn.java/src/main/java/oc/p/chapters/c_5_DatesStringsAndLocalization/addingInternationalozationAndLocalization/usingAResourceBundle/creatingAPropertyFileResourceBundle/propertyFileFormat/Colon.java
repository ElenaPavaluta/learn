package oc.p.chapters.c_5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAPropertyFileResourceBundle.propertyFileFormat;

import java.util.Locale;
import java.util.ResourceBundle;

class Colon {

    static void read(Locale locale){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Colon", locale);
        System.out.println(resourceBundle.getString("prop_1"));
    }


    public static void main(String[] args) {
        Locale us = Locale.US;
        Locale fr = Locale.FRANCE;

        read(us);
        read(fr);
    }

}
