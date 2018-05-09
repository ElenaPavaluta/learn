package books.thinkigInJava._4ThEdition.chapters.generics.theActionAtTheBoundaries;

/**
 * Since get( ) and set( ) produce the same bytecodes,
 * all the action in generics happens at the boundaries
 * —the extra compile-time check for incoming values,
 * and the inserted cast for outgoing values.
 * It helps to counter the confusion of erasure to remember that
 * "the boundaries are where the action takes place."
 */
class GenericHolder<T> {

    private T obj;

    T getObj() {
        return obj;
    }

    void setObj(T obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        GenericHolder<String> gh = new GenericHolder<>();
        gh.setObj("Item");
        String s = gh.getObj();
    }
}
