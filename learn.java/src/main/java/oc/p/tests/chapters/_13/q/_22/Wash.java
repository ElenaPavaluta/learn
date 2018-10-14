package oc.p.tests.chapters._13.q._22;

class Wash<T> {
    T item;

    void clean(T item){
        System.out.println("Clean: " + item);
    }

    static void m(){
        Wash w = new Wash();
        w.clean("socks");
    }

    static void m2(){
        Wash w = new Wash<String>();
        w.clean("socks");
    }

    static void m3(){
        Wash<String> w = new Wash <>();
        w.clean("socks");
    }

    public static void main(String[] args) {
        m();
        m2();
        m3();
    }
}
