package oc.p.chapters._4_FunctionalProgramming.workingWithPrimitives.tw;

import java.util.function.*;
import java.util.stream.DoubleStream;

class DoublePrimitives {

    static Q q = new Q();

    static void m(DoubleFunction <Q> doubleFunction){
        doubleFunction.apply(2.2);
    }

    static void m(ToDoubleFunction<Q> toDoubleFunction){
        toDoubleFunction.applyAsDouble(q);
    }

    static void m(DoubleUnaryOperator doubleUnaryOperator){
        doubleUnaryOperator.applyAsDouble(2.2);
    }

    static void m(DoubleBinaryOperator dbo){
        dbo.applyAsDouble(1, 2);
    }

    static void m(DoubleConsumer dc){
        dc.accept(2.3);
    }

    static void m(DoubleSupplier  ds){
        ds.getAsDouble();
    }

    static void m(ObjDoubleConsumer<Q> odc){
        odc.accept(q, 2.3);
    }

    static void m(DoublePredicate dp){
        dp.test(2.3);
    }

    static void m(DoubleStream ds){
//        DoubleStream.range();
//        DoubleStream.rangeClosed();
    }

    static class Q {
    }
}
