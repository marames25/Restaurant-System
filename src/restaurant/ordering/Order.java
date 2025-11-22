package restaurant.ordering;

import restaurant.items.FoodItem;
import java.util.List;

public abstract class Order {

    protected List<FoodItem> items;

    public abstract double getTax();
}
