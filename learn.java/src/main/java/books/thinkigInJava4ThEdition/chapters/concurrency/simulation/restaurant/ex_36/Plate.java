package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

class Plate {

    private final OrderTicket orderTicket;
    private final Food food;

    public Plate(OrderTicket orderTicket, Food food) {
        this.orderTicket = orderTicket;
        this.food = food;
    }

    public OrderTicket getOrderTicket() {
        return orderTicket;
    }

    public Food getFood() {
        return food;
    }

    @Override
    public String toString() {
        return food.toString();
    }
}
