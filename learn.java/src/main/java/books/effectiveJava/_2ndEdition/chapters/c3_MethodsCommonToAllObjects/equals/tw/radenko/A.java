package books.effectiveJava._2ndEdition.chapters.c3_MethodsCommonToAllObjects.equals.tw.radenko;
class A {

    private final long l;

    public A(long l) {
        this.l = l;
    }

    @Override
    public boolean equals(Object o) {
        if(o ==null || o.getClass() != getClass()){
            return false;
        }
        return l == ((A)o).l;
    }
}

class B extends A{
    public B(long l) {
        super(l);
    }
}

class Run{
    public static void main(String[] args) {
        A a = new A(1);
        A b = new B(1);

        System.out.println(a.equals(b));  //false
    }
}
