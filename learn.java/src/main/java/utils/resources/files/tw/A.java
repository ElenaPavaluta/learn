package utils.resources.files.tw;

import utils.resources.files.Resources;

class A {

    java.io.File file;

    public static void main(String[] args) throws InterruptedException {
        A a = new A();

//        a.dir();
        a.file();

        Resources.clean();

    }

    void dir() {
        java.io.File dir = Resources.File.directory(this.getClass().getPackage().getName());
    }

    void del() {
    }

    void file() throws InterruptedException {
        file = Resources.File.file(this.getClass().getPackage().getName() + "\\test\\p2\\p3\\p4", "a.txt");

        /**
         * Deletes the last file (either a file or a file)
         */
//        file.delete();
    }
}
