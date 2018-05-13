package books.thinkigInJava._4ThEdition.chapters.generics.mixins.mixingWithInterfaces;

class BasicImpl implements Basic {
    private String val;

    @Override
    public void set(String val) {
        this.val  =val;
    }

    @Override
    public String get() {
        return val;
    }
}
