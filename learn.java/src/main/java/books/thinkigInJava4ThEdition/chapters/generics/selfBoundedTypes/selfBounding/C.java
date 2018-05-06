package books.thinkigInJava4ThEdition.chapters.generics.selfBoundedTypes.selfBounding;

class C extends SelfBounded<C> {
    C setAntGet(C c){
        set(c);
        return  get();
    }
}
