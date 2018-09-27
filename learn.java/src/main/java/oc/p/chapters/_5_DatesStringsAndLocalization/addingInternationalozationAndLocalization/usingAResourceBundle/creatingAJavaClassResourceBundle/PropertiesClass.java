package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAJavaClassResourceBundle;

import java.util.Properties;
import java.util.ResourceBundle;

class PropertiesClass {
    private static final String BASE_NAME = "oc.test.chapters.c_5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAJavaClassResourceBundle.Tax";
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(BASE_NAME);

    static void m(){
        TaxCode taxCode = (TaxCode) resourceBundle.getObject("tax");
        taxCode.m();;
    }

    static void m2(){
       resourceBundle.keySet().stream()
               .map(resourceBundle::getObject)
               .map(o->(TaxCode)o)
               .forEach(TaxCode::m);
    }

    static void m3(){
        resourceBundle.keySet().stream()
                .map(k->(TaxCode)resourceBundle.getObject(k))
                .forEach(TaxCode::m);
    }

    static void m4(){
        Properties props = new Properties();
        resourceBundle.keySet().stream()
                .forEach(k->props.put(k, (TaxCode)resourceBundle.getObject(k)));

        //        String s = (String) props.get("tax");  //RE: ClassCastException

        TaxCode tc = (TaxCode)props.get("tax");
        tc.m();

        String s = props.getProperty("tax");  //returns null, since the value object isn't instance of String
        System.out.println(s);
    }

    public static void main(String[] args) {
//        createAndPopulate();
//        m2();
//        m3();
        m4();
    }

}
