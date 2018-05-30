package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.tw;

import java.io.EOFException;
import java.sql.SQLException;

class RunA {

    static void m() {
        try(ACCheckedException acCheckedException = new ACCheckedException();
            ACUncheckedException acUncheckedException = new ACUncheckedException()) {
            System.out.println("m");
            throw new IllegalArgumentException("IAE");
        } catch(IllegalArgumentException e) {
            print(e);
        } catch(IllegalStateException e) {

        } catch(SQLException e) {

        } finally {
            System.out.println("finally");
        }
    }

    static void m2() {
        try(ACCheckedException acCheckedException = new ACCheckedException();
            ACUncheckedException acUncheckedException = new ACUncheckedException()) {
            System.out.println("m2");
            throw new IllegalArgumentException("IAE");
        } catch(IllegalArgumentException | IllegalStateException | SQLException e) {
            print(e);
        } finally {
            System.out.println("finally");
        }
    }

    static void m3() {
        try(ACCheckedException acCheckedException = new ACCheckedException();
            ACUncheckedException acUncheckedException = new ACUncheckedException()) {
            throw new EOFException("EOF");
        } catch(SQLException e) {
            print(e);
        } catch(IllegalStateException e) {
            print(e);
        } catch(IllegalArgumentException e) {
            print(e);
        } catch(EOFException e) {
            System.out.println("eof catch");
            print(e);
        } finally {
            System.out.println("finally");
        }
    }

    static void m4() {
        try(ACUncheckedException acUncheckedException = new ACUncheckedException();
            ACCheckedException acCheckedException = new ACCheckedException()) {
            throw new IllegalArgumentException("IAE"); //this is not going to be caught
        } catch(SQLException e) {
            print(e);
        }
    }

    static void m44() {
        try(ACUncheckedException acUncheckedException = new ACUncheckedException();
            ACCheckedException acCheckedException = new ACCheckedException()) {
            throw new IllegalArgumentException("IAE"); //this is not going to be caught
        } catch(SQLException e) {
            print(e);
        } finally {
            throw new RuntimeException("RE");
        }
    }

    static void m5() {
        try(ACCheckedException acCheckedException = new ACCheckedException();
            ACUncheckedException acUncheckedException = new ACUncheckedException()) {
            try(ACUncheckedException acUncheckedException1 = new ACUncheckedException();
                ACCheckedException acCheckedException1 = new ACCheckedException();
            ) {
                System.out.println("no error thrown here");
            }
        } catch(IllegalStateException | SQLException e) {
            print(e);
        }
    }

    static void m55() {
        try(ACCheckedException acCheckedException = new ACCheckedException();
            ACUncheckedException acUncheckedException = new ACUncheckedException()) {
            try(ACUncheckedException acUncheckedException1 = new ACUncheckedException();
                ACCheckedException acCheckedException1 = new ACCheckedException();
            ) {
                throw new IllegalArgumentException("IAE");
            }
        } catch(IllegalStateException | SQLException e) {
            print(e);
        }
    }

    static void m6(){
        class B implements AutoCloseable{

            @Override
            public void close() throws EOFException {
                throw new EOFException("EOF");
            }
        }

        class C{
            void m() throws EOFException{
                try(B b = new B()){
                    System.out.println("c m()");
                }
            }
        }

        try(ACUncheckedException acUncheckedException = new ACUncheckedException();
        ACCheckedException acCheckedException = new ACCheckedException()){
            new C().m();
        }catch(SQLException | EOFException e){
            print(e);
        }

    }

    private static void print(Exception e) {
        System.out.println(e.getMessage());
        suppressed(e);
    }

    static void suppressed(Exception e) {
        for(Throwable t : e.getSuppressed()) {
            System.out.println(t.getMessage());
        }
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
//        m4();  //throws IAE; suppressed: SQL E, ISE
//        m44();  //throws RE; due to the fact the final block and takes precedence
//        m5();
//        m55();  //thows IAE which is not caught by the cath block
        m6();
    }


}
