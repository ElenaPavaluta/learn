package oc.p.chapters.c_6_ExceptionsAndAssertions.reviewingExceptions.exceptionsOnTheOcp.checked;

import java.text.NumberFormat;
import java.util.Locale;

class ParseException {

    static NumberFormat numberFormat;
    static Locale locale;

    static void m() throws java.text.ParseException {
        numberFormat = NumberFormat.getInstance();
//        double d = (double)numberFormat.parse("23");  //java.lang.ClassCastException
        double d = numberFormat.parse("23").doubleValue();
        System.out.println(d);
    }

    static void m2() throws java.text.ParseException{
        numberFormat = NumberFormat.getPercentInstance();
        double d = numberFormat.parse("23.1,2%").doubleValue();
        System.out.println(d);
    }

    public static void main(String[] args) throws java.text.ParseException {
//        m();
        m2();
    }
}
