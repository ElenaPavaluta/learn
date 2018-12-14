package oc.p.tests.chapters._22.q._8;

import utils.resources.files.Resources;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

class Q {

    static Path path;

    static {
        path = Resources.pathOfPropertyResourceBundle(new Q(), "q_de_DE" );
    }

    static void write(){
        try(BufferedWriter bw = Files.newBufferedWriter(path)){
            bw.write("mystery = bag");
            bw.newLine();
            bw.write("type=bag");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void read(){
        System.out.println(path);
        System.out.println(Locale.GERMANY);
        System.out.println(Resources.pathToPropertyResourceBundle(path));
        final ResourceBundle bundle = ResourceBundle.getBundle(Resources.pathToPropertyResourceBundle(path), Locale.GERMANY);
        System.out.println(bundle.getString("mystery"));
//        System.out.println(bundle.getString("non Existent"));

        Properties props = new Properties();
        bundle.keySet().stream()
                .forEach(k-> props.put(k, bundle.getString(k)));

        System.out.println(props.getProperty("mystery"));
        System.out.println(props.getProperty("non Existent"));
    }

    public static void main(String[] args) {
        write();
        read();

//        Resources.clean();
    }
}
