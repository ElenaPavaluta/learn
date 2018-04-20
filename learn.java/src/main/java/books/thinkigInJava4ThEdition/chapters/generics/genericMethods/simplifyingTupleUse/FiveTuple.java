package books.thinkigInJava4ThEdition.chapters.generics.genericMethods.simplifyingTupleUse;

class FiveTuple<A, B, C, D, E> extends FourTuple {

    final E fifth;

    public FiveTuple(Object first, Object second, Object third, Object fourth, E fifth) {
        super(first, second, third, fourth);
        this.fifth = fifth;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + "," + fourth + ", " + fifth + ")";
    }
}
