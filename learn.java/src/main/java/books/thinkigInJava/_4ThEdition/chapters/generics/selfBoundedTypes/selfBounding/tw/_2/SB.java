package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.selfBounding.tw._2;

class SB<T extends SB<T>> {

    private T elem;

//    public SB(T elem) {
//        this.elem = elem;
//    }

    void set(T t){
        this.elem = t;
    }

    T get(){
        return elem;
    }

    void m(){
        System.out.println(elem instanceof SB);
//        System.out.println(elem instanceof T);  //compiler error
    }

    public static void main(String[] args) {
//        A a = new A(new B());  //it's a mirror looking in a mirror

        A a = new A();
        a.set(new A());
        a.m();
        System.out.println(a == a.get());  //false

        B b = new B();
        b.set(b);
        b.m();
        System.out.println(b ==b.get());  //true

        C c = new C();
        c.set(b);
//        c.set(c);  //compiler error
    }

}

class A  extends SB<A>{

}

class B extends SB<B>{
}

class C extends SB<B>{

}
