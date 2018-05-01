package books.thinkigInJava4ThEdition.chapters.generics.bounds.color;

import java.awt.*;

class Solid<T extends Dimension & HasColor & Weight> {
    T item;

    public Solid(T item) {
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

    int weight(){
        return item.weight();
    }
}
