package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.chainingOptionals.checkedExceptionsAndFunctionalInterfaces;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

class CaseStudy {

    /**
     * Remember
     * If a method throws a checked exception, it needs either
     * to  rethrow that exception of to handle it
     * (with a try-catch block)
     */
    static void m() throws IOException {
        ExceptionCaseStudy.create().stream().count();
    }

    static void m2() {
        try {
            ExceptionCaseStudy.create().stream().count();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static void m3() {
//        Supplier<List<String>> supplier = ExceptionCaseStudy::create;  //unhandled exception;
        // the supplier interface does not allow checked exceptions
    }

    //first get around approach
    static void m4() {
        Supplier<List<String>> supplier = ()->{
            try {
                return ExceptionCaseStudy.create();
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        };
    }

    //second approach: the preferred one: create a wrapper method with the try/catch

    static void m5(){
        Supplier<List<String>> supplier = ExceptionCaseStudy::createSafe;
    }
}
