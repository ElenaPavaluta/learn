package books.thinkigInJava._4ThEdition.chapters.generics.bounds.color;

import java.awt.*;

class Color2<T extends HasColor> extends HoldItem<T> {

    public Color2(T item) {
        super(item);
    }

    Color color(){
       return this.item.getColor();
    }
}
