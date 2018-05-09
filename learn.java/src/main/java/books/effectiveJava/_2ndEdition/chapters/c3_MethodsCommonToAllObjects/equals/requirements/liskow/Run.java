package books.effectiveJava._2ndEdition.chapters.c3_MethodsCommonToAllObjects.equals.requirements.liskow;

import java.util.HashSet;
import java.util.Set;

class Run {

    static Set<Point> set;
    static {
        set = new HashSet<>();
        set.add(new Point(1, 0));
        set.add(new Point(0, 1));
    }

    public static void main(String[] args) {
        Point p = new DerivedPoint(1, 0);
        System.out.println(set.contains(p));  //false

        DerivedPoint dp = new DerivedPoint(0, 1);
        System.out.println(set.contains(dp));  //false

        Point p2 = new DerivedPoint(1, 0);
        System.out.println(p.equals(p2));  //true
     }
}
