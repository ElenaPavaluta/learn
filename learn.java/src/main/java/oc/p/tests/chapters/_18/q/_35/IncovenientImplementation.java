package oc.p.tests.chapters._18.q._35;

class IncovenientImplementation {
    static void m(){
        int i = 7;

        while (i != 'x'){
            i++;
        }
        System.out.println(i);
    }

    public static void main(String[] args) {
        m();
    }
}
