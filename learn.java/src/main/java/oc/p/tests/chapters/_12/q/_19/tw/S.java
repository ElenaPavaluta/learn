package oc.p.tests.chapters._12.q._19.tw;

class S {

    public static void main(String[] args) {
        S s = new S();

        SNC a = new SNC();

        SNC.SNC2 b = new SNC.SNC2();

        SNC.SNC2.SNC3 c = new SNC.SNC2.SNC3();
    }

    static class SNC {

        static class SNC2 {

            static class SNC3 {
            }
        }

    }
}

class Run {

    public static void main(String[] args) {
        S s = new S();

        S.SNC snc = new S.SNC();
//        S.SNC snc2 = new s.SNC();  //compiler error
//        S.SNC snc3  =s.new SNC();  //compiler error: works only for inner classes(member, local, anonymous)

        S.SNC.SNC2 a = new S.SNC.SNC2();

        S.SNC.SNC2.SNC3 b = new S.SNC.SNC2.SNC3();
    }
}
