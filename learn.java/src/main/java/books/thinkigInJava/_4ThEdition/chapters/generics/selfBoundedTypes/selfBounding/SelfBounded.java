package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.selfBounding;

class SelfBounded<T extends SelfBounded<T>> {
    T element;

    SelfBounded<T> set(T t){
        element = t;
        return  this;
    }

    T get(){
        return element;
    }
}
