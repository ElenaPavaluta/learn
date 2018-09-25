package oc.p.chapters._5_DatesStringsAndLocalization.reviewingTheStringClass.tw._1.sub;

class B {

    private String privateString = "private String";
    public String publicString = "public String";

    void m(){
        System.out.println(privateString.hashCode());
        System.out.println(publicString.hashCode());
    }

    public static void main(String[] args) {
        new B().m();
    }
}
