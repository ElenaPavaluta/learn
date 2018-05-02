package books.thinkigInJava4ThEdition.chapters.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

class GenericReading {

    static List<Apple> apples = new ArrayList<>();
    static List<Fruit> fruits = new ArrayList<>();

    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    static void f() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruits);
        f = readExact(apples);
    }

    static class Reader<T>{
        T readExact(List<T> list){
            return list.get(0);
        }
    }

    static class CovarianReader<T>{
        T readCovariant(List<? extends T> list){
            return list.get(0);
        }
    }

    static void f2(){
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit f = fruitReader.readExact(fruits);

        /**
         * compiler error
         */
//       f = fruitReader.readExact(apples);

        readExact(apples);
    }

    static void f3(){
        CovarianReader<Fruit> fruitReader = new CovarianReader<>();
        Fruit f = fruitReader.readCovariant(fruits);
        Fruit a = fruitReader.readCovariant(apples);
    }
}
