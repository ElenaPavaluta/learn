package books.thinkigInJava4ThEdition.chapters.generics.selfBoundedTypes.selfBounding.tw._1;

import books.thinkigInJava4ThEdition.chapters.generics.selfBoundedTypes.curioslyRecurringGenerics.BasicHolder;

class BasicHolderForOtherObj extends BasicHolder<Other> {

    public static void main(String[] args) {
        BasicHolderForOtherObj b = new BasicHolderForOtherObj(),
                b2 = new BasicHolderForOtherObj();

        b.set(new Other());
        Other o = b.get();
        b.print();
    }

    @Override
    public void set(Other element) {
        super.set(element);
    }

    @Override
    public Other get() {
        return super.get();
    }

    @Override
    public void print() {
        super.print();
    }
}
