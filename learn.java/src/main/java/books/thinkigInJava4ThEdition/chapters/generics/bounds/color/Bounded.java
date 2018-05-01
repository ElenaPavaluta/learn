package books.thinkigInJava4ThEdition.chapters.generics.bounds.color;

import java.awt.*;

class Bounded extends Dimension implements HasColor, Weight {

    public Bounded() {
        this.x = 1;
        this.y = 2;
        this.z = 3;
    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }

    @Override
    public int weight() {
        return 23;
    }
}
