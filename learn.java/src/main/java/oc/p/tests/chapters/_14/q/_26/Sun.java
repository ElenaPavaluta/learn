package oc.p.tests.chapters._14.q._26;

import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntToLongFunction;
import java.util.function.UnaryOperator;

class Sun {

//    static void dawn(UnaryOperator up){ }  //compiler error

//    static void dawn(DoubleUnaryOperator op){}

//    static void dawn(Function<String, String> op){}

    static void dawn(IntToLongFunction op){}

    public static void main(String[] args) {
        dawn(s->s+1);
    }
}
