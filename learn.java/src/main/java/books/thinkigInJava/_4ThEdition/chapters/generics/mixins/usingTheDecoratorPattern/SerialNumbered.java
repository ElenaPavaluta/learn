package books.thinkigInJava._4ThEdition.chapters.generics.mixins.usingTheDecoratorPattern;

class SerialNumbered extends Decorator {
    private static long counter = 1;
    private final long serialNumber = counter++;

    public SerialNumbered(Basic basic) {
        super(basic);
    }

    public long getSerialNumber() {
        return serialNumber;
    }
}
