package oc.p.chapters._6_ExceptionsAndAssertions.usingMultiCatch.tw;

class Tw {

    boolean b, b2;

    void me() throws E {
        throw new E();
    }

    void me2() throws E2 {
        throw new E2();
    }

    void mre() throws RE {
        throw new RE();
    }

    void mre2() throws RE2 {
        throw new RE2();
    }

    void m() {
        try {
            mre2();
            me2();
        } catch(E2 e) {
            e.printStackTrace();
        } catch(RE2 e) {
            e.printStackTrace();
        }
    }

    void m2() {
        try {
            mre2();
            me2();
        } catch(E2 e) {

        } catch(RE2 e) {

        }
    }

    void m3() {
        try {
            me2();
            mre2();
        } catch(E2 | RE2 e) {
        }
    }

    void m4() {
        try {
            mre2();
            me2();
        } catch(RE2 | E2 e) {
        }
    }

    void m5() {
        try {
            throw new E2();
//        }catch(E2 | E e){}  //redundant, since the E, which is superclass for E2 is caught. So, one can either catch E2 or E
        } catch(E2 e) {
        }


    }


    void m6() {
        try {

            if(b) {
                throw new E2();
            } else {
                throw new E();
            }
        } catch(E2 e) {  //Types in normal catch doesn't need to be disjoint as it has to be for the multi-catch clause
        } catch(E e) {
        }
    }


    void m7() {
        try {

            if(b) {
                throw new E2();
            } else {
                throw new E();
            }
        } catch(E e) {  //compiler error for catch(E2 | E e): Type in multi catch must be disjoint, but they don't need to be disjoint for the normal catch
        }
    }
//when the exception are siblings it doesn't matter the order in which they are declared

    class E extends Exception {
    }

    class E2 extends E {
    }

    class RE extends RuntimeException {
    }

    class RE2 extends RE {
    }


}
