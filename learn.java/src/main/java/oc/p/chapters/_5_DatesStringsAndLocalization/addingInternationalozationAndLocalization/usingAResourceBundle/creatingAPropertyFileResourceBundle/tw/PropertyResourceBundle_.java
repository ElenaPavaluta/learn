package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAPropertyFileResourceBundle.tw;

import utils.resources.files.Resources;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

class PropertyResourceBundle_ {

    static Path path = Paths.get(Resources.SRC_MAIN_RESOURCES, "bla_de_DE.properties");
    static Properties properties = new Properties();

    static {
        try {
            if (!Files.exists(path)) path = Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            bw.write("p: property p");
            bw.newLine();
            bw.write("p2: property p2");
            bw.newLine();
            bw.write("p3: property p3");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void m() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("bla", Locale.GERMANY);
        System.out.println(resourceBundle instanceof ResourceBundle);  //true
        System.out.println(resourceBundle instanceof PropertyResourceBundle);  //true
        System.out.println(resourceBundle instanceof ListResourceBundle);  //false
        System.out.println(resourceBundle.getClass().getSimpleName());
    }

    static void m2() {
        PropertyResourceBundle propertyResourceBundle = peropertyResourceBundle();
        System.out.println(propertyResourceBundle.getBaseBundleName());

        properties = propertyResourceBundle.keySet().stream()
                .collect(Properties::new,
                        (p, k) -> {
                            p.putIfAbsent(k, propertyResourceBundle.getString(k));
                            return;
                        },
                        (p, p2) -> p2.forEach((k, v) -> p.putIfAbsent(k, v)));

        properties.forEach((k, v) -> System.out.println(k + " ->  " + v));
    }

    static void m3() {
        PropertyResourceBundle propertyResourceBundle = peropertyResourceBundle();

        final Properties reduce = propertyResourceBundle.keySet().stream()
                .reduce(new Properties(),
                        (p, k) -> {
                            p.putIfAbsent(k, propertyResourceBundle.getString(k));
                            return p;
                        },
                        (p, p2) -> {
                            p2.forEach((k, v) -> p.putIfAbsent(k, v));
                            return p;
                        });
        reduce.forEach((k, v) -> System.out.println(k + " " + v));
    }

    private static PropertyResourceBundle peropertyResourceBundle() {
        return (PropertyResourceBundle) PropertyResourceBundle.getBundle("bla", new Locale("de", "DE"));
    }

    public static void main(String[] args) {
        m();
        m2();
        m3();
        Resources.cleanSrcMainResources();
    }
}
