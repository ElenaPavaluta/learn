package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.bankTeller;

import java.util.concurrent.ArrayBlockingQueue;

//Teach the customer line to display itself
class CustomerLine extends ArrayBlockingQueue<Customer> {
    public CustomerLine(int capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        if(this.size() == 0) {
            return "[Empty]";
        }
        StringBuilder sb = new StringBuilder();
        this.stream().forEach(sb::append);
        return sb.toString();
    }
}
