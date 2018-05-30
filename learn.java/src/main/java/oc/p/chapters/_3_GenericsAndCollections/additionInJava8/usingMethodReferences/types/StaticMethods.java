package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingMethodReferences.types;

import java.util.function.Consumer;

class StaticMethods {

   static A a = new A();

    static void m(){
        Consumer<A> consumer = new Consumer<A>() {
            @Override
            public void accept(A a) {
                MR.sm(a);
            }
        };
        consumer.accept(a);

        consumer = a -> MR.sm(a);
        consumer.accept(a);

        consumer = MR::sm;
        consumer.accept(a);
     }



    static class A {
    }
}
