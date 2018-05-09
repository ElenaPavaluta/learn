package books.thinkigInJava._4ThEdition.chapters.generics.bounds.color;

class BasicBounds {
    static void m(){
        Solid<Bounded> solid = new Solid<>(new Bounded());
        System.out.println( solid.color());
        System.out.println(solid.getY());
        System.out.println(solid.weight());
    }

    public static void main(String[] args) {
        m();
    }
}
