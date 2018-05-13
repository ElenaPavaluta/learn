package books.thinkigInJava._4ThEdition.chapters.generics.mixins.mixingWithInterfaces;

class MIxins {

    public static void main(String[] args) {
        Mixin m = new Mixin(),  m2 = new Mixin();

        m.set("test String 1");
        m2.set("test String 2");

        System.out.println(m.get() + " " + m.getStamp() + " " +m.getSerialNumber() );

        System.out.println(m2.get() + " " + m2.getStamp() + " " + m2.getSerialNumber());
    }
}
