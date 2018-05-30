package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.usingPathObjects.accesingPathComponents;

import oc.p.chapters._9_NIO2.util.TestPath;
import java.nio.file.Path;

/**
 * Path	getFileName()
 *
 * Path	getParent()
 *
 * Path	getRoot()
 */
class AccessThePath {

    static void print(Path path){
        System.out.println(path);
    }

    static void getFileName(){
       print(TestPath.Absolute_Linux_Path.getFileName());
       print(TestPath.Relative_Linux_Path.getFileName());
       print(TestPath.Absolute_Windows_Path.getFileName());
       print(TestPath.Relative_Windows_Path.getFileName());
       print(TestPath.Empty_Path.getFileName());
    }

    static void getParent(){
        print(TestPath.Absolute_Linux_Path.getParent());
        print(TestPath.Relative_Linux_Path.getParent());
        print(TestPath.Absolute_Windows_Path.getParent());
        print(TestPath.Relative_Windows_Path.getParent());
        print(TestPath.Empty_Path.getParent());
    }

    static void getRoot(){
        print(TestPath.Absolute_Linux_Path.getRoot());
        print(TestPath.Relative_Linux_Path.getRoot());
        print(TestPath.Absolute_Windows_Path.getRoot());
        print(TestPath.Relative_Windows_Path.getRoot());
        print(TestPath.Empty_Path.getRoot());
    }

    static void prinPathInfo(Path path){
        System.out.println("Path: " + path);
        System.out.println("File name: " + path.getFileName());
        System.out.println("Root is: " + path.getRoot());
        Path current = path;
        while((current = current.getParent())!=null){
            System.out.println("Current parent is: " + current);
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        m();

        prinPathInfo(TestPath.Absolute_Linux_Path);
        prinPathInfo(TestPath.Relative_Linux_Path);
        prinPathInfo(TestPath.Absolute_Windows_Path);
        prinPathInfo(TestPath.Relative_Windows_Path);
        prinPathInfo(TestPath.Empty_Path);
    }



    static void m() {
        getFileName();
        System.out.println();
        getParent();
        System.out.println();
        getRoot();
        System.out.println();
    }
}
