package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.linkingStreamsToTheUnderlyingData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class LinkingStreamsToTheUnderlyingData {

    static void m(){
        List<String> cats = new ArrayList<>();
        cats.add("Annie");
        cats.add("Ripley");

        Stream<String> stream = cats.stream();

        cats.add("Kc");

        System.out.println(stream.count());  //3: die to the fact that the streams are lazy evaluated
    }

    public static void main(String[] args) {
        m();
    }

}
