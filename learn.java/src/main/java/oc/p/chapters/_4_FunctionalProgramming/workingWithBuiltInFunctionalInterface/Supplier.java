package oc.p.chapters._4_FunctionalProgramming.workingWithBuiltInFunctionalInterface;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Supplier<T> {

    T get();
}

class A{
    void m(){
        Supplier<LocalDateTime> supplier = () ->LocalDateTime.now();
        supplier.get();

        supplier = LocalDateTime::now;
        supplier.get();
    }

    void m2(){
        Supplier<StringBuilder> supplier = () -> new StringBuilder();
        supplier = StringBuilder::new;
    }

    <T> void m3(){
        Supplier<List<T>> supplier = () -> new ArrayList<T>();
        supplier = ArrayList::new;
    }
}
