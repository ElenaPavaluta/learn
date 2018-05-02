package books.thinkigInJava4ThEdition.chapters.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

class GenericWriting {

    static <T> void writeExact(List<T> lst, T item){
        lst.add(item);
    }

    static List<Apple> apples = new ArrayList<>();
    static List<Fruit> fruits = new ArrayList<>();

    static void f(){
        writeExact(apples, new Apple());
        writeExact(fruits, new Apple());
    }

    static <T> void writeWithWildcards(List<? extends T> lst, T item){
//        lst.add(item);
    }

    public static void main(String[] args) {
        f();
    }
}
