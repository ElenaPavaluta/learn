package utils.resources.files.tw;

import utils.resources.files.Resources;

class A {

    java.io.File file;

    public static void main(String[] args) throws InterruptedException {
        A a = new A();

//        a.dir();
        a.file();

        Resources.Files.recursiveDelete(a.file);

    }

    void dir() {
        java.io.File dir = Resources.Files.directory(this.getClass().getPackage().getName());
    }

    void del() {
    }

    void file() throws InterruptedException {
        file = Resources.Files.file(this.getClass().getPackage().getName() + "\\p\\p2\\p3\\p4", "a.txt");

        /**
         * Deletes the last file (either a file or a directory)
         */
//        file.delete();
    }
}