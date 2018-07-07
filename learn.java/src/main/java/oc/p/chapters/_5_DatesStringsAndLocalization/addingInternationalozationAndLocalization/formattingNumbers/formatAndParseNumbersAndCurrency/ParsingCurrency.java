package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.formattingNumbers.formatAndParseNumbersAndCurrency;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

class ParsingCurrency {

    static Locale locale = Locale.GERMANY;
    static NumberFormat nf;

    static String s = "$1.2,3";
    static String s2 = "$1,2.3";
    static String s3 = "1,2.3 €";
    static String s4 = "1.2,3 €";
    static String s5 = "1.2,3€";
    static String s6 = "$1,2.3 €";

    static void m() throws ParseException {
        nf = NumberFormat.getCurrencyInstance();

        nf.parse(s);
        nf.parse(s2);
//        nf.parse(s3); //ParseException
//        nf.parse(s4); //ParseException
//        nf.parse(s5);  //ParseException
        nf.parse(s6);
    }

    static void m2() throws ParseException{
        nf = NumberFormat.getCurrencyInstance(locale);

//        nf.parse(s);  //PE
//        nf.parse(s2);  //PE
//        nf.parse(s3);  //PE: sees the , which for German means decimals, but after isn't ' €' as it expects
        nf.parse(s4);
//        nf.parse(s5);  //PE
//        nf.parse(s6);  //PE
    }

    public static void main(String[] args) throws ParseException {
//        createAndPopulate();
        m2();
    }

}
