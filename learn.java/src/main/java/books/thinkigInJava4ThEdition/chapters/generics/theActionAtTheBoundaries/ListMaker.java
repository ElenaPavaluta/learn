package books.thinkigInJava4ThEdition.chapters.generics.theActionAtTheBoundaries;

import java.util.ArrayList;
import java.util.List;

class ListMaker<T> {

    public static void main(String[] args) {
        ListMaker<String> maker = new ListMaker<>();

        List<String> stringList = maker.create();
//        List<ObjectName> objectNames = maker.create();  //compiler error
    }

    List<T> create() {
        return new ArrayList<>();
    }
}
