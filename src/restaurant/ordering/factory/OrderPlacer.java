package restaurant.ordering.factory;

import restaurant.items.FoodItem;
import restaurant.items.decorator.AddOnDecorator;
import restaurant.items.factory.ItemsFactory;
import restaurant.ordering.Order;
import restaurant.ordering.DineIn;
import restaurant.ordering.Delivery;
import restaurant.ordering.Takeaway;
import restaurant.observer.Context;

public class OrderPlacer extends Context{

    private ItemsFactory itemsFactory;

    public OrderPlacer(ItemsFactory itemsFactory) {
        this.itemsFactory = itemsFactory;
    }

     // Place order by item id and order type string: "dine in"|"delivery"|"takeaway"




    public Order placeOrder(String[][] items, String orderType) {
        // Determine order type
        Order order;
        if ("Delivery".equalsIgnoreCase(orderType)) {
            order = new Delivery();
        } else if ("Takeaway".equalsIgnoreCase(orderType)) {
            order = new Takeaway();
        } else {
            order = new DineIn();
        }

        // Build each ordered item
        for (String[] row : items) {
            if (row.length == 0) continue;  

            // 1) Main item
            String baseId = row[0];
            FoodItem item = itemsFactory.getItem(baseId);

            if (item == null) {
                System.out.println("[WARN] Unknown item id: " + baseId);
                continue;
            }

            // 2) Apply decorators (add-ons)
            FoodItem decorated = item;

            for (int i = 1; i < row.length; i++) {
                String addId = row[i];

                FoodItem addon = itemsFactory.getItem(addId);

                if (addon == null) {
                    System.out.println("[WARN] Unknown add-on id: " + addId);
                    continue;
                }

                // Each add-on is a decorator so attach the previous chain
                if (addon instanceof AddOnDecorator decor) {
                    decor.setFoodItem(decorated);
                    decorated = decor;
                } else {
                    System.out.println("[WARN] " + addId + " is not an add-on decorator.");
                }
            }

            // Add final decorated food item to order
            order.addItem(decorated);
        }

        // Notify observers
        

        return order;
    }   

}
