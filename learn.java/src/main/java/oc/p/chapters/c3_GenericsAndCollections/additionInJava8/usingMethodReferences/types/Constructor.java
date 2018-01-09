package oc.p.chapters.c3_GenericsAndCollections.additionInJava8.usingMethodReferences.types;

import java.util.function.Supplier;

class Constructor {

    static void m(){
        Supplier<MR> supplier = new Supplier<MR>() {
            @Override
            public MR get() {
                return new MR();
            }
        };
        supplier.get();

        supplier = () -> new MR();
        supplier.get();

        supplier = MR::new;
        supplier.get();
    }
}
