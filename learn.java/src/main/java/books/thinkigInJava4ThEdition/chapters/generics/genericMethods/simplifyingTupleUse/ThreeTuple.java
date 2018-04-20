package books.thinkigInJava4ThEdition.chapters.generics.genericMethods.simplifyingTupleUse;

class ThreeTuple<A, B, C> extends TwoTuple<A, B>{
    final C third;

    public ThreeTuple(A first, B second, C third) {
        super(first, second);
        this.third = third;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third +")";
    }
}
