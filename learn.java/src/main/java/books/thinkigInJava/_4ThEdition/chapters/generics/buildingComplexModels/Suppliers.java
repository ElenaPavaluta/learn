package books.thinkigInJava._4ThEdition.chapters.generics.buildingComplexModels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Suppliers {

    public static <T> Collection<T> fill(Collection<T> coll, Supplier<T> supplier, int n) {
        IntStream.range(0, n)
                 .forEach(i -> coll.add(supplier.get()));
        return coll;
    }

    public static <T> List<T> fill(List<T> coll, Supplier<T> supplier, int n) {
        return (List<T>) fill((Collection<T>) coll, supplier, n);
    }

    public static <T> Queue<T> fill(Queue<T> col, Supplier<T> supplier, int n) {
        return (Queue<T>) fill((Collection<T>) col, supplier, n);
    }


    public static void main(String[] args) {
        List<String> lst = (List<String>) fill(new ArrayList<>(), () -> "a", 5);
    }
}
