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
    }
}
