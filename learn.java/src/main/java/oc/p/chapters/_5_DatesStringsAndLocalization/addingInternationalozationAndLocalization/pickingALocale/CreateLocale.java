package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.pickingALocale;

import java.util.Locale;

class CreateLocale {

    static Locale locale;

    static void print() {
        System.out.println(locale + "\n");
    }

    static void m() {
        locale = Locale.GERMAN;  //de
        print();

        locale = Locale.GERMANY;  //de_DE
        print();

        locale = new Locale("fr");  //fr
        print();

        locale = new Locale("hi", "IN");  //hi_IN
        print();

        locale = new Locale.Builder()
                .setLanguage("en")
                .setRegion("US")
                .build();  //en_US
        print();

        locale = new Locale.Builder()
                .setRegion("US")
                .setLanguage("en")
                .build();
        print();  //en_US

        //bad, but legal: the Lacale.Builder converts from upper case or lower case as needed
        locale = new Locale.Builder()
                .setLanguage("EN")
                .setRegion("us")
                .build(); //en_US
        print();

        locale = new Locale.Builder().build();  //Beware!!! prints nothing
        print();
    }

    static void m2(){
        locale = new Locale("FR");
        print();

        locale = new Locale("FR", "fr");  //fr_FR, but probably isn't recommended
        print();
    }


    public static void main(String[] args) {
//        m();
        m2();
    }

}
