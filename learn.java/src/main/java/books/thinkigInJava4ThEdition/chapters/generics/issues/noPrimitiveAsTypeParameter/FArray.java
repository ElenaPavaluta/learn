package books.thinkigInJava4ThEdition.chapters.generics.issues.noPrimitiveAsTypeParameter;

import com.sun.javafx.geom.transform.GeneralTransform3D;
import java.util.function.Supplier;
import java.util.stream.Stream;

class FArray {

    static <T> T[] fill(T[] ta, Supplier<T> supplier){
        for(int i = 0; i<ta.length; i++){
            ta[i] = supplier.get();
        }
        return ta;
    }

    static void m(){
        String[] strings = fill(new String[7], ()->"a");
        Stream.of(strings).forEach(System.out::println);
    }

    static void m2(){
        Integer[] integers = fill(new Integer[5], ()->7);

        for(int i:integers){
            System.out.println(i);
        }
    }

    static void m3(){
//        int[] ints = fill(new int[5], ()->7);  //compiler error
        /**
         * int[] != Integer[] == T[]
         * can't have a primitives as generics
         *
         */
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
