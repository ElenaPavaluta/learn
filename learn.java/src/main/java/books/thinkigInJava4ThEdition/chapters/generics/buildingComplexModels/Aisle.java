package books.thinkigInJava4ThEdition.chapters.generics.buildingComplexModels;

import java.util.ArrayList;
import java.util.stream.IntStream;

class Aisle extends ArrayList<Shelf> {

    Aisle(int nShelfs, int nProds){
        IntStream.range(0, nShelfs)
                 .forEach(i->add(new Shelf(nProds)));
    }
}
