package oc.p.chapters._4_FunctionalProgramming.workingWithBuiltInFunctionalInterface;

interface Func<T, R>{
    R apply(T t);
}

interface UnaryOperator<U> extends Func<U, U> {
}

class UO {

    void m(){
        UnaryOperator<String> unaryOperator = s->s.toUpperCase();

        unaryOperator = String::toUpperCase;
    }
}
