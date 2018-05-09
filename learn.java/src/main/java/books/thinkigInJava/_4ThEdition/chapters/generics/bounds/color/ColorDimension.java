package books.thinkigInJava._4ThEdition.chapters.generics.bounds.color;

import java.awt.*;

/**
 * Compiler error: the class must be first
 */
//class ColorDimension<T extends HasColor & Dimension> { }

class ColorDimension<T extends Dimension & HasColor>{
    T item;

    public ColorDimension(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    Color color(){
        return item.getColor();
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
