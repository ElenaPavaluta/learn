package oc.p.chapters.c_4.workingWithPrimitives.learningTheFunctionalInterfacesForPrimitives;

import java.util.function.BooleanSupplier;

/**
 * @FunctionalInterface
 * public interface BooleanSupplier {
 *
 * boolean getAsBoolean();
 *
 * }
 */
class FunctionalInterfacesForBoolean {

    static void m() {
        BooleanSupplier booleanSupplier= ()->true;
    }
}

