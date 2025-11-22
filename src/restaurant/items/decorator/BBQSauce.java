package restaurant.items.decorator;

import restaurant.items.FoodItem;

public class BBQSauce extends AddOnDecorator {
    public BBQSauce(FoodItem item) { super(item); }
}
