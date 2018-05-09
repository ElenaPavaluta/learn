package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.argumentCovariance;

/**
 * In non-generic code, however, the argument types cannot be made
 * to vary with the subtypes
 */
class OrdinarySetter {

    void set(Base base) {
        System.out.println("OrdinarySetter.set(Base)");
    }
}

class DerivedSetter extends OrdinarySetter {

    /**
     * Compiler error:
     * The type of the argument can't differ from the one in the base class
     * when a method is overridden
     */
    //    @Override
//    void set(Derived base) {
//        super.set(base);
//    }


    //overloading
    void set(Derived derived){
        System.out.println("DerivedSetter.set(Derived)");
    }
}

class OrdinaryArguments{
    public static void main(String[] args) {
        Base b = new Base();
        Derived d = new Derived();
        DerivedSetter ds = new DerivedSetter();
        ds.set(b);
        ds.set(d);
    }
}
