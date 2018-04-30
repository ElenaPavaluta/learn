package books.thinkigInJava4ThEdition.chapters.generics.compensatingForErasure.arraysOfGenerics.tw;

class NullClass {

    private static final NullClass NULL_INSTANCE = new NullClass(null);

    private Long val;

    public NullClass(Long val) {
        this.val = val;
    }

    public Long getVal() {
        return val;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public static void main(String[] args) {
        System.out.println(NULL_INSTANCE.getVal());
        System.out.println(NULL_INSTANCE.toString());
        System.out.println(String.valueOf((Object) null));
    }
}
