package books.thinkigInJava4ThEdition.chapters.concurrency.sharingResources.criticalSections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

abstract class PairManager {

    protected AtomicInteger atomicInteger = new AtomicInteger(0);
    protected Pair p = new Pair();

    private List<Pair> storage = Collections.synchronizedList(new ArrayList<>());

    synchronized Pair getPair(){
        return new Pair(p.getX(), p.getY());
    }

    //Assume this is a time consuming operation
    protected void store(Pair p){
        storage.add(p);
        try{
            TimeUnit.MILLISECONDS.sleep(50);
        }catch(InterruptedException e){

        }
    }

    protected abstract void increment();
}
