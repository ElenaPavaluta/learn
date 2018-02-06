package oc.p.chapters.c_6_ExceptionsAndAssertions.usingTryWithResources.tw;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.sql.SQLException;

class RunB {

    static void m(){
        try(ConstruUE construUE = new ConstruUE();
        ConstrCE constrCE = new ConstrCE()){
            System.out.println("m()");
        }catch(FileNotFoundException | EOFException | IllegalStateException e){
            print(e);
        }
    }

    static void m2(){
        try(ACCheckedException acCheckedException = new ACCheckedException();
        ConstrCE constrCE = new ConstrCE()){
            System.out.println("it doesn't even enters here");
        }catch(SQLException | FileNotFoundException | EOFException e){
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
        m();  //constr ISE: since no resource has been created there's no point in trying to close what hasn't been created

        System.out.println("\n\n");

        m2();  //since one resorce has been created, the implicit final block tries to close that resource
    }
}
