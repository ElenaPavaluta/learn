package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.selfBounding.tw._1;

/**
 * Voila: special case
 * Basically the boundary is Object now,
 * so, all the trouble for defining the
 * SelfBounded class has been disregarded
 */
class E extends SelfBounded {

    public static void main(String[] args) {
        SelfBounded sb = new SelfBounded();
        E e = new E();

        sb.setT(e);
        e.setT(sb);


    }
}
