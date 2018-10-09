package oc.p.tests.chapters._12.q._16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface I {
    static void m() {
    }
}

/**
 * Inner classes cannot have static declarations
 * Nested classes can
 */
abstract class Q {
    static void m() {
    }

    void m2() {
        class E {
            /*static*/ void m() {
            }

            /*static*/ class K {
            }
        }
    }

    void m3() {
        List<Integer> l = new ArrayList<>();
        Collections.sort(l, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }

            /*static*/ void m() {
            }
        });
    }

    static class W {
        static void m() {
        }
    }

    abstract class A {
        abstract class B {
            abstract class C {

            }
        }
    }

    class M {
        /*static*/ void m() {
        }

        class N {
        }
    }
}


