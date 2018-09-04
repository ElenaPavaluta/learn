package oc.p.chapters._7_Concurrency.usingConcurrentCollections.workingWithConcurrentClasses.set.tw;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

class CopyOnWriteArraySetTest {

    Set<Integer> set = new CopyOnWriteArraySet<>();
    {
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
    }

    void m(){
        new Read("Read", set).start();
        new Write("Write", set).start();
    }

    public static void main(String[] args) {
        CopyOnWriteArraySetTest test = new CopyOnWriteArraySetTest();
        test.m();
    }
}

class Write extends Thread{

    private Set<Integer> set;

    Write(final String name, final Set<Integer> set) {
        super(name);
        this.set = set;
    }

    @Override
    public void run() {
        int count  = 6;
        while (true){
            try {
                TimeUnit.SECONDS.sleep(3);
                set.add(count++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " done");
        }
    }
}

class Read extends Thread{
    private Set<Integer> set;

    Read(final String name, final Set<Integer> set) {
        super(name);
        this.set = set;
    }

    @Override
    public void run() {
        while (true){
            String out = "\n" + super.getName() + ":";
            Iterator<Integer> it = set.iterator();

            while (it.hasNext()){
                Integer next = it.next();
                out += " " + next;
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(out);
        }
    }
}
