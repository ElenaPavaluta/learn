package oc.p.chapters.c_4_FunctionalProgramming.workingWithBuiltInFunctionalInterface;

interface Function<T, R> {

    R apply(T t);
}

class F2{
    static void m(){
        Function<Integer, String> function = (i) ->F.m(i);
        function = F::m;  //static method reference

        F f = new F();
        function = i->f.m2(i);

        function= f::m2;  //instance method reference on particular instance
        function.apply(2);
    }
}

class F{

    static String m(Integer i){
        return i.toString();
    }

    String m2(Integer i){
        return i.toString();
    }
}

