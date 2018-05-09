package books.thinkigInJava._4ThEdition.chapters.generics.compensatingForErasure.arraysOfGenerics;

class GenericArray2<T> {
    private Object[] array;

    public GenericArray2(int size) {
        this.array = new Object[size];
    }

    void put(int pos, T item){
        array[pos] = item;
    }

    T get(int index) {
        return (T)array[index];
    }

    T[] rep(){
        return (T[])array;
    }

    public static void main(String[] args) {
        GenericArray2<Integer> gai = new GenericArray2<>(10);

        gai.put(0, 0);
        System.out.println(gai.get(0));

//        Integer[] ia = gai.rep();  //ClassCastException
    }

}
