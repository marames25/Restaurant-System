package restaurant.observer;

import restaurant.ordering.Order;

public interface Observer {
    void update(Order order);
}
