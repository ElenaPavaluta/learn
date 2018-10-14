package oc.p.tests.chapters._13.q._20.tw;

import java.util.*;

/**
 * Static methods cannot be chained
 */
class O {
    int i;
    double d;
    long l;


    O(int i, double d, long l) {
        this.i = i;
        this.d = d;
        this.l = l;
    }

    @Override
    public String toString() {
        return "O{" +
                "i=" + i +
                ", d=" + d +
                ", l=" + l +
                '}';
    }
}

class O2 implements Comparable <O2> {
    int i;
    double d;
    long l;

    O2(int i, double d, long l) {
        this.i = i;
        this.d = d;
        this.l = l;
    }

    @Override
    public int compareTo(O2 o) {
        return Integer.compare(i, o.i);
    }
}

class O3 {
    Integer val;

    O3(Integer val) {
        this.val = val;
    }
}

class C {

    static List <O> os = Arrays.asList(new O(3, 3, 3), new O(1, 1, 1), new O(5, 5, 5));

    static void m() {
        Comparator <O> c = Comparator.comparingInt(o -> o.i);
        Collections.sort(os, c);
        System.out.println(os);

        Comparator <O> reversed = c.reversed();
        Collections.sort(os, reversed);
        System.out.println(os);
    }

    static void m2() {
        Comparator <O2> c = Comparator.comparingInt(o -> o.i);
        c = c.thenComparingDouble(o -> o.d);
        c = c.thenComparingLong(o -> o.l);

//        Comparator<O2> cc = Comparator.comparingInt(o->o.i).thenComparingDouble(o->o.d).thenComparingLong(o->o.l);

        Comparator <O2> rv = c.reversed();

        Collections.sort(new ArrayList <O2>(), c);

        System.out.println(c);

        Comparator <O2> rorder = Comparator.reverseOrder();
    }


    static void m3() {
        Comparator <O3> c = Comparator.comparing(o -> o.val);  //val of type o needs to be comparable

        Comparator <O3> c2 = Comparator.comparing(o -> o.val, Comparator.comparingInt(Integer::intValue));

        Comparator <O3> c3 = Comparator.comparing(o -> o.val, (x, y) -> x.intValue() - y.intValue());
    }
    public static void main(String[] args) {
//        m();
        m2();
    }
}
