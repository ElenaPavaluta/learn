package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.argumentCovariance;

class CovariantReturnTypes {

    void test(DerivedOrdinaryGetter d){
        Derived d2 = d.get();
    }
}
