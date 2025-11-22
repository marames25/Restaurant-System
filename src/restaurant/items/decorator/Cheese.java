package restaurant.items.decorator;

import restaurant.items.FoodItem;

public class Cheese extends AddOnDecorator {
    public Cheese(FoodItem item) { super(item); }
}
