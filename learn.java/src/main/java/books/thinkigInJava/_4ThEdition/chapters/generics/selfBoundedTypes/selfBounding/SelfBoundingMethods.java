package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.selfBounding;

class SelfBoundingMethods {

    /**
     * This prevents the method from being applied to anything but a
     * self-bounded argument of the form shown
     */
    static <T extends SelfBounded<T>> T f(T arg){
        return arg.set(arg).get();
    }

    public static void main(String[] args) {
        A a = f(new A());
    }
}
