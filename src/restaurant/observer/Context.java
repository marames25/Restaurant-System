package restaurant.observer;

import restaurant.ordering.Order;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Context {

    private final List<Observer> observers = new CopyOnWriteArrayList<>();

    public void subscribe(Observer observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers(Order order) {
        for (Observer o : observers) {
            o.update(order);
        }
    }
}
