package oc.p.chapters._4_FunctionalProgramming.workingWithPrimitives.tw;

import java.util.function.BooleanSupplier;

class Bool {

    static void m(BooleanSupplier bs){
        bs.getAsBoolean();
    }
}
