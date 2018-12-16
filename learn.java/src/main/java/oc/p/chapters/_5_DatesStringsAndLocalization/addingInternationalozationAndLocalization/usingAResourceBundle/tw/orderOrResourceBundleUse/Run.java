package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.tw.orderOrResourceBundleUse;

import utils.resources.files.Resources;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

class Run {
    static Run r = new Run();

    static void createPropertyResourceBundle() {

        Path path = Resources.pathOfPropertyResourceBundle(r, "Prop_fr_FR");
        Path path2 = Resources.pathOfPropertyResourceBundle(r, "Prop_fr");
        Path path3 = Resources.pathOfPropertyResourceBundle(r, "Prop_en_US");
        Path path4 = Resources.pathOfPropertyResourceBundle(r, "Prop_en");
        Path path5 = Resources.pathOfPropertyResourceBundle(r, "Prop");

        try (BufferedWriter bw = Files.newBufferedWriter(path);
             BufferedWriter bw2 = Files.newBufferedWriter(path2);
             BufferedWriter bw3 = Files.newBufferedWriter(path3);
             BufferedWriter bw4 = Files.newBufferedWriter(path4);
             BufferedWriter bw5 = Files.newBufferedWriter(path5)) {

            bw.write("2 : fr_FR");
            bw2.write("4: fr");
            bw3.write("6: en_US");
            bw4.write("8: en");
            bw5.write("10: default");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void m() {
        ListResourceBundle lrb = (ListResourceBundle) ResourceBundle.getBundle(Resources.pathToListResourceBundle(r.getClass().getPackage(), "Prop"), Locale.FRANCE);
        System.out.println(lrb.getObject("1"));
        System.out.println(lrb.getObject("3"));
        System.out.println(lrb.getObject("5"));
        System.out.println(lrb.getObject("7"));
        System.out.println(lrb.getObject("9"));
    }

    static void m2() {
        PropertyResourceBundle prb = (PropertyResourceBundle) ResourceBundle.getBundle(Resources.pathToPropertyResourceBundle(r.getClass().getPackage(), "Prop"), Locale.FRANCE);
        System.out.println(prb.getObject("2"));
        System.out.println(prb.getObject("4"));
        System.out.println(prb.getObject("6"));
        System.out.println(prb.getObject("8"));
        System.out.println(prb.getObject("10"));
    }

    public static void main(String[] args) {
//        createPropertyResourceBundle();

        m();
//        m2();
    }
}
