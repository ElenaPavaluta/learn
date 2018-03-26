package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.exchanger.tw;

abstract class Base {

    private String name;

    Base() {
        name = this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "dishName='" + name;
    }
}
