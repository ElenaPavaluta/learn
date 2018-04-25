package books.thinkigInJava4ThEdition.chapters.generics.buildingComplexModels;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Store extends ArrayList<Aisle> {

    private ArrayList<CheckoutStand> checkoutStands = new ArrayList<>();
    private Office office = new Office();

    public Store(int nAisles, int nShelves, int nProds) {
        IntStream.range(0, nAisles).forEach(i -> add(new Aisle(nShelves, nProds)));
    }

    public static void main(String[] args) {
        Store s = new Store(2, 3, 4);
//        System.out.println(s);
//        System.out.println(s.flatMap());
        System.out.println(s.flatMap2());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Aisle a : this) {
            for(Shelf s : a) {
                for(Product p : s) {
                    sb.append(p);
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    String flatMap() {
        StringBuilder sb = new StringBuilder();
        this.stream()
            .flatMap(ArrayList::stream)
            .flatMap(List::stream)
            .map(Product::toString)
            .collect(Collectors.toList())
            .stream()
            .forEach(s -> sb.append(s).append("\n"));

        return sb.toString();
    }

    String flatMap2(){
       return this.stream()
            .flatMap(List::stream)
            .flatMap(ArrayList::stream)
            .map(Product::toString)
            .collect(StringBuilder::new,
                    (sb, s)->sb.append(s).append("\n"),
                     (sb, sb2)->sb.append(sb2))
                  .toString();
    }
}
