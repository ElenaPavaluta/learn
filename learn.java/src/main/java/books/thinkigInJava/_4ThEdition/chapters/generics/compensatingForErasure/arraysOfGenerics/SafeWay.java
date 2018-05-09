package books.thinkigInJava._4ThEdition.chapters.generics.compensatingForErasure.arraysOfGenerics;

/**
 * The safe way to return an array of generics - using reflection:
 * (T[])Array.newInstance(Class<T>, size);
 */
class SafeWay<T> {
    private T[] array;

    SafeWay(Class<T> type, int size) {
        array = (T[]) java.lang.reflect.Array.newInstance(type, size);
    }

    public static void main(String[] args) {
        SafeWay<Integer> swi = new SafeWay<>(Integer.class, 10);

        Integer[] ia = swi.rep();
        System.out.println("this is the safe way to retrieve an array of a generic type");
    }

    void put(int index, T item) {
        array[index] = item;
    }

    T get(int index) {
        return array[index];
    }

    T[] rep() {
        return array;
    }
}



