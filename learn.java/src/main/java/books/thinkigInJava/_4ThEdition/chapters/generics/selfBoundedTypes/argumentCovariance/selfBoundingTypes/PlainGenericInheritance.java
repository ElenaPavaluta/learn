package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.argumentCovariance.selfBoundingTypes;

class Base{

}

class Derived extends Base{}

class GenericSetter<T>{
    void set (T t){
        System.out.println("GenericSetter.set(Base)");
    }
}

class DerivedGS extends GenericSetter<Base>{

    //overloading, not overriding
    void set(Derived base) {
        System.out.println("DerivedGS.set(Derived)");
    }
}

class PlainGenericInheritance{
    public static void main(String[] args) {
        Base b = new Base();
        Derived d = new Derived();
        DerivedGS dgs = new DerivedGS();
        dgs.set(b);
        dgs.set(d);
    }
}

