package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAPropertyFileResourceBundle;

import utils.resources.files.Resources;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

class Use {

    static Properties properties;
    static ResourceBundle resourceBundle;
    static Path path;

    static void init() {
        path = Resources.pathOfPropertyResourceBundle("q_de_DE");
        System.out.println(path.toString());
        try {
            path = Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            bw.write("p:q_de_DE");
            bw.newLine();
            bw.write("p2:q_de_DE_2");

        } catch (IOException e) {
            e.printStackTrace();
        }

        Locale.setDefault(Locale.GERMANY);
    }

    static void m() {
        resourceBundle = ResourceBundle.getBundle("iq");
        properties = new Properties();
        resourceBundle.keySet().stream()
                .forEach(k -> properties.put(k, resourceBundle.getString(k)));

        System.out.println(properties.get("p"));
        System.out.println(properties.get("p2"));
        System.out.println(properties.getProperty("p3", "this is the default value in case p3 does not exits"));
    }

    static void m2() {
        resourceBundle = ResourceBundle.getBundle("iq");
        resourceBundle.keySet().forEach(k -> System.out.println(resourceBundle.getString(k)));
    }

    public static void main(String[] args) {
        init();
        m();
//        m2();
        Resources.clean();
    }
}
