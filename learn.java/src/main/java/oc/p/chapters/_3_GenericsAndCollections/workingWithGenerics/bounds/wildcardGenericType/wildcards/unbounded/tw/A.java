package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.bounds.wildcardGenericType.wildcards.unbounded.tw;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class A {

    List lo;
    List<?> lu;

    {
        lo = new ArrayList();
        lo.add("a");
        lo.add(LocalDate.now());
        lo.add(new RuntimeException[]{new IllegalArgumentException(), new ClassCastException()});
    }

    {
        lu = new ArrayList<>();  //immutable for the adding operation
//        lu.add("a");  compilerError
//        lu.add(new Object());  //compiler error

        lu = new ArrayList<LocalDate>();
//        lu.add(LocalDate.now());  //compiler error
        lu = lo;
        System.out.println(lu.get(0).toString());
    }


    static void po(List lst) {
        lst.forEach(System.out::println);
    }

    static void pu(List<?> lst) {
        lst.forEach(System.out::println);
    }

    public static void main(String[] args) {
        new A();
    }

}
