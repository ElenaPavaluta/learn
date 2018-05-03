package books.thinkigInJava4ThEdition.chapters.generics.wildcards;

class Holder<T> {

    private T t;

    public Holder() {
    }

    public Holder(T t) {
        this.t = t;
    }

    static void m() {
        Holder<Apple> appleHolder = new Holder<>(new Apple());
        Apple a = appleHolder.getT();
        appleHolder.setT(a);

        Holder<Fruit> fruitHolder = new Holder<>(new Apple());

//        fruitHolder = appleHolder;  //cannot upcast

        Holder<? extends Fruit> fruitHolder2 = appleHolder;

        Fruit f = fruitHolder2.getT();
        a = (Apple)fruitHolder2.getT();

//        Orange o = (Orange)fruitHolder2.getT();  //ClassCastException
    }

    public static void main(String[] args) {
        m();
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public boolean equals(Object obj) {
        return t.equals(obj);
    }
}
