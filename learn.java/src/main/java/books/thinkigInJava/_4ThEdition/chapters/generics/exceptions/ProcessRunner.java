package books.thinkigInJava._4ThEdition.chapters.generics.exceptions;

import java.util.ArrayList;
import java.util.List;

class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T, E>>{
    List<T> processAll() throws E{
       List<T> resultCollector = new ArrayList<>();
       for(Processor<T, E>  processor:this){
           processor.process(resultCollector);
       }
       return resultCollector;
    }
}
