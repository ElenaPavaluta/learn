package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.producingReturnValuesFromTasks;

import java.util.concurrent.Callable;

class TaskWithResult implements Callable<String> {

    private int id;

    TaskWithResult(int id){
        this.id = id;
    }

    @Override
    public String call() {
        return "result of TaskWithResult " + id;
    }
}
