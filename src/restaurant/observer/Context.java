package restaurant.observer;

import restaurant.ordering.Order;
import java.util.List;

public class Context {

    private List<Observer> observers;

    public void subscribe(Observer observer) { }
    public void unsubscribe(Observer observer) { }
    public void notifyObservers(Order order) { }
}
