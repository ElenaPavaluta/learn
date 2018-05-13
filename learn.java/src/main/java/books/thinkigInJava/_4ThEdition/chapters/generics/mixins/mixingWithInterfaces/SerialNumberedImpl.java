package books.thinkigInJava._4ThEdition.chapters.generics.mixins.mixingWithInterfaces;

class SerialNumberedImpl implements SerialNumbered{
    private static long counter = 1;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}
