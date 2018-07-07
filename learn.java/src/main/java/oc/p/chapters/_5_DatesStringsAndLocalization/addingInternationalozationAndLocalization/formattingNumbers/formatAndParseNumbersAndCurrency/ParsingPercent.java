package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.formattingNumbers.formatAndParseNumbersAndCurrency;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

class ParsingPercent {

    static Locale locale = Locale.GERMANY;
    static NumberFormat nf;

    static String s = "1.2,2%";
    static String s2 = "1,2.2%";

    static String s3 = "1.2,2 %";
    static String s4 = "1,2.2 %";

    static void m() throws ParseException {
        nf = NumberFormat.getPercentInstance();

//        nf.parse(s); //PE
        nf.parse(s2);
//        nf.parse(s3);  //PE
//        nf.parse(s4);  //PE
    }

    static void m2() throws ParseException{
        nf = NumberFormat.getPercentInstance(locale);

        nf.parse(s);
//        nf.parse(s2);  //PE
//        nf.parse(s3);  //PE
//        nf.parse(s4);  //PE
    }

    public static void main(String[] args) throws ParseException {
//        createAndPopulate();
        m2();

    }
}
