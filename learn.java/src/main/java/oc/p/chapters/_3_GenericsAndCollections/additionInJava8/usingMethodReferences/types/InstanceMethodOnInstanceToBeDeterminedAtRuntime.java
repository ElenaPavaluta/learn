package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingMethodReferences.types;

import java.util.function.Predicate;

class InstanceMethodOnInstanceToBeDeterminedAtRuntime {

    static MR mr = new MR("mr");

    static void m(){
        Predicate<MR> predicate = new Predicate<MR>() {
            @Override
            public boolean test(MR mr) {
                return mr.instanceMethodOnInstanceToBeDeterminedAtRuntime();
            }
        };
        predicate.test(mr);


        predicate = mr1 -> mr1.instanceMethodOnInstanceToBeDeterminedAtRuntime();
        predicate.test(mr);

        predicate = MR::instanceMethodOnInstanceToBeDeterminedAtRuntime;
        predicate.test(mr);
    }
}
