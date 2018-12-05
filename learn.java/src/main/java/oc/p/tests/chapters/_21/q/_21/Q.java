package oc.p.tests.chapters._21.q._21;

import utils.print.Print;

import java.sql.Connection;
import java.util.Arrays;

class Q {
    class RS implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new Exception("RS");
        }
    }

    class STMT implements AutoCloseable {
        private RS rs = new RS();

        RS create() {
            return rs;
        }

        @Override
        public void close() throws Exception {
            throw new Exception("STMT");
        }
    }

    class CONN implements AutoCloseable {
        private STMT stmt = new STMT();

        STMT stmt() {
            return stmt;
        }

        @Override
        public void close() throws Exception {
            throw new Exception( "CONN");
        }
    }

    class CONN2 implements AutoCloseable {
        private STMT stmt = new STMT();

        STMT stmt() {
            return stmt;
        }

        @Override
        public void close() throws Exception {
//            throw new Exception( "CONN");
        }
    }

    void m(){
        try(CONN conn = new CONN();
        STMT stmt = conn.stmt();
        RS rs = stmt.create()){

        }catch (Exception e){
            print(e);
        }
    }

    private void print(final Exception e) {
        System.out.println(e.getMessage());
        Print.Delimitators.equal();
        Arrays.stream(e.getSuppressed())
                .forEach(q-> System.out.println(q.getMessage()));
    }

    void m2(){
        try (CONN conn = new CONN()){
            STMT stmt = conn.stmt();
            RS rs = stmt.create();
        }catch (Exception e){
            print(e);
        }
    }

    void m3(CONN2 conn){
        try(STMT stmt = conn.stmt();
        RS rs = stmt.create()) {
        } catch (Exception e) {
            print(e);
        }
    }

    public static void main(String[] args) {
        Q q =  new Q();

//        q.m();
//        q.m2();

        q.m3(q.new CONN2());
    }
}
