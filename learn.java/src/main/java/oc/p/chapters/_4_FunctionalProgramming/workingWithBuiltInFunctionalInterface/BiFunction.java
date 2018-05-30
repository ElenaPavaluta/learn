package oc.p.chapters._4_FunctionalProgramming.workingWithBuiltInFunctionalInterface;

interface BiFunction<T, U, R> {
    R apply(T t, U u);
}

interface ThreeInParams<T, U, V, R> {

    R apply(T t, U u, V v);
}

class Bf {
    static void m() {
        BiFunction<String, String, String> biFunction = (s, s2) -> s.concat(s2);
        biFunction = String::concat;

        BiFunction<String, String, String[]> function = (s, s2) -> s.split(s2);
        function = String::split;
    }

    static void m2(){
        ThreeInParams<String, String, String, String> f = (source, old, n)->source.replace(old, n);
        f = String::replace;
    }

}
