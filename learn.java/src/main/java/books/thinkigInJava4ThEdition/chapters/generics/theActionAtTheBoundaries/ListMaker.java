package books.thinkigInJava4ThEdition.chapters.generics.theActionAtTheBoundaries;

import java.util.ArrayList;
import java.util.List;

class ListMaker<T> {

    List<T> create(){
        return new ArrayList<>();
    }
}
