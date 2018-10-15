package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.tw._3;

import java.io.NotSerializableException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;

class TWR {

    void m() {
        try (PE pe = new PE();
             SQLE sqle = new SQLE();
             NSE nse = new NSE()) {
            throw new RuntimeException("RE");
        } catch (ParseException | SQLException | NotSerializableException | RuntimeException e) {
            System.out.println(e.getMessage());
            Arrays.stream(e.getSuppressed()).forEach(q -> System.out.println(q.getMessage()));
        }
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

    class NSE implements AutoCloseable {
        @Override
        public void close() throws NotSerializableException {
            throw new NotSerializableException("NSE");
        }
    }

    public static void main(String[] args) {
        TWR twr = new TWR();
        twr.m();
    }
}
