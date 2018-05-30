package oc.p.chapters._6_ExceptionsAndAssertions.reviewingExceptions.exceptionsOnTheOcp.unchecked.java.util;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.stream.Collectors;

class MissingResourceException {

    static void m(String resource){
        ResourceBundle rb = ResourceBundle.getBundle(resource);
        Map<String, String> map = rb.keySet().stream()
                .collect(Collectors.toMap(Function.identity(), rb::getString));
        map.forEach((k, v)->System.out.println(k + " : " + v));
    }


    public static void main(String[] args) {
//        m("Equal");
        m("bla"); //java.util.MissingResourceException
    }
}
