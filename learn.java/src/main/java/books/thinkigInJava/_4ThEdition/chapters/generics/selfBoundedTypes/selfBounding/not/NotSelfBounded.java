package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.selfBounding.not;

class NotSelfBounded<T> {

    T element;

    NotSelfBounded<T> set(T t){
        this.element = t;
        return this;
    }

    T get(){
        return element;
    }
}

class A2 extends NotSelfBounded<A2>{}

class B2 extends NotSelfBounded<A2>{}

class C2 extends NotSelfBounded<C2>{
    C2 setAndGet(C2 elem){
        super.set(elem);
        return get();
    }
}

class D2{}

/**
 * This is ok now, due to the fact that there's
 * no other condition for the contained element
 */
class E2 extends NotSelfBounded<D2>{}

