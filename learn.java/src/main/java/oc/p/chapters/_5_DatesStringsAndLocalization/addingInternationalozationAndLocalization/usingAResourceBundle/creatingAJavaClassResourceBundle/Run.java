package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAJavaClassResourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

class Run {

    private static final String BASE_NAME = "oc.p.chapters.c_5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAJavaClassResourceBundle.Tax";

    static void m(Locale locale){
        ResourceBundle rb = ResourceBundle.getBundle(BASE_NAME, locale);
        TaxCode tc = (TaxCode) rb.getObject("tax");
        tc.m();
    }

    public static void main(String[] args) {
        m(Locale.US);  //en_US

        m(Locale.FRANCE);  //en_US  due to the fact that the Tax_fr_FR is not public

        m(Locale.GERMANY);  //en_US

        Locale.setDefault(Locale.GERMANY);
        m(Locale.GERMANY);  //RE can't find the resource bundle for the default
    }
}
