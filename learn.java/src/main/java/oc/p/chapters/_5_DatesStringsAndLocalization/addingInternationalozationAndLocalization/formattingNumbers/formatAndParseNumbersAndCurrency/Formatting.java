package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.formattingNumbers.formatAndParseNumbersAndCurrency;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * static NumberFormat	getInstance()
 *      Returns a general-purpose number format for the current default FORMAT locale.
 *
 * static NumberFormat	getInstance(Locale inLocale)
 *      Returns a general-purpose number format for the specified locale.
 *
 *
 * static NumberFormat	getNumberInstance()
 *      Returns a general-purpose number format for the current default FORMAT locale.
 *
 * static NumberFormat	getNumberInstance(Locale inLocale)
 *      Returns a general-purpose number format for the specified locale.
 *
 *
 * static NumberFormat	getCurrencyInstance()
 *      Returns a currency format for the current default FORMAT locale.
 *
 * static NumberFormat	getCurrencyInstance(Locale inLocale)
 *      Returns a currency format for the specified locale.
 *
 *
 * static NumberFormat	getPercentInstance()
 *      Returns a percentage format for the current default FORMAT locale.
 *
 * static NumberFormat	getPercentInstance(Locale inLocale)
 *      Returns a percentage format for the specified locale.
 */
class Formatting {

    static NumberFormat numberFormat;
    static double nb  =1234.5678;
    static Locale locale = Locale.GERMANY;

    static void print(){
        numberFormat.setMaximumFractionDigits(Integer.MAX_VALUE);
        System.out.println(numberFormat.format(nb));
    }

    static void space(){
        System.out.println();
    }

    static void m(){
        numberFormat = NumberFormat.getInstance();
        print();

        numberFormat = NumberFormat.getInstance(locale);
        print();
    }

    static void m2(){
        numberFormat = NumberFormat.getNumberInstance();
        print();

        numberFormat = NumberFormat.getNumberInstance(locale);
        print();
    }

    static void m3(){
        numberFormat = NumberFormat.getCurrencyInstance();
        print();
        numberFormat = NumberFormat.getCurrencyInstance(locale);
        print();
    }

    static void m4(){
        numberFormat = NumberFormat.getPercentInstance();
        print();

        numberFormat = NumberFormat.getPercentInstance(locale);
        print();
    }

    public static void main(String[] args) {
        m();
        space();
        m2();
        space();
        m3();
        space();
        m4();
    }
}
