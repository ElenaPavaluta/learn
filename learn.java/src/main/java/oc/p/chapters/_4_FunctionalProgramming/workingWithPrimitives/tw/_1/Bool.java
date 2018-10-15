package oc.p.chapters._4_FunctionalProgramming.workingWithPrimitives.tw._1;

import java.util.function.BooleanSupplier;

class Bool {

    static void m(BooleanSupplier bs){
        bs.getAsBoolean();
    }
}
