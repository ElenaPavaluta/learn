package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.compute.tw._1;

import utils.print.Print;
import java.util.Map;
import java.util.TreeMap;

class CIP {

    static Map<Integer, String> map = new TreeMap<>();
    static {
        map.putIfAbsent(2, "2");
        map.putIfAbsent(1, "1");
        Print.print(map);
    }

    public static void main(String[] args) {

    }
}
