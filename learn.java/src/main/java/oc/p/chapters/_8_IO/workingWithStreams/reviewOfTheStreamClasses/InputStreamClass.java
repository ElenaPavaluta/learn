package oc.p.chapters._8_IO.workingWithStreams.reviewOfTheStreamClasses;

import java.io.*;

class InputStreamClass {

    InputStream inputStream;  //abstract class

    FileInputStream fileInputStream; //low level

    FilterInputStream filterInputStream;  //not on OCP

    BufferedInputStream bufferedInputStream;  //extends FilerInputStream extends InputStream

    ObjectInputStream objectInputStream;  //high level

    {
        inputStream = System.in;
    }
}
