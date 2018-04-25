package books.thinkigInJava4ThEdition.chapters.generics.anonymousInnerClasses;

class Customer {
    static long counter = 1;
    final long id = counter++;

    private  Customer() {
    }

    static Generator<Customer> generator() {
        return () -> new Customer();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + id;
    }
}


