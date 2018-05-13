package books.thinkigInJava._4ThEdition.chapters.generics.genericMethods.simplifyingTupleUse;

public class TwoTuple<A, B> {

    final  A first;
    final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second +")";
    }
}
