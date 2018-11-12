package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.tw._5;

import java.sql.SQLException;
import java.util.Arrays;

class Q {

    static void m() {
        try (CE ce = new Q().new CE()) {
            throw new NullPointerException("NPE");
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
            Arrays.stream(e.getSuppressed()).forEach(w -> System.out.println(w.getMessage()));
        }
    }

    public static void main(String[] args) {
        m();
    }

    class CE implements AutoCloseable {
        @Override
        public void close() throws SQLException {
            throw new SQLException("SQLE");
        }
    }
}
