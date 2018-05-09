package books.thinkigInJava._4ThEdition.chapters.generics.anonymousInnerClasses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

class Generators {

    static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        IntStream.range(0, n)
                 .forEach(i -> coll.add(gen.next()));
        return coll;
    }

    static <T> Collection<T> fill(List<T> coll, Generator<T> gen, int n){
        return (List<T>)fill((Collection<T>) coll, gen, n);
    }

    static <T> Collection<T> fill(Queue<T> coll, Generator<T> gen, int n){
        return (Queue<T>)fill((Collection<T>) coll, gen, n);
    }


    public static void main(String[] args) {
        List<String> lst = (List<String>) fill(new ArrayList<>(), () -> "a", 5);
    }
}
