package books.thinkigInJava4ThEdition.chapters.generics.bounds.color;

class InheritBounds {

    static void m(){
        Solid2<Bounded> solid2 = new Solid2<>(new Bounded());
        System.out.println(solid2.color());
        System.out.println(solid2.getY());
        System.out.println(solid2.weight());
    }

    public static void main(String[] args) {
        m();
    }
}
