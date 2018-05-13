package books.thinkigInJava._4ThEdition.chapters.generics.exceptions;

import java.util.List;

interface Processor<T, E extends Exception> {

    void process(List<T> resultCollector) throws E;
}
