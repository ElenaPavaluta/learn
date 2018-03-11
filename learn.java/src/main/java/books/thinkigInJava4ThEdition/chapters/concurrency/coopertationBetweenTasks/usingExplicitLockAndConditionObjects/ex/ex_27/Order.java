package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingExplicitLockAndConditionObjects.ex.ex_27;

class Order {

    private final int orderNb;

    public Order(int orderNb) {
        this.orderNb = orderNb;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNb=" + orderNb +
                '}';
    }
}
