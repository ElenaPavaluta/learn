package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAPropertyFileResourceBundle.propertyFileFormat;

import java.util.Locale;
import java.util.ResourceBundle;

class Equal {

    static void read(Locale locale){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Equal", locale);
        System.out.println(resourceBundle.getString("prop_1"));
        System.out.println(resourceBundle.getString("prop_2"));
        System.out.println(resourceBundle.getString("prop_3"));
    }

    public static void main(String[] args) {
//        m();
        m2();
    }

    static void m2(){
        Locale en = Locale.US;
        Locale fr = Locale.FRANCE;

        read(en);
        read(fr);
    }

    private static void m() {
        Locale en = new Locale.Builder()
                .setLanguage("en")
                .setRegion("RO")
                .build();
        System.out.println(en);

        Locale fr = new Locale.Builder()
                .setRegion("ro")
                .setLanguage("FR")
                .build();
        System.out.println(fr);

        read(en);
        read(fr);
    }
}
