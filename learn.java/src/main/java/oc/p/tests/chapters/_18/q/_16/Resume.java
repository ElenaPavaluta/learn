package oc.p.tests.chapters._18.q._16;

import utils.resources.files.Resources;

import java.io.File;
import java.io.IOException;

class Resume {

    static String path = Resources.srcMainResourcesPath(new Resume());
    static File f, f2, f3;

    static void m() throws IOException {
        f = new File(path + File.separator + "t/p");
        f.mkdirs();
        f2 = new File(path + File.separator + "t");
        f.mkdir();
        f3 = new File(f2, "draft.doc");
        f3.createNewFile();
        f.delete();
        f2.delete();
    }

    static void runM(){
        try{
            m();
        }catch (Exception e){
            new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        runM();

        Resources.clean();
    }
}
