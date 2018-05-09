package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.atomicityAndVolatility.volatility;

import java.util.stream.IntStream;

class CircularSet {

    private int[] array;
    private int len;
    private int indx = 0;

    CircularSet(int size){
        array = new int[size];
        len = size;
        IntStream.range(0,size)
                 .forEach(i->array[i]=-1);
    }

    synchronized void add(int i){
        array[indx] = i;
        indx = ++indx%len;
    }

    synchronized boolean contains(int val){
        for(int i = 0; i<len; i++){
            if(array[i] == val) return true;
        }
        return false;
    }
}
