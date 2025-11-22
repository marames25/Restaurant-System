package restaurant.observer;

import restaurant.ordering.Order;

public class Kitchen implements Observer {
    private final String station;

    public Kitchen(String station) {
        this.station = station;
    }
    @Override
    public void update(Order order) {
        System.out.println("Kitchen station " + station + " received order to prepare. Items count: " + order.getItemsCount());
    }
}
