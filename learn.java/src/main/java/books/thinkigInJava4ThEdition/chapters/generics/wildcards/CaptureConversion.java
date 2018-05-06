package books.thinkigInJava4ThEdition.chapters.generics.wildcards;

class CaptureConversion {

    static <T> void f(Holder<T> holder){
        T t = holder.getT();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder){
        f(holder);
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Integer>(1);

        f(raw);  //warning
        f2(raw);

        Holder rawBasic = new Holder();
        rawBasic.setT(new Object());
        f2(rawBasic);

        Holder<?> wildcarded = new Holder<Double>(2d);
        f2(wildcarded);
    }
}
