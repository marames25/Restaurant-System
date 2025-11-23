//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.List;

import restaurant.items.FoodItem;
import restaurant.items.factory.ItemsFactory;
import restaurant.menu.handler.MenuHandler;
import restaurant.ordering.Order;
import restaurant.ordering.factory.OrderPlacer;

public class Main {
    public static void main(String[] args) {
        MenuHandler mh = new MenuHandler();
        String[][] choices =  mh.takeUserOrders();
        OrderPlacer op = new OrderPlacer(ItemsFactory.getInstance());
        Order order = op.placeOrder(choices, "Delivery");
        List<FoodItem> items = order.getItems();
        for (FoodItem i : items) {
            System.out.println(i.getPrice());
        }
    }
}