package oc.p.chapters.c_5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.formattingNumbers.formatAndParseNumbersAndCurrency;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

class Parsing {

    static NumberFormat nf;
    static Locale locale = Locale.GERMANY;

    static String s = "123.456,789";
    static String s2 = "123,456.789";

    static String s3 = "$123.456,789";
    static String s4 = "$123,456.789";

    static String s5 = "123.456,789%";
    static String s6 = "123,456.789%";

    static String s7 = "123%";

    static void m() throws ParseException {
        nf = NumberFormat.getInstance();

        a();
    }

    static void m2() throws ParseException {
        nf = NumberFormat.getInstance(locale);
        a();
    }

    private static void a() throws ParseException {
        nf.parse(s);
        nf.parse(s2);
//        nf.parse(s3);
//        nf.parse(s4);
        nf.parse(s5);
        nf.parse(s6);
        nf.parse(s7);
    }

    static void m3() throws ParseException {
        nf = NumberFormat.getNumberInstance();
        a();
    }

    static void m4() throws ParseException {
        nf = NumberFormat.getNumberInstance(locale);
        a();
    }

    static void m5() throws ParseException {
        nf = NumberFormat.getCurrencyInstance();

        //        nf.parse(s);
//        nf.parse(s2);
        nf.parse(s3);
        nf.parse(s4);
//        nf.parse(s5);
//        nf.parse(s6);
//        nf.parse(s7);

//                nf.parse("1€");
//        nf.parse("1 €");
//        nf.parse("1.1 €");
//        nf.parse("1,1 €");
    }


    static void m6() throws ParseException{
        nf = NumberFormat.getCurrencyInstance(locale);

//        nf.parse(s);
//        nf.parse(s2);
//        nf.parse(s3);
//        nf.parse(s4);
//        nf.parse(s5);
//        nf.parse(s6);
//        nf.parse(s7);

//        nf.parse("1€");
        nf.parse("1 €");
        nf.parse("1.1 €");
        nf.parse("1,1 €");

    }

    static void m7() throws ParseException{
        nf = NumberFormat.getPercentInstance();

//        nf.parse(s);
//        nf.parse(s2);
//        nf.parse(s3);
//        nf.parse(s4);
//        nf.parse(s5);
        nf.parse(s6);
        nf.parse(s7);
    }

    static void m8() throws ParseException{
        nf = NumberFormat.getPercentInstance(locale);

//        nf.parse(s);
//        nf.parse(s2);
//        nf.parse(s3);
//        nf.parse(s4);
        nf.parse(s5);
//        nf.parse(s6);
        nf.parse(s7);
    }

    public static void main(String[] args) throws ParseException {
//        m();
//        m2();
//        m3();
//        m4();
//        m5();
        m6();
//        m7();
//        m8();
    }


}
