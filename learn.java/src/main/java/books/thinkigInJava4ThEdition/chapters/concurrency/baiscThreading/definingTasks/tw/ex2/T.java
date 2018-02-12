package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.definingTasks.tw.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class T implements Runnable {

    int n;
    int id;

    public T(int id, int n) {
        this.id = id;
        this.n = n;
        System.out.println("create id: " + id + " n: " + n);
    }

    @Override
    public void run() {
        List<Integer> lst = new ArrayList<>();
        lst.add(0);
        lst.add(1);
        for(int i = 2; i<n; i++){
            lst.add(lst.get(i-1).intValue() + lst.get(i-2).intValue());
        }
        lst.stream().forEach(i-> System.out.println("id: " + id + " i: " + i));
    }
}
