package oc.p.chapters.c_8_IO.workingWithStreams.reviewOfTheStreamClasses;

import java.io.*;

class ReaderClass {

    Reader reader;  //abstract class

    /**
     * Takes an InputStream as param and returns a Reader
     */
    InputStreamReader inputStreamReader;  //extends Reader

    FileReader fileReader;  //extends InputStreamReader

    BufferedReader bufferedReader;


    {
        InputStream inputStream = null;
        inputStreamReader = new InputStreamReader(inputStream);

        reader = new InputStreamReader(inputStream);
    }
}
