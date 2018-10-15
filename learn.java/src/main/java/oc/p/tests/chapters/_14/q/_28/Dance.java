package oc.p.tests.chapters._14.q._28;

import java.util.function.BiFunction;
import java.util.function.DoubleUnaryOperator;

class Dance  {

    static Integer rest(BiFunction<Integer, Double, Integer> takeABreak){
        return takeABreak.apply(3, 10.2);
    }

    public static void main(String[] args) {
//        rest((int n, double e) -> (int)(n +e));
        rest((Integer n, Double e) -> (int)(n +e));
//        rest((s, w)->2*w);
        rest((s, e)->s.intValue() + e.intValue());
    }
}
