package oc.p.chapters._4_FunctionalProgramming.workingWithBuiltInFunctionalInterface;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

@FunctionalInterface
interface BiConsumer<T, U> {

    void accept(T t, U u);
}

class A3 {

    static Map<String, LocalDate> map = new TreeMap<>();

    static void m() {
        BiConsumer<String, LocalDate> consumer = new BiConsumer<String, LocalDate>() {
            @Override
            public void accept(String s, LocalDate localDate) {
                map.put(s, localDate);
            }
        };
        consumer.accept("today", LocalDate.now());

        consumer = (s, d) -> map.put(s, d);
        consumer.accept("tomorrow", LocalDate.now().plusDays(1));

        consumer = map::put;  //dbInstance method reference on a particular dbInstance

    }

    static void m2() {
        A32<String, Integer> a4 = new A32<>();
        BiConsumer<String, Integer> consumer = new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                a4.m(s, integer);
            }
        };
        consumer.accept("", 1);

        consumer = (s, i) -> a4.m(s, i);

        consumer = a4::m;  //method reference on particular dbInstance
        consumer.accept("", 1);
    }

    static void m3(){
        BiConsumer<Long, Double> consumer = new BiConsumer<Long, Double>() {
            @Override
            public void accept(Long aLong, Double aDouble) {
                A32.<Long, Double>sm(aLong, aDouble);
            }
        };
        consumer.accept(1l, 1d);

        consumer = (l, d) -> A32.<Long,Double>sm(l, d);

        consumer = A32::sm;  //static method reference
        consumer.accept(Long.valueOf(1l), Double.valueOf(1d));
    }

    static void m4(){
        BiConsumer<A33, A33> biConsumer = new BiConsumer<A33, A33>() {
            @Override
            public void accept(A33 a33, A33 a332) {
                a33.m();;
            }
        };
        biConsumer.accept(new A33(), new A33());

        biConsumer = (a, a2) -> a.m();
        biConsumer.accept(new A33(), null);

//        biConsumer = A33::createAndPopulate;  //compiler error
    }
}

class A32<T, U> {
    static <T, U> void sm(T t, U u) {
    }

    void m(T t, U u) {
    }
}

class A33{
    void m(){}
}
