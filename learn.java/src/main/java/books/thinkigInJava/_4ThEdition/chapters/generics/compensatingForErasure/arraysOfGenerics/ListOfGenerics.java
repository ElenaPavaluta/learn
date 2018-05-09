package books.thinkigInJava._4ThEdition.chapters.generics.compensatingForErasure.arraysOfGenerics;

import java.util.ArrayList;
import java.util.List;

class ListOfGenerics<T> {
    private List<T> array = new ArrayList<>();

    void add(T item){
        array.add(item);
    }

    T get(int index){
        return array.get(index);
    }
}

