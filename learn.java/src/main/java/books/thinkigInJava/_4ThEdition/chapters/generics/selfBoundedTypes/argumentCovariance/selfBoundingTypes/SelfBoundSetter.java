package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.argumentCovariance.selfBoundingTypes;

interface SelfBoundSetter<T extends SelfBoundSetter<T>> {

    void set(T arg);

    /**
     * Compiler error
     *
     * overloading error
     *
     * Both methods have the same erasure
     */
//    void set(SelfBoundSetter<T> arg);
}

interface Setter extends SelfBoundSetter<Setter>{

}

class SelfBoundingAndCovariantArguments{
    void testA(Setter s1, Setter s2, SelfBoundSetter<Setter> sbs, SelfBoundSetter sbs2){
        s1.set(s2);
        s2.set(s1);

//        s1.set(sbs);  //compiler error
//        s1.set(sbs2);  //compiler error
    }
}



