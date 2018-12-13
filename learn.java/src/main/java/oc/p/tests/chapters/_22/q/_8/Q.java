package oc.p.tests.chapters._22.q._8;

import utils.resources.files.Resources;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

class Q {

    static Path path;

    static {
        path = Resources.pathOfPropertyResourceBundle(new Q(), "q_de_De" );
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
        final ResourceBundle bundle = ResourceBundle.getBundle(Resources.pathToPropertyResourceBundle(path), Locale.GERMANY);
    }

    public static void main(String[] args) {
        write();
        read();

//        Resources.clean();
    }
}
