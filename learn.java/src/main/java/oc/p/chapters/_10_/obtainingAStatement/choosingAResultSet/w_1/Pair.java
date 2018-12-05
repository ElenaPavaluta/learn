package oc.p.chapters._10_.obtainingAStatement.choosingAResultSet.w_1;

class Pair<T> {

    private T i;
    private T j;

    Pair(final T i, final T j) {
        this.i = i;
        this.j = j;
    }

    T getI() {
        return i;
    }

    T getJ() {
        return j;
    }

    @Override
    public String toString() {
        return i + " " + j;
    }
}
