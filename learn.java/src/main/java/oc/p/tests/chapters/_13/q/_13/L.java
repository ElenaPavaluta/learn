package oc.p.tests.chapters._13.q._13;

import java.util.ArrayList;
import java.util.List;

class L {

    static void m(){
        List<String> list = new ArrayList<>();
        list.add("Monday");
//        list.add(String::new);  //compiler error
    }
}
