package utils.resources.files.tw;

import utils.resources.files.Resources;
import java.io.File;

import static utils.resources.files.Resources.SRC_MAIN_JAVA;
import static utils.resources.files.Resources.SRC_MAIN_RESOURCES;

class A {

    void dir(){
        File dir = Resources.Files.directory(this.getClass().getPackage().getName());
    }

    void del(){
        Resources.Files.delAll();
    }

    public static void main(String[] args) {
        A a = new A();

        a.dir();
        a.del();
    }
}
