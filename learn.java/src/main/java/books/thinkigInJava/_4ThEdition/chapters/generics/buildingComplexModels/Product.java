package books.thinkigInJava._4ThEdition.chapters.generics.buildingComplexModels;

import java.util.Random;
import java.util.function.Supplier;

class Product {
    private final int id;
    private String description;
    private double price;

    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return id + ": " + description + ", price: $" + price;
    }

    void priceChange(double change){
        price +=change;
    }

    static Supplier<Product> supplier(){
        Random rand = new Random(47);
        return ()->new Product(rand.nextInt(100), "Test", Math.round(rand.nextDouble()  * 1000)+ 0.99);
    }


}
