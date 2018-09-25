package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.tw._1;

import utils.resources.files.Resources;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

class Test {

    static Path path, path2;

    static void init() throws IOException {
        path = Paths.get(Resources.SRC_MAIN_RESOURCES, "a_fr.properties");
        path2 = Paths.get(Resources.SRC_MAIN_RESOURCES, "a_fr_FR.properties");

        if (!Files.exists(path)) {
            path = Files.createFile(path);
        }

        if (!Files.exists(path2)) {
            path2 = Files.createFile(path2);
            try (BufferedWriter bw = Files.newBufferedWriter(path2)) {
                bw.write("p: pFr \n p2:p2Fr");
            }
        }
    }

    static void m() throws IOException {
        ResourceBundle re = ResourceBundle.getBundle("a", Locale.FRANCE);
        Properties prop = new Properties();
        re.keySet().stream().forEach(k -> prop.put(k, re.getString(k)));

        System.out.println(prop.getProperty("p"));
        System.out.println(prop.getProperty("p2"));
    }

    public static void main(String[] args) throws IOException {
        init();
        m();
        Resources.recursiveDelete(path, path2);
    }
}
