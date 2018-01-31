package oc.p.chapters.c_5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.determiningWhichResourceBundleToUse;

import java.util.Locale;
import java.util.ResourceBundle;

class Run {

    private static final String BASE_NAME = "oc.print.chapters.c_5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.determiningWhichResourceBundleToUse.bundle.Res";

    static void print(String key, Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(BASE_NAME, locale);
        System.out.println(resourceBundle.getString(key));
    }

    static void p(Locale locale) {
        print("p", locale);
    }

    static void m() {
        Locale def = Locale.getDefault();

        Locale.setDefault(new Locale.Builder().setLanguage("ro").setRegion("ZB").build());
        System.out.println(Locale.getDefault());  //ro_ZB

        Locale.setDefault(def);
    }

    static void m2() {
        p(Locale.getDefault());  //res_fr_FR
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
