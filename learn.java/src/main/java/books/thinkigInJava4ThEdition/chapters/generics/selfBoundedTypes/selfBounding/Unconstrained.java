package books.thinkigInJava4ThEdition.chapters.generics.selfBoundedTypes.selfBounding;

class Unconstrained {

    public static void main(String[] args) {
        BasicHolderOfOther b = new BasicHolderOfOther(), b2 = new BasicHolderOfOther();
        b.set(new Other());
        Other o = b.get();
        b.print();
    }
}
