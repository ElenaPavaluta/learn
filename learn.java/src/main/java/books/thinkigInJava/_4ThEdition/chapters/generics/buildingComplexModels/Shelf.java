package books.thinkigInJava._4ThEdition.chapters.generics.buildingComplexModels;

import java.util.ArrayList;

class Shelf extends ArrayList<Product> {

    public Shelf(int nrProd) {
        Suppliers.fill(this, Product.supplier(), nrProd);
    }
}
