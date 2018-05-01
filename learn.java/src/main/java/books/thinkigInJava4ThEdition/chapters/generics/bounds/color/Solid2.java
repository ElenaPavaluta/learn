package books.thinkigInJava4ThEdition.chapters.generics.bounds.color;

class Solid2<T extends Dimension & HasColor & Weight> extends ColorDimension2<T>{
    public Solid2(T item) {
        super(item);
    }

    int weight(){
        return item.weight();
    }
}
