package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.tw._5;

import java.sql.SQLException;
import java.util.Arrays;

class Q2 {

    public static void main(String[] args) {
//        m();
        m2();
    }

    static void m() {
        try (Q2.A a = new Q2().new A();
             B b = a.getB()) {

            throw new NullPointerException("NPE");

        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
            Arrays.stream(e.getSuppressed()).forEach(q -> System.out.println(q.getMessage()));
        }
    }

    static void m2() {
        try (Q2.B b = new Q2().new B();
             Q2.A a = new Q2().new A()) {
            throw new NullPointerException("NPE");
        } catch (NullPointerException | SQLException e) {
            System.out.println(e.getMessage());
            Arrays.stream(e.getSuppressed()).forEach(q -> System.out.println(q.getMessage()));
        }
    }

    class A implements AutoCloseable {

        B getB() {
            return new B();
        }

        @Override
        public void close() throws SQLException {
            throw new SQLException("A");
        }
    }

    class B implements AutoCloseable {
        @Override
        public void close() throws SQLException {
            throw new SQLException("B");
        }
    }
}
