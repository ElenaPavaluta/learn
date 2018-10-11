package oc.p.tests.chapters._12.q._28;

class Penguin {
    private int vol = 1;

    private class Chick{
        private /*static*/ int vol = 3;

        void m(){
            System.out.println(Penguin.this.vol);
        }
    }

    public static void main(String[] args) {
        new Penguin().new Chick().m();
    }
}
