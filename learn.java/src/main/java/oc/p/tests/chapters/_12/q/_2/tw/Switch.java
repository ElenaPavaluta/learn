package oc.p.tests.chapters._12.q._2.tw;

class Switch {

    static void m(int a) {
        a  = 5;
        switch (a) {
            case 2:
                System.out.println(2);
                break;
            default:
                System.out.println(a);
        }
    }

    public static void main(String[] args) {
        m(7);
    }
}
