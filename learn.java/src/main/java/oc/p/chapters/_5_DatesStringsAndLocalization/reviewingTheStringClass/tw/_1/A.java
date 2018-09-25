package oc.p.chapters._5_DatesStringsAndLocalization.reviewingTheStringClass.tw._1;

class A {

    private String privateString = "private String";
    public String publicString = "public String";

    void m(){
        System.out.println(privateString.hashCode());
        System.out.println(publicString.hashCode());
    }

    public static void main(String[] args) {
        new A().m();
    }
}
