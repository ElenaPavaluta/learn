package utils.resources.files.tw;

import utils.resources.files.Resources;
import java.nio.file.Path;

class B {

    static void m(){
       Path p = Resources.NIO.File.Path.file(new B().getClass().getPackage(), "b.txt");
       Resources.recursiveDelete(p);
    }

    public static void main(String[] args) {
        m();
    }
}
