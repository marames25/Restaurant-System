package restaurant.ordering.factory;

import restaurant.items.FoodItem;
import restaurant.items.factory.ItemsFactory;
import restaurant.ordering.Order;
import restaurant.ordering.DineIn;
import restaurant.ordering.Delivery;
import restaurant.ordering.Takeaway;
import restaurant.observer.Context;

public class OrderPlacer {

    private ItemsFactory itemsFactory;
    private final Context context;

    public OrderPlacer(ItemsFactory itemsFactory, Context context) {
        this.itemsFactory = itemsFactory;
        this.context = context;
    }

     // Place order by item id and order type string: "dine in"|"delivery"|"takeaway"




    public Order placeOrder(String itemId, String OrderType) {
        FoodItem foodItem = itemsFactory.getItem(itemId);
        Order order;
        if("Delivery".equals(OrderType)) order = new Delivery();
        else if("Takeaway".equals(OrderType)) order = new Takeaway();
        else order = new DineIn();

        if(item != null) order.addItem(foodItem);

        // notify observers about the newly placed order
        context.notifyObservers(order);
        return order;

    }
}
