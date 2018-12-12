package oc.p.chapters._6_ExceptionsAndAssertions.reviewingExceptions.exceptionsOnTheOcp.unchecked.java.lang;

import java.time.LocalDate;

class ArrayStoreException {

    static void m(){
        LocalDate[] ald = new LocalDate[2];
        ald[0] = LocalDate.now();
//        ald[1] = LocalDateTime.now();  //compilerError
        ald[1] = LocalDate.now().plusDays(1);
//        ald[2] = LocalDate.now().plusDays(2);  //ArrayIndexOutOfBoundsException
    }

    static void m2(){
        Object[] ao = new Integer[3];
        ao[0] = "i";
        int nr = (Integer) ao[0];
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
