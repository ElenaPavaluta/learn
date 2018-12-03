package oc.p.tests.chapters._20.q._26;

import java.util.Arrays;
import java.util.List;

class Concat {

    String concat(List<String> values){
        return values.parallelStream()
                .reduce("a", (x, y)->x+y, String::concat);
    }

    String concat2(List<String> values){
        return values.parallelStream()
                .reduce((w,z)->z+w).get();
    }

    static void m(){
        Concat c =  new Concat();
        List<String> list = Arrays.asList("Cat","Hat");

        String x = c.concat(list);
        String y = c.concat2(list);

        System.out.println(x + " " + y);
    }

    public static void main(String[] args) {
        m();
    }
}
