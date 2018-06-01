package utils.resources.files.tw;

import utils.resources.files.Resources;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class TestPathRecursiveDelete {

    static void m(){
        Path p = Paths.get("ala/bala/portocala");
        Resources.NIO2.Path.recursiveDelete(p);
    }

    public static void main(String[] args) {
        m();
    }
}
