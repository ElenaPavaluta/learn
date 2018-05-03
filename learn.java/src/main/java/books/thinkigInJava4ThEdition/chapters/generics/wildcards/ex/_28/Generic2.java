package books.thinkigInJava4ThEdition.chapters.generics.wildcards.ex._28;

interface Generic2<T> {

    T m();

    class Impl<T> implements Generic2<T> {
        @Override
        public T m() {
            return null;
        }
    }
}
