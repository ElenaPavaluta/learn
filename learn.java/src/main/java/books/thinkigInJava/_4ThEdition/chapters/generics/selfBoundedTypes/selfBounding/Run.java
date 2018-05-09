package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.selfBounding;

class Run {

    public static void main(String[] args) {
        A a = new A();
        a.set(new A());

        a = a.set(new A()).get();
        a  =a.get();

        C c = new C();
        c = c.setAntGet(new C());
    }
}
