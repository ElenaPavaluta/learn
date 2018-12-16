package oc.p.tests.chapters._22.q._20;

import oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.tw.orderOrResourceBundleUse.Prop;

import java.util.*;

class Q {

    static void m(){
        Map<Object, Object> map = new TreeMap<>();
        map.put("tool", "hammer");
        map.put("problem", "nail");

        Properties p = new Properties();
        map.forEach((k, v)->p.put(k, v));

        String t = p.getProperty("tool");
        String n = p.getProperty("problem");

        System.out.println(t);
        System.out.println(n);

        Object o = p.get("tool");
        Object o2 = p.get("problem");

        System.out.println(o);
        System.out.println(o2);
    }

    static void m2(){
        Map<Locale, Locale> map = new HashMap <>();
        map.put(Locale.US, Locale.US);

        Properties properties = new Properties();
        map.forEach((k, v)->properties.put(k, v));

        Object o = properties.get(Locale.US);
        System.out.println(o);

        String s = properties.getProperty(Locale.US.toString());
        System.out.println(s);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
