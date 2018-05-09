package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.blockingQueuesOfToast.ex.ex_29;

class SliceOfBread  {

    private Status status;
    private int count;

    SliceOfBread(int count, Status status) {
        this.count = count;
        this.status = status;
    }

    int getCount() {
        return count;
    }

    Status getStatus() {
        return status;
    }

    void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SliceOfBread{" +
                "status=" + status +
                ", count=" + count +
                '}';
    }
}
