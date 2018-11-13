package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAPropertyFileResourceBundle.tw;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.function.BiFunction;

class Properties_ {

    public static final BiFunction <Object, Object, Object> BI_FUNCTION = (o, n) -> o + "_" + n;
    static Path path = Resources.propertiesFileAsPath("q_en_US");

    static {
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            bw.write("a A");
            bw.newLine();
            bw.write("b B");
            bw.newLine();
            bw.write("c C");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void m() {
        System.out.println(Locale.getDefault());
        PropertyResourceBundle prb = propertyResourceBundle();
        System.out.println(prb.getBaseBundleName());
        Delimitators.equal();
    }

    private static PropertyResourceBundle propertyResourceBundle() {
        return (PropertyResourceBundle) ResourceBundle.getBundle("q");
    }

    static void m2() {
        final PropertyResourceBundle propertyResourceBundle = propertyResourceBundle();
        final Properties properties = propertyResourceBundle.keySet().stream()
                .collect(Properties::new,
                        (p, k) -> p.putIfAbsent(k, propertyResourceBundle.getString(k)),
                        (p, p2) -> p2.forEach((k, v) -> p.putIfAbsent(k, v)));

        properties.merge("a", "AA", BI_FUNCTION);
        properties.merge("b", "BB", BI_FUNCTION);
        properties.merge("c", "CC", BI_FUNCTION);
        properties.merge("d", "DD", BI_FUNCTION);

        System.out.println(properties.getProperty("a"));
        System.out.println(properties.getProperty("e", "default"));

        System.out.println(properties.get("c"));
        System.out.println(properties.getOrDefault("f", "default Object"));

        Delimitators.equal();
        System.out.println(properties.getProperty("not exists"));
    }

    public static void main(String[] args) {
        m();
        m2();

//        Resources.clean();
    }
}
