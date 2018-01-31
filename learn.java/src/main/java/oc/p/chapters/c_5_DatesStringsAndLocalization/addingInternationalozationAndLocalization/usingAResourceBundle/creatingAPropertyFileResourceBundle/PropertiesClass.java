package oc.p.chapters.c_5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAPropertyFileResourceBundle;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

class PropertiesClass {

    static Properties properties;
    static ResourceBundle resourceBundle;

    static{
        Locale.setDefault(Locale.FRANCE);
        resourceBundle = ResourceBundle.getBundle("Equal");

        properties = new Properties();
        resourceBundle.keySet().stream()
                .forEach(k->properties.put(k, resourceBundle.getString(k)));
    }


    static void m(){
        System.out.println(properties.get("prop_2"));

        System.out.println(properties.get("prop_2"));

        System.out.println(properties.getProperty("prop_4", "this is the default value in case prop_4 does not exits"));
    }



    public static void main(String[] args) {
       m();
    }

}
