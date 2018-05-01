package books.thinkigInJava4ThEdition.chapters.generics.bounds.color;

import java.awt.*;

class Colored<T extends HasColor> {
    T item;

    public Colored(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    Color color(){
        return item.getColor();
    }
}
