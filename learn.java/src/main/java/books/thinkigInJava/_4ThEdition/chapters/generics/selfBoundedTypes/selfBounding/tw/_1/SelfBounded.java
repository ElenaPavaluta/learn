package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.selfBounding.tw._1;

/**
 * Self-bounding takes the extra step of forcing
 * the generic to be used as its own bound argument.
 */
class SelfBounded<T extends SelfBounded<T>> {
    private T element;
    SelfBounded<T> setT(T t){
        element = t;
        return this;
    }

    T get(){
        return element;
    }
}

