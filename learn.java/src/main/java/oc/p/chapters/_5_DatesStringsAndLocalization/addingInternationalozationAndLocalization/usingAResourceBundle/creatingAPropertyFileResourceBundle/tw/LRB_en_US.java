package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAPropertyFileResourceBundle.tw;

import utils.resources.files.Resources;

import java.util.*;
import java.util.function.Supplier;

public class LRB_en_US extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        Object[][] arr = new Object[3][];
        arr[0] = new Object[]{"1", new Value(), new Value()};
        arr[1] = new Object[]{"2", new Value(), new Value()};
        arr[2] = new Object[]{"3", new Value(), new Value()};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        return arr;
    }
}

class Value implements Supplier <Integer> {
    static int i;
    private int nb;

    Value() {
        nb = ++i;
    }

    @Override
    public Integer get() {
        return nb;
    }

    @Override
    public String toString() {
        return "Value{" +
                "nb=" + nb +
                '}';
    }
}

class Run {
    static void m() {
        final String baseName = Resources.pathToListResourceBundle(new LRB_en_US().getClass().getPackage(),  "LRB");
        System.out.println(baseName);
        ResourceBundle rb = ResourceBundle.getBundle(baseName, Locale.US);
        ListResourceBundle lrb;
        if (rb instanceof ListResourceBundle) {
            lrb = (ListResourceBundle) rb;

            final Properties properties = lrb.keySet().stream()
                    .collect(Properties::new,
                            (p, k) -> p.putIfAbsent(k, lrb.getObject(k)),
                            (p, p2) -> p2.forEach(p::putIfAbsent));

            properties.forEach((k, v) -> System.out.println(k + " " + v));
            System.out.println(properties.get("a"));
        }
    }

    public static void main(String[] args) {
        m();
    }
}
