package oc.p.tests.chapters._16.q._18;

class Tw {

    public static void main(String[] args) {
        Tw tw = new Tw();
        tw.m();
    }

    void m() {
        try {
            System.out.println("No exception thrown");
        } catch (RuntimeException e) {
            System.out.println("RE");
        } catch (Exception e) {
            System.out.println("E");
        } finally {
            System.out.println("This seems to be valid");
        }
    }

    void m2() {
        try {
            System.out.println("No exceptio thrwon");
            /**
             * Not allowed since RE extends E, so
             * disjoint rule broken
             */
        } catch (/*RuntimeException |*/ Exception e) {
        }
    }
}
