package oc.p.chapters.c_4_FunctionalProgramming.workingWithBuiltInFunctionalInterface;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Consumer<T> {

    void accept(T t);
}
class A2{
    static void m(){
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        consumer = c -> {
            System.out.println(c);
        };

        consumer = System.out::println;  //method reference on instance to be determined at runtime
    }

    static void m2(){
        List<A22> list = Arrays.asList(new A22(), new A22());
        list.forEach(new java.util.function.Consumer<A22>() {
            @Override
            public void accept(A22 a22) {
                a22.m();
            }
        });

        list.forEach(a22 -> m());

        list.forEach(A22::m);  //method reference on instance to be determined at runtime
    }

    static void m3(){
        Consumer<A23> consumer = new Consumer<A23>() {
            @Override
            public void accept(A23 a23) {
                a23.m();
            }
        };
        consumer.accept(new A23());

        consumer = a -> a.m();

        consumer = A23::m;  //method reference on an instance to be determined at runtime
        consumer.accept(new A23());
    }
}

class A22<T>{
    void m(){

    }
}

class A23{
    void m(){}
}

