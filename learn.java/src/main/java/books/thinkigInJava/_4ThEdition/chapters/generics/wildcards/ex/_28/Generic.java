package books.thinkigInJava._4ThEdition.chapters.generics.wildcards.ex._28;

interface Generic<T> {

    void m(T t);


    class Impl<T> implements Generic<T>{
        @Override
        public void m(T t) {
            System.out.println(t.getClass().getSimpleName());
        }
    }
}


