package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingMethodReferences.types;

import java.util.function.Predicate;

class InstanceMethodOnAParticularInstance {

    static MR mr = new MR("mr");

    static void m(String s){
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return mr.instanceMethodOnAParticularInstance(s);
            }
        };
        predicate.test(s);

        predicate = st -> mr.instanceMethodOnAParticularInstance(st);
        predicate.test(s);

        predicate = mr::instanceMethodOnAParticularInstance;
        predicate.test(s);
    }
}
