package oc.p.chapters.c_6_ExceptionsAndAssertions.usingTryWithResources.autoCloseable;

import java.sql.SQLException;

class AC2 {

    void m() {
        try(X x = new X()) {
            x.m();
        } catch(E2 e) {

        } catch(E e) {

        }
    }

    void m2() {
        try(X x = new X()) {
            x.m();
        } catch(E e) {

        }
    }

    void sql() throws SQLException {
    }

    void re() throws RuntimeException {
    }

    void m3() {
        try(X x = new X()) {
            x.m();
            sql();
            re();
        } catch(SQLException | RuntimeException | E e) {
            e.printStackTrace();
        }
    }

    class E extends Exception {
    }

    class E2 extends E {
    }

    class X implements AutoCloseable {
        @Override
        public void close() throws E2 {
            throw new E2();
        }

        void m() throws E {
            throw new E();
        }
    }
}
