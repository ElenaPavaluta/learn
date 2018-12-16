package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.tw.propertyVsList;

import utils.print.Print;
import utils.resources.files.Resources;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class PropertyResourceBundleVsListResourceBundle {

    static String name = "name_en_US";
    static Package pkg = new PropertyResourceBundleVsListResourceBundle().getClass().getPackage();
    static PropertyResourceBundleVsListResourceBundle obj = new PropertyResourceBundleVsListResourceBundle();
    static Path prbPath;

    static void writePRB() {
        prbPath = Resources.pathOfPropertyResourceBundle(obj, name);
        try (BufferedWriter bw = Files.newBufferedWriter(prbPath)) {
            bw.write("a: A");
            bw.newLine();
            String[] arr = new String[]{"this", "is", "a", "String", "arr"};
            bw.write("sa: this is a string array");
//            bw.write("sa: " + arr);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void readPRB() {
        writePRB();
        PropertyResourceBundle prb = (PropertyResourceBundle) ResourceBundle.getBundle(Resources.pathToPropertyResourceBundle(pkg, "name"));
        System.out.println(prb.getBaseBundleName());

        System.out.println(prb.getString("a"));

        System.out.println(prb.getObject("a"));
        System.out.println(prb.getKeys());

        System.out.println(prb.handleGetObject("a"));

        /**
         * Implemented only in the abstract class ResourceBundle
         * so RE for PropertyResourceBundle
         */
//        System.out.println(Arrays.toString(prb.getStringArray("sa")));

//        System.out.println(prb.getString("b"));  //NPE
    }

    static void readLRB() {
        ListResourceBundle lrb = (ListResourceBundle) ResourceBundle.getBundle(Resources.pathToListResourceBundle(pkg, "Name"));
        System.out.println(lrb.getBaseBundleName());

        System.out.println(lrb.getString("a"));

        System.out.println(lrb.getObject("a"));
        System.out.println(lrb.getKeys());

        System.out.println(lrb.handleGetObject("a"));

        System.out.println(Arrays.toString(lrb.getStringArray("sa")));

//        System.out.println(lrb.getString("b"));  //NPE
    }


    static void m() {
        PropertyResourceBundle prb = (PropertyResourceBundle) ResourceBundle.getBundle(Resources.pathToPropertyResourceBundle(pkg, "name"));
        ListResourceBundle lrb = (ListResourceBundle) ResourceBundle.getBundle(Resources.pathToListResourceBundle(pkg, "Name"));


        final Map <String, Object> map = prb.keySet().stream()
                .collect(Collectors.toMap(Function.identity(), prb::getObject));

        Properties pPrb = new Properties();
        map.forEach((k, v) -> pPrb.putIfAbsent(k, v));
    }

    public static void main(String[] args) {
        readPRB();
        Print.Delimitators.equal();
//        readLRB();
    }
}
