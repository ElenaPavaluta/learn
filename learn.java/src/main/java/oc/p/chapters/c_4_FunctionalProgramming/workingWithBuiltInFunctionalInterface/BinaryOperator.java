package oc.p.chapters.c_4_FunctionalProgramming.workingWithBuiltInFunctionalInterface;

interface BiFunc<T, U, R> {
    R apply(T t, U u);
}

interface BinaryOperator<U> extends BiFunction<U, U, U> {

}

class BO {
    void m() {
        BinaryOperator<String> operator = (s, s2) -> s.concat(s2);
        operator = String::concat;
    }
}
