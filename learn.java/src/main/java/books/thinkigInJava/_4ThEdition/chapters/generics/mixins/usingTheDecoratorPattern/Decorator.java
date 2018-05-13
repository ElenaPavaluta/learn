package books.thinkigInJava._4ThEdition.chapters.generics.mixins.usingTheDecoratorPattern;

class Decorator extends Basic {
    protected Basic basic;

    public Decorator(Basic basic) {
        this.basic = basic;
    }

    @Override
    public String getValue() {
        return basic.getValue();
    }

    @Override
    public void setValue(String value) {
        basic.setValue(value);
    }
}
