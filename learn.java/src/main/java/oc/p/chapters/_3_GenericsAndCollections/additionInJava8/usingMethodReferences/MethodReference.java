package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingMethodReferences;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Static methods
 *
 * Instance methods on a particular instance
 *
 * Instance methods on an instance to be determined at runtime
 *
 * Constructors
 */
class MethodReference {

    static void staticMethod(List<Integer> lst) {
        //anonymous inner class
        Consumer<List<Integer>> consumer = new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) {
                Collections.sort(integers);
            }
        };

        //lambda
        consumer = l -> Collections.sort(l);

        //static method reference
        consumer = Collections::sort;

        consumer.accept(lst);
        System.out.println(lst);
    }

    static void instanceMehodOnAParticularInstance(String st) {
        String base = "base";
        Predicate<String> predicate = s -> base.startsWith(s);
        predicate = base::startsWith;
        System.out.println(predicate.test(st));
    }

    static void instanceMethodOnAnInstanceToBeDeterminedAtRuntime(String t) {
        Predicate<String> predicate = s -> s.isEmpty();
        predicate = String::isEmpty;

        System.out.println(predicate.test(t));
    }

    static void contructor() {
        Supplier<MethodReference> supplier = () -> new MethodReference();

        supplier = MethodReference::new;
    }
}
