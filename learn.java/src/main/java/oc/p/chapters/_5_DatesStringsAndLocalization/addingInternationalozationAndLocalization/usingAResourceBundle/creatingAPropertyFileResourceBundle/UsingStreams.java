package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAPropertyFileResourceBundle;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

class UsingStreams {

    static Locale en = new Locale("en");
    static Locale fr = new Locale("fr", "FR");

    static void read(Locale locale){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Equal", locale);
        Set<String> keys = resourceBundle.keySet();
        System.out.println(keys);

        Map<String, String> map = keys.stream()
                .collect(Collectors.toMap(Function.identity(), resourceBundle::getString));
        map.forEach((k, v)-> System.out.println(k + "-> " + v));
    }

    public static void main(String[] args) {
//        read(en);
        read(fr);
    }
}
