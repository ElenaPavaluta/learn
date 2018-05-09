package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.selfBounding;

class C extends SelfBounded<C> {
    C setAntGet(C c){
        set(c);
        return  get();
    }
}
