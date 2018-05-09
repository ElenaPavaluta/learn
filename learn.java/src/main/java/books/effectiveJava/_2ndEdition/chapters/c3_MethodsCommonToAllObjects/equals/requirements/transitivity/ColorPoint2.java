package books.effectiveJava._2ndEdition.chapters.c3_MethodsCommonToAllObjects.equals.requirements.transitivity;

import java.awt.*;

class ColorPoint2 extends Point {
    private final Color color;

    public ColorPoint2(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }


    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point)){
            return false;
        }
        //if o is a normal point do a color blind comparasion
        if(!(o instanceof ColorPoint2)){
            return super.equals(o);
        }

        //o is ColorPoint, do a full comparison
        return super.equals(o) && ((ColorPoint2)o).color == color;
    }

    public static void main(String[] args) {
        ColorPoint2 cp = new ColorPoint2(1, 2, Color.BLUE);
        Point p = new Point(1, 2);
        ColorPoint2 cp2 = new ColorPoint2(1,2, Color.RED);

        /**
         * Obeys symmetry
         * Breaks transitivity
         */
        System.out.println(cp.equals(p));  //true
        System.out.println(p.equals(cp2));  //true
        System.out.println(cp.equals(cp2));  //false

    }
}
