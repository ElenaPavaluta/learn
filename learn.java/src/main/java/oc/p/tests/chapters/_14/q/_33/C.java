package oc.p.tests.chapters._14.q._33;

import java.util.function.DoubleToLongFunction;

class C {

    static void m() {
        DoubleToLongFunction f;

        f = a -> null == null ? 1 : 2L;
        f = e -> (int) (10 * e);
        f = (double m)->{
            long p = (long)m;
            return p;
        };

//        f = (Double s)-> s.longValue();
    }
}
