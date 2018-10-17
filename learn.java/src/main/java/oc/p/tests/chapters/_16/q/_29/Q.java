package oc.p.tests.chapters._16.q._29;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;

class Q {
    void m() {
        try (PE pe = new PE(); SQLE sqle = new SQLE();) {
            throw new NullPointerException("NPE");
        } catch (NullPointerException e) {
            /**
             * The exception aren't caught the next catch clause
             * if the previous one throws as exception
             */
            throw new NullPointerException("NPE 2");
        } catch (ParseException | SQLException | RuntimeException e) {
            System.out.println(e.getMessage());
            Arrays.stream(e.getSuppressed()).forEach(q-> System.out.println(e.getMessage()));
        }
    }

    public static void main(String[] args) {
        Q q = new Q();
        q.m();
    }

    class PE implements AutoCloseable {
        @Override
        public void close() throws ParseException {
            throw new ParseException("PE", 0);
        }
    }

    class SQLE implements AutoCloseable {
        @Override
        public void close() throws SQLException {
            throw new SQLException("SQLE");
        }
    }
}
