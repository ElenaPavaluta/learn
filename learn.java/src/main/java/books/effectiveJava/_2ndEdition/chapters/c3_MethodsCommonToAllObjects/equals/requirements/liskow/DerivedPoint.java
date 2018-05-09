package books.effectiveJava._2ndEdition.chapters.c3_MethodsCommonToAllObjects.equals.requirements.liskow;

class DerivedPoint extends Point {
    public DerivedPoint(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
