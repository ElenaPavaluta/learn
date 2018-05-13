package books.thinkigInJava._4ThEdition.chapters.generics.exceptions;

import java.util.List;

class ProcessorImpl implements Processor<String, Failure> {
    static int count  = 3;


    @Override
    public void process(List<String> resultCollector) throws Failure {
        if(count-->3){
            resultCollector.add("Help");
        }else{
            resultCollector.add("Ho");
        }
        if(count<0){
            throw new Failure();
        }
    }
}
