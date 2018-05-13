package books.thinkigInJava._4ThEdition.chapters.generics.mixins.mixingWithInterfaces;

class Mixin extends BasicImpl implements TimeStamped, SerialNumbered {
    private TimeStamped timeStamped = new TimeStampedImpl();
    private SerialNumbered serialNumbered = new SerialNumberedImpl();

    @Override
    public long getSerialNumber() {
        return serialNumbered.getSerialNumber();
    }

    @Override
    public long getStamp() {
        return timeStamped.getStamp();
    }
}
