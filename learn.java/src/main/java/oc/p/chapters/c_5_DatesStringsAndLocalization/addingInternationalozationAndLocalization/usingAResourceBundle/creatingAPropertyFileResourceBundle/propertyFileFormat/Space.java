package oc.p.chapters.c_5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAPropertyFileResourceBundle.propertyFileFormat;

import java.util.Locale;
import java.util.ResourceBundle;

class Space {

    static void read(Locale locale){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Space", locale);
        System.out.println(resourceBundle.getString("prop_1"));
    }

    public static void main(String[] args) {
        Locale en = new Locale("en");
        System.out.println(en);

        Locale fr = new Locale("fr");
        System.out.println(fr);

        read(en);
        read(fr);
    }
}
