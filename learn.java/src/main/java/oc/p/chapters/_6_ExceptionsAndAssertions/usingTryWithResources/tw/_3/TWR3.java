package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.tw._3;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;

class TWR3 {

    class NPE implements AutoCloseable {

        void m() throws ParseException {
            throw new ParseException("PE", 0);
        }

        @Override
        public void close() throws NullPointerException {
            throw new NullPointerException("NPE");
        }
    }

    class SQLE implements AutoCloseable {

        void m() {
            throw new IllegalArgumentException("IAE");
        }

        @Override
        public void close() throws SQLException {
            throw new SQLException("SQLE");
        }
    }

    void m(){
        try(NPE npe = new NPE();
        SQLE sqle = new SQLE()){
            npe.m();
            sqle.m();
        } catch (SQLException | ParseException e) {
            System.out.println(e.getMessage());
            Arrays.stream(e.getSuppressed()).forEach(q-> System.out.println(q.getMessage()));
        }
    }

    void m2(){
        try(NPE npe = new NPE();
            SQLE sqle = new SQLE()){
            /**
             * Throws IAE which nobody catches. Being a RE doesn't need to be cathced or delared
             */
            sqle.m();
            npe.m();
        } catch (SQLException | ParseException /*| IllegalArgumentException*/ e) {
            System.out.println(e.getMessage());
            Arrays.stream(e.getSuppressed()).forEach(q-> System.out.println(q.getMessage()));
        }
    }


    void m3(){
        try(NPE npe = new NPE();
            SQLE sqle = new SQLE()){

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
            Arrays.stream(e.getSuppressed()).forEach(q-> System.out.println(q.getMessage()));
        }
    }

    void m4(){
        try(SQLE sqle = new SQLE();
        NPE npe = new NPE()){

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
            Arrays.stream(e.getSuppressed()).forEach(q-> System.out.println(q.getMessage()));
        }
    }

    void m5(){
        try(NPE npe = new NPE(); SQLE sqle = new SQLE()) {

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getSuppressed()));
        }finally {
            System.out.println("finally");
        }
    }

    void m6(){
        try(SQLE sqle = new SQLE(); NPE npe = new NPE()) {

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getSuppressed()));
        }finally {
            System.out.println("finally");
        }
    }

    void m7(){
        try(SQLE sqle = new SQLE(); NPE npe = new NPE()) {

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getSuppressed()));
        }finally {
            System.out.println("finally");
            try{
                System.out.println("in finaly try");
                throw new RuntimeException("bla bla");
            }catch (RuntimeException e){
                System.out.println("finally catch");
                System.out.println(e.getMessage());
                Arrays.stream(e.getSuppressed()).forEach(q-> System.out.println(q.getMessage()));
            }
        }
    }


    public static void main(String[] args) {
        TWR3 twr = new TWR3();
//        twr.m();
//        twr.m2();  //RE
//        twr.m3();
//        twr.m4();  //RE
//        twr.m5();
//        twr.m6();  //RE
        twr.m7();
    }
}
