package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

class Pool<T> {
    private int size;
    private List<T> items = new ArrayList<>();
    private volatile boolean[] checkedOut;
    private Semaphore available;

    Pool(Class<T> classObject, int size) {
        this.size = size;
        checkedOut = new boolean[size];
        available = new Semaphore(size, true);
        //load pool with objects that can be checked out
        for(int i = 0; i < size; i++) {
            try {
                //assume a default constructor
                items.add(classObject.newInstance());
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    T checkOut() throws InterruptedException {
        available.acquire();
        return getItem();
    }

    void checkIn(T t) {
        if(releaseItem(t)) {
            available.release();
        }
    }

    private synchronized T getItem() {
        for(int i = 0; i < size; ++i) {
            if(!checkedOut[i]) {
                checkedOut[i] = true;
                return items.get(i);
            }
        }
        return null;
    }

    private synchronized boolean releaseItem(T item) {
        int index = items.indexOf(item);
        if(index == -1) return false; //not in the list
        if(checkedOut[index]) {
            checkedOut[index] = false;
            return true;
        }
        return false;  //wasn't checked out
    }

}
