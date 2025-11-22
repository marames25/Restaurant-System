package restaurant.observer;

import restaurant.ordering.Order;

public class Waiter implements Observer {
    private final String name; // valu can not be changed

    public Waiter(String name) {
        this.name = name;
    }
    @Override
    public void update(Order order) {
        System.out.println("Waiter " + this.name + " received order. Order total: " + order.getTotalPrice());
    }
}
