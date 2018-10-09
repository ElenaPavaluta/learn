package oc.p.tests.chapters._11.q._13.tw;

class Comp {

    String type = "comp";

    class Laptop extends Comp{
//        String type = "laptop";
{
    super.type = "blabla";
}
    }

    public static void main(String[] args) {
        Comp comp = new Comp();

        Comp c = comp.new Laptop();
        Laptop l = comp.new Laptop();

        System.out.println(c.type);  //comp
        System.out.println(l.type);  //laptop
    }
}
