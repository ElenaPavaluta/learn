package books.thinkigInJava4ThEdition.chapters.generics.selfBoundedTypes.curioslyRecurringGenerics;

class RunBasicHolder {

    public static void main(String[] args) {
        Subtype st = new Subtype();
        Subtype st2 = new Subtype();

        st.set(st2);
        Subtype st3 = st.get();

        st3.print();
    }
}
