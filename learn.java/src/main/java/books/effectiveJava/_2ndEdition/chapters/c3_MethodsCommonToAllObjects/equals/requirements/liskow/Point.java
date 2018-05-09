package books.effectiveJava._2ndEdition.chapters.c3_MethodsCommonToAllObjects.equals.requirements.liskow;

/**
 * The Liskov substitution principle says that any important property
 * of a type should also hold for its subtypes,
 * so that any method written for the type should
 * work equally well on its subtypes
 */
class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Breaks Liskow principle
     *
     * This has the effect of equating objects
     * only if they have the same implementation
     * class.
     */
    @Override
    public boolean equals(Object o) {
        if(o == null || o.getClass() != getClass()) {
            return false;
        }
        Point p = (Point) o;
        return this.x == p.x && this.y == p.y;
    }

}
