package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.blockingQueuesOfToast;

import static books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.blockingQueuesOfToast.Toast.Status.BUTTERED;
import static books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.blockingQueuesOfToast.Toast.Status.DRY;
import static books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.blockingQueuesOfToast.Toast.Status.JAMED;

class Toast {

    enum Status{
        DRY,
        BUTTERED,
        JAMED
    }

    private Status status = DRY;
    private final int id;

    public Toast(int id) {
        this.id = id;
    }


    void buttered(){
        status = BUTTERED;
    }

    void jam(){
        status = JAMED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast{" +
                "status=" + status +
                ", id=" + id +
                '}';
    }
}
