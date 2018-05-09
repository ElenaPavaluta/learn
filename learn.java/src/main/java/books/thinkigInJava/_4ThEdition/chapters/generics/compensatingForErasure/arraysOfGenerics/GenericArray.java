package books.thinkigInJava._4ThEdition.chapters.generics.compensatingForErasure.arraysOfGenerics;

class GenericArray<T> {
    private T[] arr;

    @SuppressWarnings("uncheked")
    public GenericArray(int size) {
        this.arr = (T[])new Object[size];
    }

    void put(int index, T item){
        arr[index] = item;
    }

    T get(int idx){
        return arr[idx];
    }

    T[] rep(){
        return arr;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);

        gai.put(0, 0);
        System.out.println(gai.get(0));

        /**
         * ClassCastException
         *Due to erasure, the runtime type of arr is Object[]
         * - and only this can be
         *
         * So, although the compiler is happy the arr knows that it contains
         * Object type and when trying to convert to Integer it throws
         * a ClassCastException
         */
//        Integer[] ia = gai.rep();

        /**
         * This is ok, because the actual type contained inside arr is Object
         * - once again: due to type erasure
         */
        Object[] oa = gai.rep();

    }
}
