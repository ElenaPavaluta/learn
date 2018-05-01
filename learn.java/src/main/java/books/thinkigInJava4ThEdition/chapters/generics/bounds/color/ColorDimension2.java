package books.thinkigInJava4ThEdition.chapters.generics.bounds.color;

class ColorDimension2<T extends Dimension & HasColor> extends Color2<T> {
    public ColorDimension2(T item) {
        super(item);
    }

    int getX(){
        return item.x;
    }

    int getY(){
        return item.y;
    }

    int getZ(){
        return item.z;
    }
}
