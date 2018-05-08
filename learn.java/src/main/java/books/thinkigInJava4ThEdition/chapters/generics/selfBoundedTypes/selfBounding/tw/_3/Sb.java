package books.thinkigInJava4ThEdition.chapters.generics.selfBoundedTypes.selfBounding.tw._3;

/**
 * Self bounding
 *
 * Meaning: it can contain an object who is bounded with himself,
 * like a parent or child
 */
class Sb<T extends Sb<T>> {

    private T parent;
    private T child;

    public static void main(String[] args) {
        /**
         * Compiler error:
         *
         * String isn't extending Sb<String>         *
         */
//        Sb<String> sb = new Sb<String>();
    }

    public T getParent() {
        return parent;
    }

    public void setParent(T parent) {
        this.parent = parent;
    }

    public T getChild() {
        return child;
    }

    public void setChild(T child) {
        this.child = child;
    }
}

class A extends Sb<A> {

    public static void main(String[] args) {
        A a = new A();
        a.setParent(a);
        a.setChild(a);

        System.out.println(a == a.getParent());  //true
        System.out.println(a == a.getChild());  //true
    }
}

class B<U extends Sb<U>> extends Sb<U>{

    public static void main(String[] args) {
        B<A> b = new B<>();
        A a = new A();
        b.setParent(a);
        b.setChild(a);
    }
}
