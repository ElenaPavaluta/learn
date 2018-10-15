package oc.p.chapters._6_ExceptionsAndAssertions.workingWithAssertions;

class Assertions {

    static void sm(){
        assert false: "this is false";
    }

    static void m(int i){
        assert i>0;
        System.out.println(i);
    }

    public static void main(String[] args) {
//        sm();
//        m(2);
        m(-0b11111);
    }
}
