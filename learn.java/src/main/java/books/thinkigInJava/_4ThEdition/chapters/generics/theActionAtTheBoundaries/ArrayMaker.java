package books.thinkigInJava._4ThEdition.chapters.generics.theActionAtTheBoundaries;

import java.lang.reflect.Array;
import java.time.ZonedDateTime;
import java.util.Arrays;

/**
 * Note that using Array.newInstance()
 * is the recommended approach
 * for creating arrays in generics.
 */
class ArrayMaker<T> {

    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    void m(){
        Class c;
        c = Object.class;
        c =  String.class;
        c = ZonedDateTime.class;
        c = RuntimeException.class;

        Class<Object> co;
        co = Object.class;

//        co = String.class;  //compiler error
    }


    void m2(){
        Class<T> ct;

//        ct = Object.class;  //compiler error
    }

    /**
     * Even though kind is stored as Class<T>,
     * erasure means that it is actually just being stored as a Class,
     * with no parameter. So, when you do something with it,
     * as in creating an array, Array.newInstance( ) doesn’t actually
     * have the dbType information that’s implied in kind;
     */
    T[] create(int size){
        return (T[])Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> arrayMaker = new ArrayMaker<>(String.class);

        String[] strings = arrayMaker.create(10);
        System.out.println(Arrays.toString(strings));
    }
}
