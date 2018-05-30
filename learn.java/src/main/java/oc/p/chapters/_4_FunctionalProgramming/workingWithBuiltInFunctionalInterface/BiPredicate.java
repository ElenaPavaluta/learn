package oc.p.chapters._4_FunctionalProgramming.workingWithBuiltInFunctionalInterface;

interface BiPredicate<T, U> {

    boolean test(T t, U u);
}

class BP{
    static void m(){
        BiPredicate<String, String> biPredicate = (s, prefix) -> s.startsWith(prefix);
        biPredicate.test("base", "b");

        biPredicate = String::startsWith;  //reference method on instance to be determined at runtime
    }
}
