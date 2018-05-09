package books.effectiveJava._2ndEdition.chapters.c3_MethodsCommonToAllObjects.equals.requirements.transitivity;

import java.awt.*;

class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof ColorPoint)){
            return false;
        }
        return super.equals(o) && ((ColorPoint)o).color == color;
    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.BLUE);

        /**
         * Breaks symmetry
         */
        System.out.println(p.equals(cp));  //true
        System.out.println(cp.equals(p));  //false
    }
}
