package oc.p.tests.chapters._11.q._26.tw;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Q {

    static List raw;
    static List<?> wildcard;
    static List<Object> objs;
    static List<A> lst;
    static List<? extends A> upperBound;
    static List<? super A> lowerBound;

    static void m12() {
        lowerBound = new ArrayList<>();
        lowerBound.add(new A());
        lowerBound.add(new B());
//        lowerBound.add(new S());
    }

    static void m11() {
        upperBound = new ArrayList<>();
//        upperBound.add(new A());
//        upperBound.add(new B());
    }

    static void m10() {
        lst = new ArrayList<>();
        lst.add(new A());
        lst.add(new B());
//        lst.add(new S());
    }

    static void m9() {
        objs = new ArrayList<>();
        objs.add(new A());
        objs.add(LocalDateTime.now());
    }

    static void m8() {
        wildcard = new ArrayList<>();
//        wildcard.add(new A());
//        wildcard.add(new Object())
    }

    static void m7() {
        raw = new ArrayList();
        raw.add(new A());
        raw.add(LocalDateTime.now());
    }

    static void m6() {
        lowerBound = raw;
//        lowerBound = wildcard;
        lowerBound = objs;
        lowerBound = lst;
//        lowerBound = upperBound;
    }

    static void m5() {
        upperBound = raw;
//        upperBound = wildcard;
//        upperBound = objs;
        upperBound = lst;
//        upperBound = lowerBound;
    }

    static void m4() {
        lst = raw;
//        lst = wildcard;
//        lst = objs;
//        lst = upperBound;
//        lst = lowerBound;
    }

    static void m3() {
        objs = raw;
//        objs = wildcard;
//        objs = lst;
//        objs = upperBound;
//        objs = lowerBound
    }

    static void m2() {
        wildcard = raw;
        wildcard = objs;
        wildcard = lst;
        wildcard = upperBound;
        wildcard = lowerBound;
    }

    static void m() {
        raw = objs;
        raw = wildcard;
        raw = objs;
        raw = lst;
        raw = upperBound;
        raw = lowerBound;
    }

    static interface I {
    }

    static class A implements I {
    }

    static class S implements I {
    }

    static class B extends A {
    }
}
