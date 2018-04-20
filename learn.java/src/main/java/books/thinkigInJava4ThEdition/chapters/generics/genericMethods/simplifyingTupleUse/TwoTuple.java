package books.thinkigInJava4ThEdition.chapters.generics.genericMethods.simplifyingTupleUse;

class TwoTuple<A, B> {

    final  A first;
    final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second +")";
    }
}
