package books.thinkigInJava4ThEdition.chapters.generics.genericMethods.simplifyingTupleUse;

class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    final D fourth;

    public FourTuple(A first, B second, C third, D fourth) {
        super(first, second, third);
        this.fourth = fourth;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + "," + fourth + ")";
    }
}
