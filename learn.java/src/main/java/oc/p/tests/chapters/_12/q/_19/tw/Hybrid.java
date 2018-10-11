package oc.p.tests.chapters._12.q._19.tw;

class Hybrid {

    static class SNC {

        class INC {

            class INC2 {

                class INC3 {
                }
            }
        }
    }

}

class RunH {
    public static void main(String[] args) {
        Hybrid h = new Hybrid();

        Hybrid.SNC snc = new Hybrid.SNC();

        Hybrid.SNC.INC hSncInc = new Hybrid.SNC(). new INC();

        Hybrid.SNC.INC.INC2 hSncIncInc2 = new Hybrid.SNC().new INC().new INC2();

        Hybrid.SNC.INC.INC2.INC3 hSncIncInc2Inc3 = new Hybrid.SNC().new INC(). new INC2(). new INC3();
    }
}
